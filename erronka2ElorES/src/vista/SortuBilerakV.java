package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Bidalketak;
import controlFuntzioak.VistaFuntzioak;
import modelo.UserDTO;

public class SortuBilerakV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<UserDTO> cbAlumnos;
    private JTextField tfTitulo;
    private JTextField tfAsunto;
    private JTextField tfAula;
    private JTextField tfFechaHora;
    private UserDTO profesor;

    private Bidalketak bidalketak = new Bidalketak();

    public SortuBilerakV(UserDTO profesor) {
        this.profesor = profesor;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAlumno = new JLabel("Alumno:");
        lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAlumno.setBounds(30, 30, 80, 25);
        contentPane.add(lblAlumno);

        cbAlumnos = new JComboBox<>();
        cbAlumnos.setBounds(120, 30, 220, 25);
        contentPane.add(cbAlumnos);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTitulo.setBounds(30, 70, 80, 25);
        contentPane.add(lblTitulo);

        tfTitulo = new JTextField();
        tfTitulo.setBounds(120, 70, 220, 25);
        contentPane.add(tfTitulo);

        JLabel lblAsunto = new JLabel("Asunto:");
        lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAsunto.setBounds(30, 110, 80, 25);
        contentPane.add(lblAsunto);

        tfAsunto = new JTextField();
        tfAsunto.setBounds(120, 110, 220, 25);
        contentPane.add(tfAsunto);

        JLabel lblFechaHora = new JLabel("Fecha y hora (yyyy-MM-dd HH:mm):");
        lblFechaHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFechaHora.setBounds(30, 150, 300, 25);
        contentPane.add(lblFechaHora);

        tfFechaHora = new JTextField();
        tfFechaHora.setBounds(30, 180, 310, 25);
        contentPane.add(tfFechaHora);

        JLabel lblAula = new JLabel("Aula:");
        lblAula.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAula.setBounds(30, 220, 80, 25);
        contentPane.add(lblAula);

        tfAula = new JTextField();
        tfAula.setBounds(120, 220, 220, 25);
        contentPane.add(tfAula);

        JButton btnCrear = new JButton("Crear Reunión");
        btnCrear.setBounds(30, 260, 150, 30);
        contentPane.add(btnCrear);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(208, 260, 122, 30);
        contentPane.add(btnCancelar);

        cargarAlumnos();
        
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearReunion();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                VistaFuntzioak vf = new VistaFuntzioak();
                vf.irekiMenu(profesor);
            }
        });
    }

    private void cargarAlumnos() {
    	List<UserDTO> alumnos = bidalketak.obtenerAlumnos(profesor.getId());
        if (alumnos == null || alumnos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se pudieron cargar los alumnos");
            return;
        }
        for (UserDTO u : alumnos) {
            cbAlumnos.addItem(u);
        }
    }

    private void crearReunion() {
        try {
            UserDTO alumno = (UserDTO) cbAlumnos.getSelectedItem();
            String titulo = tfTitulo.getText().trim();
            String asunto = tfAsunto.getText().trim();
            String aula = tfAula.getText().trim();
            String fechaStr = tfFechaHora.getText().trim();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date fecha = sdf.parse(fechaStr);

            Map<String, Object> datos = Map.of(
                "profesorId", profesor.getId(),
                "alumnoId", alumno.getId(),
                "titulo", titulo,
                "asunto", asunto,
                "fecha", sdf.format(fecha),
                "aula", aula
            );

            bidalketak.crearReunion(datos);

            JOptionPane.showMessageDialog(this, "Reunión creada correctamente");

            dispose();
            VistaFuntzioak vf = new VistaFuntzioak();
            vf.irekiMenu(profesor);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al crear reunión: " + ex.getMessage());
        }
    }
}
