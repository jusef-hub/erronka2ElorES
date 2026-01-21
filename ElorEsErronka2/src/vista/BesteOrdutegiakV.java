package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlFuntzioak.VistaFuntzioak;

public class BesteOrdutegiakV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableOrdutegia;
	private static JLabel lblIrakasleIzena;

	/**
	 * Create the frame.
	 */
	public BesteOrdutegiakV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 539);
        getContentPane().setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 62, 833, 427);
        getContentPane().add(scrollPane);
        
        tableOrdutegia = new JTable();
        tableOrdutegia.setEnabled(false); 
        tableOrdutegia.setRowSelectionAllowed(false); 
        tableOrdutegia.setModel(new DefaultTableModel(
        		new Object[][] {
                    {"HORA 1", null, null, null, null, null},
                    {"HORA 2", null, null, null, null, null},
                    {"HORA 3", null, null, null, null, null},
                    {"HORA 4", null, null, null, null, null},
                    {"HORA 5", null, null, null, null, null},
                    {"HORA 6", null, null, null, null, null},
                },
            new String[] {
                "", "Astelehena", "Asteartea", "Azteazkena", "Osteguna", "Ostirala"
            }
        ));
        
        tableOrdutegia.getTableHeader().setReorderingAllowed(false);

        scrollPane.setViewportView(tableOrdutegia);
        
        lblIrakasleIzena = new JLabel("");
        lblIrakasleIzena.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblIrakasleIzena.setHorizontalAlignment(SwingConstants.CENTER);
        lblIrakasleIzena.setBounds(281, 11, 253, 40);
        getContentPane().add(lblIrakasleIzena);
        
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atzera();
            }
        });
        btnAtzera.setBounds(670, 16, 139, 35);
        getContentPane().add(btnAtzera);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	}
	
	public void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu();
    }

}
