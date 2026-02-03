package vista;

import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.Bidalketak;
import modelo.HorarioDTO;
import modelo.ReunionDTO; 
import modelo.UserDTO;

public class ZureOrdutegiaV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableOrdutegia;
    private UserDTO usuario;

    
    private Bidalketak bidalketak = new Bidalketak();

    public ZureOrdutegiaV(UserDTO usuario) {
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // --- BOTÓN ATRÁS ---
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.addActionListener(e -> atzera());
        btnAtzera.setBounds(699, 11, 126, 40);
        contentPane.add(btnAtzera);

        // --- TABLA ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 62, 833, 427);
        contentPane.add(scrollPane);

        tableOrdutegia = new JTable();
        tableOrdutegia.setEnabled(false);
        tableOrdutegia.setRowSelectionAllowed(false);
        
        
        tableOrdutegia.setModel(new DefaultTableModel(
            new Object[][] {
                {"1. Saioa", null, null, null, null, null},
                {"2. Saioa", null, null, null, null, null},
                {"3. Saioa", null, null, null, null, null},
                {"4. Saioa", null, null, null, null, null},
                {"5. Saioa", null, null, null, null, null},
                {"6. Saioa", null, null, null, null, null},
            },
            new String[] {" ", "Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala"}
        ));
        
        tableOrdutegia.getTableHeader().setReorderingAllowed(false);
        tableOrdutegia.setRowHeight(60);
        scrollPane.setViewportView(tableOrdutegia);

        JLabel lblTitulo = new JLabel("Zure Ordutegia");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(278, 11, 235, 40);
        contentPane.add(lblTitulo);

        // cargar datos al abrir
        if (usuario != null) {
            cargarDatos();
        }
    }

    private void cargarDatos() {
        
        List<HorarioDTO> horarios = bidalketak.obtenerHorarioProfesor(usuario.getId());

        DefaultTableModel model = (DefaultTableModel) tableOrdutegia.getModel();

        if (horarios != null) {
            for (HorarioDTO h : horarios) {
                if (h.getDia() == null) continue;

                String contenido = h.getModulo();
                if (h.getAula() != null && !h.getAula().isEmpty()) {
                    contenido += " (" + h.getAula() + ")";
                }

                pintarCelda(model, h.getDia(), h.getHora(), contenido);
            }
        }

       //cargaReuniones
        List<ReunionDTO> reuniones = bidalketak.obtenerReunionesProfesor(usuario.getId());
        
        if (reuniones != null) {
            for (ReunionDTO r : reuniones) {
                
            }
        }
    }

    
    private void pintarCelda(DefaultTableModel model, String diaBD, int hora, String contenido) {
        int fila = hora - 1; 
        int col = 0;

        
        switch (diaBD.toUpperCase()) {
            case "LUNES": case "MONDAY": case "ASTELEHENA": col = 1; break;
            case "MARTES": case "TUESDAY": case "ASTEARTEA": col = 2; break;
            case "MIERCOLES": case "WEDNESDAY": case "ASTEAZKENA": col = 3; break;
            case "JUEVES": case "THURSDAY": case "OSTEGUNA": col = 4; break;
            case "VIERNES": case "FRIDAY": case "OSTIRALA": col = 5; break;
        }

        if (col > 0 && fila >= 0 && fila < model.getRowCount()) {
            Object valorActual = model.getValueAt(fila, col);
            
            
            if (valorActual != null && !valorActual.toString().isEmpty()) {
                model.setValueAt(valorActual + " / " + contenido, fila, col);
            } else {
                model.setValueAt(contenido, fila, col);
            }
        }
    }

    private void atzera() {
        dispose();
        MenuV menu = new MenuV(usuario);
        menu.setVisible(true);
        
    }
}