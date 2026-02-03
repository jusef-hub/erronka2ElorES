package controlFuntzioak;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import vista.*;
import modelo.UserDTO;

public class VistaFuntzioak {

    public void irekiMenu(UserDTO usuariologeado) {
        EventQueue.invokeLater(() -> {
            MenuV frame = new MenuV(usuariologeado);
            frame.setVisible(true);
        });
    }

    public void irekiZureOrdutegia(UserDTO usuario) {
        EventQueue.invokeLater(() -> {
            ZureOrdutegiaV frame = new ZureOrdutegiaV(usuario);
            frame.setVisible(true);
        });
    }

    public void irekiBesteOrdutegia(UserDTO usuarioLogeado, int profesorId) {
        EventQueue.invokeLater(() -> {
            BesteOrdutegiakV frame = new BesteOrdutegiakV(usuarioLogeado, profesorId);
            frame.setVisible(true);
        });
    }

    public void irekiProfila(UserDTO usuariologeado) {
        EventQueue.invokeLater(() -> {
            ProfilaV frame = new ProfilaV(usuariologeado);
            frame.setVisible(true);
        });
    }

    public void irekiSortuBilerak(UserDTO usuario) {
        EventQueue.invokeLater(() -> {
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "Error: Usuario no logeado");
                return;
            }
            SortuBilerakV frame = new SortuBilerakV(usuario);
            frame.setVisible(true);
        });
    }
    
    public void irekiZureBilerak(UserDTO usuario) {
		EventQueue.invokeLater(() -> {
			if (usuario == null) {
				JOptionPane.showMessageDialog(null, "Error: Usuario no logeado");
				return;
			}
			ZureBilerakV frame = new ZureBilerakV(usuario);
			frame.setVisible(true);
		});
	}

    public void irekiBesteOrdutegiak() {
        EventQueue.invokeLater(() -> {
            IrakasleaHautatuV frame = new IrakasleaHautatuV(null);
            frame.setVisible(true);
        });
    }

    public void irekiLogin() {
        EventQueue.invokeLater(() -> {
            LoginV frame = new LoginV();
            frame.setVisible(true);
        });
    }
}
