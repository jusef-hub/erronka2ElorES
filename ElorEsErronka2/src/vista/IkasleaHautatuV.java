package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IkasleaHautatuV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IkasleaHautatuV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 83, 130, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(269, 83, 130, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblCiclo = new JLabel("CICLO");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclo.setBounds(45, 50, 79, 22);
		contentPane.add(lblCiclo);
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setBounds(296, 50, 79, 22);
		contentPane.add(lblCurso);
		
		JLabel lblIkaslea = new JLabel("IKASLEA");
		lblIkaslea.setHorizontalAlignment(SwingConstants.CENTER);
		lblIkaslea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIkaslea.setBounds(176, 130, 79, 22);
		contentPane.add(lblIkaslea);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(151, 163, 130, 22);
		contentPane.add(comboBox_2);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtzera.setBounds(22, 215, 112, 35);
		contentPane.add(btnAtzera);
		
		JButton btnJarraitu = new JButton("Jarraitu");
		btnJarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJarraitu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnJarraitu.setBounds(287, 215, 112, 35);
		contentPane.add(btnJarraitu);
		
		JLabel lblIkasleaHautatu = new JLabel("Ikaslea Hautatu");
		lblIkasleaHautatu.setHorizontalAlignment(SwingConstants.CENTER);
		lblIkasleaHautatu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblIkasleaHautatu.setBounds(109, 11, 210, 28);
		contentPane.add(lblIkasleaHautatu);

	}
}
