package vista;

import java.awt.Font;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.Bidalketak;
import modelo.HorarioDTO;
import modelo.UserDTO;

public class BesteOrdutegiakV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableOrdutegia;
    private int profesorId;
    private UserDTO usuario; //usuario logueado

    public BesteOrdutegiakV(UserDTO usuario, int profesorId) {
        this.usuario = usuario;
        this.profesorId = profesorId;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

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
        tableOrdutegia.setRowHeight(60); // Filas más altas para que se lea bien
        scrollPane.setViewportView(tableOrdutegia);

        JLabel lbl = new JLabel("Irakaslearen Ordutegia");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lbl.setBounds(278, 11, 300, 40);
        contentPane.add(lbl);

        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(699, 11, 126, 40);
        btnAtzera.addActionListener(e -> atzera());
        contentPane.add(btnAtzera);

        // Cargar datos al iniciar
        cargarHorario();
    }

    private void cargarHorario() {
        Bidalketak bidal = new Bidalketak();
        
        
        List<HorarioDTO> horarios = bidal.obtenerHorarioProfesor(profesorId);

        if (horarios != null) {
            DefaultTableModel model = (DefaultTableModel) tableOrdutegia.getModel();
            
            for (HorarioDTO h : horarios) {
                if (h.getDia() == null) continue;

               
                int hora = h.getHora(); 
                String dia = h.getDia(); 
                String contenido = h.getModulo();
                
                // Añadir aula si existe
                if (h.getAula() != null && !h.getAula().isEmpty()) {
                    contenido += " (" + h.getAula() + ")";
                }

                
                int fila = hora - 1;
                
                
                int col = 0;
                switch (dia.toUpperCase()) {
                    case "LUNES": case "MONDAY": case "ASTELEHENA": col = 1; break;
                    case "MARTES": case "TUESDAY": case "ASTEARTEA": col = 2; break;
                    case "MIERCOLES": case "WEDNESDAY": case "ASTEAZKENA": col = 3; break;
                    case "JUEVES": case "THURSDAY": case "OSTEGUNA": col = 4; break;
                    case "VIERNES": case "FRIDAY": case "OSTIRALA": col = 5; break;
                }

               
                if (col > 0 && fila >= 0 && fila < model.getRowCount()) {
                    // Si ya hay algo (ej: reunión), lo concatenamos
                    Object valorActual = model.getValueAt(fila, col);
                    if (valorActual != null && !valorActual.toString().isEmpty()) {
                        model.setValueAt(valorActual + " / " + contenido, fila, col);
                    } else {
                        model.setValueAt(contenido, fila, col);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ezin izan da ordutegia kargatu.");
        }
    }

    private void atzera() {
        dispose();
       
        MenuV menu = new MenuV(usuario);
        menu.setVisible(true);
        
        
    }
}