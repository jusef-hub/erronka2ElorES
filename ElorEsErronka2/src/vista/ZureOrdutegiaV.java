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

public class ZureOrdutegiaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable tableOrdutegia;
    private JLabel lblNewLabel;
    private JButton btnAtzera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZureOrdutegiaV frame = new ZureOrdutegiaV();
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
	public ZureOrdutegiaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 869, 539);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnAtzera = new JButton("Atzera");
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
                atzera();
            }
        });
        btnAtzera.setBounds(699, 11, 126, 40);
        contentPane.add(btnAtzera);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 62, 833, 427);
        contentPane.add(scrollPane);

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
                " ", "Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala"
            }
        ));
        
        tableOrdutegia.getTableHeader().setReorderingAllowed(false);

        scrollPane.setViewportView(tableOrdutegia);

        lblNewLabel = new JLabel("Zure Ordutegia");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(278, 11, 235, 40);
        contentPane.add(lblNewLabel);


	}
	
	public void atzera() {
        dispose();
        VistaFuntzioak vf = new VistaFuntzioak();
        vf.irekiMenu();
    }

}
