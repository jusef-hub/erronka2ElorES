package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.Bidalketak;
import controlFuntzioak.VistaFuntzioak;
import modelo.UserDTO;

public class IkasleaHautatuV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private UserDTO usuario; // Profesor logeado
    private JComboBox<UserDTO> comboBoxAlumnos;

    /**
     * Create the frame.
     */
    public IkasleaHautatuV(UserDTO usuario) {
        this.usuario = usuario; // Guardamos el profesor logeado

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 349, 232);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ComboBox de alumnos
        comboBoxAlumnos = new JComboBox<>();
        comboBoxAlumnos.setBounds(59, 65, 210, 44);
        contentPane.add(comboBoxAlumnos);

        // Botón Atzera
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAtzera.setBounds(10, 147, 112, 35);
        contentPane.add(btnAtzera);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atzera();
            }
        });

        // Botón Jarraitu
        JButton btnJarraitu = new JButton("Jarraitu");
        btnJarraitu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnJarraitu.setBounds(216, 147, 112, 35);
        contentPane.add(btnJarraitu);
        btnJarraitu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirIkasleaInf();
            }
        });

        JLabel lblIkasleaHautatu = new JLabel("Ikaslea Hautatu");
        lblIkasleaHautatu.setHorizontalAlignment(SwingConstants.CENTER);
        lblIkasleaHautatu.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblIkasleaHautatu.setBounds(59, 11, 210, 28);
        contentPane.add(lblIkasleaHautatu);

        // Cargar alumnos desde el servidor
        cargarAlumnos();
    }

    /**
     * Llama al servidor y carga los alumnos en el comboBox
     */
    private void cargarAlumnos() {
        comboBoxAlumnos.removeAllItems();

        Bidalketak bidalketak = new Bidalketak();
        List<UserDTO> alumnos = bidalketak.obtenerAlumnos(usuario.getId());

        System.out.println("ALUMNOS: " + alumnos.size());

        for (UserDTO alumno : alumnos) {
            System.out.println("Añadiendo: " + alumno.getId());
            comboBoxAlumnos.addItem(alumno);
        }

        System.out.println("COMBO FINAL: " + comboBoxAlumnos.getItemCount());
    }


    /**
     * Abrir la vista del alumno seleccionado
     */
    private void abrirIkasleaInf() {
        UserDTO alumnoSeleccionado = (UserDTO) comboBoxAlumnos.getSelectedItem();
        if (alumnoSeleccionado != null) {
            dispose(); // Cerramos esta ventana
            EventQueue.invokeLater(() -> {
            	IkasleaInfV frame = new IkasleaInfV(alumnoSeleccionado, usuario);
            	frame.setVisible(true);

            });
        }
    }

    public void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu(usuario);
    }
}
