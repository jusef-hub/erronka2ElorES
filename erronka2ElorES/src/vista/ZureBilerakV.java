package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import control.Bidalketak;
// import controlFuntzioak.VistaFuntzioak; // Descomenta si usas esta clase para navegación
import modelo.ReunionDTO; // Asegúrate de importar tu DTO
import modelo.UserDTO;

public class ZureBilerakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private UserDTO profesor;

	private Bidalketak bidalketak = new Bidalketak();

	public ZureBilerakV(UserDTO profesor) {
		this.profesor = profesor;

		setTitle("Nire Bilerak"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// --- BOTONES ---

		JButton btnVolver = new JButton("Atzera");
		btnVolver.setBounds(650, 350, 120, 30);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(e -> volverAtras());

		JButton btnSortu = new JButton("Sortu Bilerak");
		btnSortu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSortu.setBounds(30, 350, 159, 30);
		contentPane.add(btnSortu);
		btnSortu.addActionListener(e -> {
			dispose();
			
			new SortuBilerakV(profesor).setVisible(true);
		});

		
		JButton btnAceptar = new JButton("Onartu");
		btnAceptar.setBounds(220, 350, 100, 30);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(e -> cambiarEstadoSeleccionado("Aceptada"));

		JButton btnPendiente = new JButton("Zain");
		btnPendiente.setBounds(330, 350, 100, 30);
		contentPane.add(btnPendiente);
		btnPendiente.addActionListener(e -> cambiarEstadoSeleccionado("Pendiente"));

		JButton btnRechazar = new JButton("Ezeztatu");
		btnRechazar.setBounds(440, 350, 100, 30);
		contentPane.add(btnRechazar);
		btnRechazar.addActionListener(e -> cambiarEstadoSeleccionado("Rechazada"));

		// --- TABLA ---

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 20, 750, 310);
		contentPane.add(scrollPane);

		cargarReuniones();
		configurarRenderizadoTabla();
	}

	private void cargarReuniones() {
		
		List<ReunionDTO> reuniones = bidalketak.obtenerReunionesProfesor(profesor.getId());

		String[] columnas = { "ID", "Izenburua", "Gaia", "Ikaslea", "Data", "Gela", "Egoera" };

		DefaultTableModel model = new DefaultTableModel(columnas, 0) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (reuniones != null) {
			for (ReunionDTO r : reuniones) {
				// Filtro para ignorar registros vacíos o corruptos
				if (r.getId() == 0 && (r.getTitulo() == null || r.getTitulo().trim().isEmpty())) {
					continue;
				}

				String fechaVisual = (r.getFecha() != null) ? r.getFecha() : "---";
				
				
				model.addRow(new Object[]{
                        r.getId(),
                        r.getTitulo(),
                        r.getAsunto(),
                        r.getNombreAlumno(),
                        fechaVisual,
                        r.getAula(),
                        (r.getEstado() != null) ? r.getEstado() : "Pendiente"
                });
			}
		} else {
			JOptionPane.showMessageDialog(this, "Ezin izan dira bilerak kargatu.");
		}

		table.setModel(model);

		// Ocultar columna ID (índice 0)
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);

		// Estilos de la tabla
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setRowHeight(25);
	}

	private void configurarRenderizadoTabla() {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

				// Obtener estado de la columna 6 de forma segura
				Object estadoObj = table.getModel().getValueAt(row, 6);
				String estado = (estadoObj != null) ? estadoObj.toString().toLowerCase() : "";

				if (!isSelected) {
					switch (estado) {
					case "aceptada":
					case "onartuta":
						c.setBackground(new Color(144, 238, 144)); // Verde claro
						break;
					case "rechazada":
					case "ezeztatuta":
						c.setBackground(new Color(255, 182, 193)); // Rojo claro
						break;
					case "pendiente":
					case "zain":
						c.setBackground(new Color(255, 255, 153)); // Amarillo claro
						break;
					default:
						c.setBackground(Color.WHITE);
					}
					c.setForeground(Color.BLACK);
				} else {
					c.setBackground(table.getSelectionBackground());
					c.setForeground(table.getSelectionForeground());
				}

				return c;
			}
		});
	}

	private void cambiarEstadoSeleccionado(String nuevoEstado) {
		int fila = table.getSelectedRow();

		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Aukeratu bilera bat lehenengo.");
			return;
		}

		// Obtener ID de forma segura
		Object idObj = table.getModel().getValueAt(fila, 0);
		if (idObj == null)
			return;

		int reunionId = Integer.parseInt(idObj.toString());

		boolean ok = bidalketak.cambiarEstadoReunion(reunionId, nuevoEstado);

		if (ok) {
			JOptionPane.showMessageDialog(this, "Egoera aldatu da: " + nuevoEstado);
			cargarReuniones(); // Recargar para ver cambios
		} else {
			JOptionPane.showMessageDialog(this, "Errorea egoera aldatzean.");
		}
	}

	private void volverAtras() {
		dispose();
		// Abre el menú principal con el usuario actual
		new MenuV(profesor).setVisible(true);
		// Si usas VistaFuntzioak: new VistaFuntzioak().irekiMenu(profesor);
	}
}