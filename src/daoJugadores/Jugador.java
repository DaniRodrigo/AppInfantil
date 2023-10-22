package daoJugadores;

public class Jugador {

	int idJugador;
	
	String nombre;
	
	String contrasena;
	
	String email;
	
	String tiempo;

	public Jugador(int idJugador, String nombre, String contrasena, String email, String tiempo) {
		super();
		this.idJugador = idJugador;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.tiempo = tiempo;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nombre=" + nombre + ", contrasena=" + contrasena + ", email="
				+ email + ", tiempo=" + tiempo + "]";
	}
	
	
	
}
