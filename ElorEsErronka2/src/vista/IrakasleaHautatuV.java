package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import controlFuntzioak.VistaFuntzioak;
public class IrakasleaHautatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cBIrakasleak;
	
	/**
	 * Create the frame.
	 */
	public IrakasleaHautatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIrakasleaHautatu = new JLabel("Irakasle Aukeratu");
		lblIrakasleaHautatu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIrakasleaHautatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblIrakasleaHautatu.setBounds(67, 11, 136, 24);
		contentPane.add(lblIrakasleaHautatu);
		
		cBIrakasleak = new JComboBox();
		cBIrakasleak.setBounds(51, 46, 168, 24);
		contentPane.add(cBIrakasleak);
		//irakasleakKargatu();
		
		
		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//jarraitu();
			}
		});
		btnJarraitu.setBounds(165, 95, 89, 23);
		contentPane.add(btnJarraitu);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atzera();
			}
		});
		btnAtzera.setBounds(22, 95, 89, 23);
		contentPane.add(btnAtzera);
	}
	
	public void atzera() {
		dispose();
		VistaFuntzioak vf = new VistaFuntzioak();
		vf.irekiMenu();
	}
	


	}

