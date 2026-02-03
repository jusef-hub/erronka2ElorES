package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlFuntzioak.VistaFuntzioak;
import modelo.UserDTO;

public class IkasleaInfV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnAtzera;
    private UserDTO alumno;
    private UserDTO profesor; 

    private JLabel lblFoto;
    private JLabel lblIzena;
    private JLabel lblDNI;

    public IkasleaInfV(UserDTO alumno, UserDTO profesor) {
        this.alumno = alumno;
        this.profesor = profesor;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 515, 235);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(346, 21, 126, 40);
        btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 14));
        contentPane.add(btnAtzera);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atzera();
            }
        });

        JLabel lblTitulo = new JLabel("Ikaslearen Profila");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitulo.setBounds(18, 24, 340, 27);
        contentPane.add(lblTitulo);

        lblFoto = new JLabel("Foto");
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setBounds(52, 194, 132, 154);
        contentPane.add(lblFoto);

        lblIzena = new JLabel("IZENA:");
        lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
        lblIzena.setBounds(18, 103, 200, 17);
        contentPane.add(lblIzena);

        lblDNI = new JLabel("DNI:");
        lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
        lblDNI.setBounds(18, 149, 200, 17);
        contentPane.add(lblDNI);

       
        mostrarInformacionAlumno();
    }

    private void mostrarInformacionAlumno() {
        if (alumno != null) {
            lblIzena.setText("IZENA: " + alumno.getNombre());
            lblDNI.setText("DNI: " + alumno.getDni()); 
        }
    }

    private void atzera() {
        dispose();
        if (profesor != null) {
            VistaFuntzioak vf = new VistaFuntzioak();
            vf.irekiMenu(profesor);
        }
    }
}
