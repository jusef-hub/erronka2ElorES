package controlFuntzioak;

import java.awt.EventQueue;

import vista.LoginV;
import vista.MenuV;

public class VistaFuntzioak {
	
	public VistaFuntzioak() {
	}
	
	public void irekiLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginV frame = new LoginV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void irekiMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuV frame = new MenuV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
