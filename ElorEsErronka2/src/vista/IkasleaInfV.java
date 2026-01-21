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

public class IkasleaInfV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAtzera;

	/**
	 * Create the frame.
	 */
	public IkasleaInfV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 716, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        btnAtzera = new JButton("Atzera");
        btnAtzera.setBounds(556, 11, 126, 40);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
                atzera();
            }
        });
        contentPane.setLayout(null);
        contentPane.add(btnAtzera);
        
        
        JLabel lblFoto = new JLabel("Foto");
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setBounds(556, 335, 132, 154);
        contentPane.add(lblFoto);
        
        JLabel lblIzena = new JLabel("IZENA:");
        lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
        lblIzena.setBounds(18, 204, 77, 17);
        contentPane.add(lblIzena);
        
        JLabel lblAbizena = new JLabel("ABIZENA:");
        lblAbizena.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAbizena.setHorizontalAlignment(SwingConstants.CENTER);
        lblAbizena.setBounds(18, 257, 77, 17);
        contentPane.add(lblAbizena);
        
        JLabel lblTitulo = new JLabel("Ikaslearen Profila");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTitulo.setBounds(169, 24, 340, 27);
        contentPane.add(lblTitulo);

	}
	
	
	public void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu();
    }

}
