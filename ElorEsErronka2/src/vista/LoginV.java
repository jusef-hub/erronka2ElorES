package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.Bidalketak;
import controlFuntzioak.VistaFuntzioak;
import modelo.UsersDTO;

public class LoginV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginV() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(157, 140, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(168, 227, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("User: ");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(55, 143, 92, 14);
		contentPane.add(lblUser);

		JLabel lblPasahitza = new JLabel("Pasahitza: ");
		lblPasahitza.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasahitza.setBounds(55, 174, 92, 14);
		contentPane.add(lblPasahitza);

		passwordField = new JPasswordField();
		passwordField.setBounds(157, 171, 206, 20);
		contentPane.add(passwordField);

		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setIcon(new ImageIcon(LoginV.class.getResource("/img/logo-elorrieta(200x110).jpg")));
		lblIcon.setBounds(10, 11, 414, 118);
		contentPane.add(lblIcon);
	}
	
	private void login() {
		String user = textField.getText();
		String pass = passwordField.getText();
		Boolean isLoginOk = false;
		Bidalketak bidalketak = new Bidalketak();
		
		System.out.println("Login saioa: " + user + " - " + pass);
		
		UsersDTO userDTO = bidalketak.login(new String[] { user, pass });
		if(userDTO != null && userDTO.getTipos().getId() == 3) {	
			isLoginOk = true;
		}
		
		LoginOk(isLoginOk);
		
	}
	
	private void LoginOk(Boolean isLoginOk) {
		if(isLoginOk) {
			JOptionPane.showMessageDialog(null, "Saioa ondo hasi duzu");
			
			VistaFuntzioak vf = new VistaFuntzioak();
			vf.irekiMenu();
		}
		else {
			JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza okerra da");
		}
	}


}
