package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Peticiones;
import modelo.Peticiones.KontzultaMota;
import modelo.UsersDTO;


public class Bidalketak {
	
	public UsersDTO login(String[] credentials) {
		UsersDTO users = new UsersDTO();
		try {
			Socket socket = new Socket("Localhost", 4444);
			ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
			Peticiones peticion = new Peticiones(KontzultaMota.Login, credentials);
			dos.writeObject(peticion);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		try {
				users = (UsersDTO) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public ArrayList<UsersDTO> getIrakasleak() {
		ArrayList<UsersDTO> users = new ArrayList<>();
		try {
			Socket socket = new Socket("10.5.104.25", 4444);
			ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());

			Peticiones peticiones = new Peticiones(KontzultaMota.IrakasleakLortu);

			dos.writeObject(peticiones);

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			try {
				users = (ArrayList<UsersDTO>) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;

	}
	
	public UsersDTO getIrakasleakByName(String name) {
		UsersDTO user = new UsersDTO();
		try {
			Socket socket = new Socket("10.5.104.25", 4444);
			ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());

			Peticiones peticiones = new Peticiones(KontzultaMota.IrakasleakLortuByName, name);

			dos.writeObject(peticiones);

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			try {
				user = (UsersDTO) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}


}
