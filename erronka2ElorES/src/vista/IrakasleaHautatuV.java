package vista;

import java.awt.Font;
import java.util.List;
import java.util.Map;

import javax.swing.*;

import control.Bidalketak;
import controlFuntzioak.VistaFuntzioak;
import modelo.UserDTO;

public class IrakasleaHautatuV extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> cBIrakasleak;
    private UserDTO usuario;
    private List<Map<String,Object>> profesoresList;

    public IrakasleaHautatuV(UserDTO usuario) {
        this.usuario = usuario;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 292, 168);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lbl = new JLabel("Irakasle Aukeratu");
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setBounds(67, 11, 136, 24);
        contentPane.add(lbl);

        cBIrakasleak = new JComboBox<>();
        cBIrakasleak.setBounds(51, 46, 168, 24);
        contentPane.add(cBIrakasleak);

        cargarProfesores(); // Rellenamos comboBox

        JButton btnJarraitu = new JButton("Jarraitu");
        btnJarraitu.setBounds(165, 95, 89, 23);
        btnJarraitu.addActionListener(e -> abrirHorario());
        contentPane.add(btnJarraitu);

        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(22, 95, 89, 23);
        btnAtzera.addActionListener(e -> atzera());
        contentPane.add(btnAtzera);
    }

    private void cargarProfesores() {
        Bidalketak bidal = new Bidalketak();
        profesoresList = bidal.obtenerProfesores();
        if(profesoresList != null) {
            for(Map<String,Object> prof : profesoresList) {
                String nombre = (String) prof.get("nombre");
                cBIrakasleak.addItem(nombre);
            }
        }
    }

    private void abrirHorario() {
        int index = cBIrakasleak.getSelectedIndex();
        if(index >= 0) {
            int idProfesor = ((Number) profesoresList.get(index).get("id")).intValue();
            dispose();
            VistaFuntzioak vf = new VistaFuntzioak();
            vf.irekiBesteOrdutegia(usuario, idProfesor); 
        }
    }


    private void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu(usuario);
    }
}





