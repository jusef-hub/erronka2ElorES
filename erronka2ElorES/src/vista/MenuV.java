package vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlFuntzioak.VistaFuntzioak;
import modelo.UserDTO;

public class MenuV extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private UserDTO usuario;

    public MenuV(UserDTO usuario) {
        this.usuario = usuario;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 554);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        btnLogout.setBounds(762, 11, 89, 23);
        contentPane.add(btnLogout);

        JButton btnZureOrdutegia = new JButton("Zure Ordutegia");
        btnZureOrdutegia.setBounds(37, 225, 183, 35);
        contentPane.add(btnZureOrdutegia);
        btnZureOrdutegia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zureOrdutegia();
            }
        });

        JButton btnBesteOrdutegiak = new JButton("Beste Ordutegiak");
        btnBesteOrdutegiak.setBounds(329, 225, 183, 35);
        contentPane.add(btnBesteOrdutegiak);
        btnBesteOrdutegiak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                besteOrdutegiak();
            }
        });

        JButton btnBilerak = new JButton("Bilerak Kontsultatu");
        btnBilerak.setBounds(633, 225, 183, 35);
        contentPane.add(btnBilerak);
        btnBilerak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bilerak();
            }
        });

        JLabel lblNewLabel = new JLabel("Foto1");
        lblNewLabel.setBounds(37, 40, 183, 152);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Foto2");
        lblNewLabel_1.setBounds(329, 42, 183, 149);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Foto3");
        lblNewLabel_2.setBounds(633, 53, 189, 126);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Foto4");
        lblNewLabel_3.setBounds(184, 287, 183, 149);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Foto5");
        lblNewLabel_4.setBounds(514, 287, 183, 149);
        contentPane.add(lblNewLabel_4);

        ImageIcon originalImage1 = new ImageIcon(MenuV.class.getResource("/img/calendar.png"));
        lblNewLabel.setIcon(new ImageIcon(originalImage1.getImage().getScaledInstance(lblNewLabel.getWidth(),
                lblNewLabel.getHeight(), Image.SCALE_SMOOTH)));

        ImageIcon originalImage2 = new ImageIcon(MenuV.class.getResource("/img/calendar_lupa.png"));
        lblNewLabel_1.setIcon(new ImageIcon(originalImage2.getImage().getScaledInstance(lblNewLabel_1.getWidth(),
                lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH)));

        ImageIcon originalImage3 = new ImageIcon(MenuV.class.getResource("/img/lupa.png"));
        lblNewLabel_2.setIcon(new ImageIcon(originalImage3.getImage().getScaledInstance(lblNewLabel_2.getWidth(),
                lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH)));

        ImageIcon originalImage4 = new ImageIcon(MenuV.class.getResource("/img/profila.png"));
        lblNewLabel_3.setIcon(new ImageIcon(originalImage4.getImage().getScaledInstance(lblNewLabel_3.getWidth(),
                lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH)));

        ImageIcon originalImage5 = new ImageIcon(MenuV.class.getResource("/img/ikasleak.png"));
        lblNewLabel_4.setIcon(new ImageIcon(originalImage5.getImage().getScaledInstance(lblNewLabel_4.getWidth(),
                lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH)));

        
        JButton btnProfila = new JButton("Profila");
        btnProfila.setBounds(184, 444, 183, 35);
        btnProfila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                profila();
            }
        });
        contentPane.add(btnProfila);

        
        JButton btnIkasleak = new JButton("Zure ikasleak");
        btnIkasleak.setBounds(514, 450, 183, 35);
        contentPane.add(btnIkasleak);
        btnIkasleak.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirIkasleaHautatu();
            }
        });
    }


    public void zureOrdutegia() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiZureOrdutegia(usuario);
    }

    public void besteOrdutegiak() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        EventQueue.invokeLater(() -> {
            IrakasleaHautatuV frame = new IrakasleaHautatuV(usuario); 
            frame.setVisible(true);
        });
    }


    public void bilerak() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiZureBilerak(usuario);
    }

    public void profila() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiProfila(usuario);
    }
    
    private void abrirIkasleaHautatu() {
        dispose(); 
        EventQueue.invokeLater(() -> {
            IkasleaHautatuV frame = new IkasleaHautatuV(usuario); 
            frame.setVisible(true);
        });
    }

    public void logout() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiLogin();
    }
}
