package modelo;

public class UserDTO {
	private int id;
	private String username;
	private String email;
	private TipoDTO tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoDTO getTipo() {
		return tipo;
	}

	public void setTipo(TipoDTO tipo) {
		this.tipo = tipo;
	}

	public static class TipoDTO {
		private int id;
		private String nombre;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}
}