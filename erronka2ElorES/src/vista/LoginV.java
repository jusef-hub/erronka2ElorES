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
import modelo.UserDTO;

public class LoginV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    
    //instancia del cliente socket
    private Bidalketak bidalketak = new Bidalketak();

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
        
        try {
            lblIcon.setIcon(new ImageIcon(LoginV.class.getResource("/img/logo-elorrieta(200x110).jpg")));
        } catch (Exception e) {
            lblIcon.setText("LOGO ELORRIETA");
        }
        lblIcon.setBounds(10, 11, 414, 118);
        contentPane.add(lblIcon);
    }

    private void login() {
        String user = textField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mesedez, bete eremu guztiak");
            return;
        }

       //logicia login RSA
        try {
           
            if (bidalketak.conectar()) {
                
                // encripta pass y envia
                UserDTO userDTO = bidalketak.login(user, pass);

                if (userDTO != null) {
                    // serever comprueba si es alumno o profesoe
                    // y si nos devuelve un usuario entonces todo ok
                    
                	//para que no entre alumno
                      if (userDTO.getTipo().getId() != 4) { 
                        MenuV menu = new MenuV(userDTO);
                        menu.setVisible(true);
                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Ikasleek ezin dute aplikazio hau erabili.");
	                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza okerra da (edo ez zara irakaslea).");
                }
                
                
                // socketClient.desconectar();
                
            } else {
                JOptionPane.showMessageDialog(null, "Errorea zerbitzariarekin konektatzean (Port 9000).");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore ezezaguna gertatu da: " + ex.getMessage());
        }
    }
}