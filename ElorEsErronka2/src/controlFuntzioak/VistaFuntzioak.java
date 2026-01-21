package controlFuntzioak;

import java.awt.EventQueue;

import vista.BesteOrdutegiakV;
import vista.LoginV;
import vista.MenuV;
import vista.ProfilaV;
import vista.ZureBilerakV;
import vista.ZureOrdutegiaV;

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
	
	public void irekiZureOrdutegia() {
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
	
	public void irekiBesteOrdutegiak() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BesteOrdutegiakV frame = new BesteOrdutegiakV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void irekiZureBilerak() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZureBilerakV frame = new ZureBilerakV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void irekiProfila() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilaV frame = new ProfilaV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
