package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlFuntzioak.VistaFuntzioak;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class ProfilaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtzera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilaV frame = new ProfilaV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProfilaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(699, 11, 126, 40);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
                atzera();
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnAtzera);
        
        JLabel lblFoto = new JLabel("Foto");
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setBounds(699, 335, 132, 154);
        contentPane.add(lblFoto);
        
        JLabel lblIzena = new JLabel("IZENA:");
        lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
        lblIzena.setBounds(18, 152, 77, 17);
        contentPane.add(lblIzena);
        
        JLabel lblAbizena = new JLabel("ABIZENA:");
        lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
        lblAbizena.setBounds(18, 201, 77, 17);
        contentPane.add(lblAbizena);
        
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDni.setHorizontalAlignment(SwingConstants.CENTER);
        lblDni.setBounds(18, 242, 77, 17);
        contentPane.add(lblDni);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setBounds(18, 288, 77, 17);
        contentPane.add(lblUsername);
        
        JLabel lblTitulo = new JLabel("Irakaslearen Profila");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitulo.setBounds(218, 24, 340, 27);
        contentPane.add(lblTitulo);
	}
	
	
	public void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu();
    }
}
