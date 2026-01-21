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
import javax.swing.SwingConstants;

public class MenuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuV() {
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
				//Metodo para cambiar la pantalla para zure Ordutegia
                //zureOrdutegia();
            }
		});
		
		JButton btnBesteOrdutegiak = new JButton("Beste Ordutegiak");
		btnBesteOrdutegiak.setBounds(329, 225, 183, 35);
		contentPane.add(btnBesteOrdutegiak);
		btnBesteOrdutegiak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Metodo para cambiar la pantalla para beste Ordutegiak
				//besteOrdutegiak();
			}
		});
		
		JButton btnBilerak = new JButton("Bilerak Kontsultatu");
		btnBilerak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Metodo para cambiar la pantalla para bilerak
				//bilerak();
			}
		});
		btnBilerak.setBounds(633, 225, 183, 35);
		contentPane.add(btnBilerak);
		
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
		
		// Adaptar las imágenes al tamaño de cada JLabel
		
		// Cargar y adaptar la primera imagen
		ImageIcon originalImage1 = new ImageIcon(MenuV.class.getResource("/img/calendar.png"));
		int labelWidth1 = lblNewLabel.getWidth();
		int labelHeight1 = lblNewLabel.getHeight();
		Image scaledImage1 = originalImage1.getImage().getScaledInstance(labelWidth1, labelHeight1, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(scaledImage1));
		
		// Cargar y adaptar la segunda imagen
		ImageIcon originalImage2 = new ImageIcon(MenuV.class.getResource("/img/calendar_lupa.png"));
		int labelWidth2 = lblNewLabel_1.getWidth();
		int labelHeight2 = lblNewLabel_1.getHeight();
		Image scaledImage2 = originalImage2.getImage().getScaledInstance(labelWidth2, labelHeight2, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(scaledImage2));
		
		// Cargar y adaptar la tercera imagen
		ImageIcon originalImage3 = new ImageIcon(MenuV.class.getResource("/img/lupa.png"));
		int labelWidth3 = lblNewLabel_2.getWidth();
		int labelHeight3 = lblNewLabel_2.getHeight();
		Image scaledImage3 = originalImage3.getImage().getScaledInstance(labelWidth3, labelHeight3, Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(scaledImage3));
		
		// Cargar y adaptar la cuarta imagen
		ImageIcon originalImage4 = new ImageIcon(MenuV.class.getResource("/img/profila.png"));
		int labelWidth4 = lblNewLabel_3.getWidth();
		int labelHeight4 = lblNewLabel_3.getHeight();
		Image scaledImage4 = originalImage4.getImage().getScaledInstance(labelWidth4, labelHeight4, Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(scaledImage4));
		
		// Cargar y adaptar la quinta imagen
		ImageIcon originalImage5 = new ImageIcon(MenuV.class.getResource("/img/ikasleak.png"));
		int labelWidth5 = lblNewLabel_4.getWidth();
		int labelHeight5 = lblNewLabel_4.getHeight();
		Image scaledImage5 = originalImage5.getImage().getScaledInstance(labelWidth5, labelHeight5, Image.SCALE_SMOOTH);
		lblNewLabel_4.setIcon(new ImageIcon(scaledImage5));
		
		JButton btnProfila = new JButton("Profila");
		btnProfila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProfila.setBounds(184, 444, 183, 35);
		contentPane.add(btnProfila);
		
		JButton btnIkasleak = new JButton("Zure ikasleak");
		btnIkasleak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIkasleak.setBounds(514, 450, 183, 35);
		contentPane.add(btnIkasleak);
		
		
	}
	
	public void logout() {
		dispose();
		VistaFuntzioak vf = new VistaFuntzioak();
    	vf.irekiLogin();
	}
}

