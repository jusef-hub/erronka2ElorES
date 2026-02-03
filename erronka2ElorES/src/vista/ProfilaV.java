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

public class ProfilaV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnAtzera;
    private UserDTO usuario; 

    public ProfilaV(UserDTO usuario) {
        this.usuario = usuario; 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(699, 11, 126, 40);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atzera();
            }
        });
        contentPane.add(btnAtzera);

        JLabel lblFoto = new JLabel("Foto");
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setBounds(699, 335, 132, 154);
        contentPane.add(lblFoto);

        JLabel lblIzena = new JLabel("IZENA: " + usuario.getNombre());
        lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
        lblIzena.setBounds(18, 152, 200, 17);
        contentPane.add(lblIzena);

        JLabel lblUsername = new JLabel("USERNAME: " + (usuario.getUsername()));
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setBounds(18, 201, 200, 17);
        contentPane.add(lblUsername);

        JLabel lblDni = new JLabel("DNI: " + usuario.getDni());
        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDni.setHorizontalAlignment(SwingConstants.CENTER);
        lblDni.setBounds(18, 242, 200, 17);
        contentPane.add(lblDni);

        JLabel lblEmail = new JLabel("EMAIL: " + usuario.getEmail());
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setBounds(18, 288, 200, 17);
        contentPane.add(lblEmail);

        JLabel lblTitulo = new JLabel("Irakaslearen Profila");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitulo.setBounds(218, 24, 340, 27);
        contentPane.add(lblTitulo);
    }

    public void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu(usuario);
    }
}
