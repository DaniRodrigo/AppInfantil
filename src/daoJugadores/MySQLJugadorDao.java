package daoJugadores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLJugadorDao{
	
	
	private Connection con;
	
	private String url = "jdbc:mysql://localhost:3306/alumnos?serverTimezone=UTC";  //url de la base de datos

    /**
     * Método que abre la conexion con la base de datos y utiliza las credenciales establecidas.
     */

    public void openConection() {

        //Es necesario el uso de try-catch

        try {
            con = DriverManager.getConnection(url, "root", "DaniRodrigo791");
            System.out.println("Conexión efectuada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que cierra la conexion con la base de datos.
     */
    public void closeConexion() {

        //Es necesario el uso de try-catch

        try {
            con.close();
            System.out.println("Conexión finalizada");
        } catch (SQLException ex) {
            System.out.println("ERROR:al cerrar la conexión");
            ex.printStackTrace();
        }
    }

/**
 * Método que introduce una consulta SQL de lectura en la base de datos y la ejecuta.
 */
public ResultSet executeQuery(String sql) { // solo selects
    try {
        Statement sentencia = con.createStatement();
        return sentencia.executeQuery(sql);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

/**
 * Método que introduce una consulta SQL que va a modificar la base de datos y la ejecuta.
 */
public boolean executeUpdate(String sql) { // insert, update y delete
    try {
        Statement sentencia = con.createStatement();
        return sentencia.executeUpdate(sql) <= 0 ? false : true;
    } catch (SQLException e) {
        throw new RuntimeException(e.getMessage());
    }
}




//Getter para obtener la conexión en otras clases y métodos

public Connection getCon() {
    return con;
}


	
	public MySQLJugadorDao() {
		 
	}

	public boolean insertTiempo(int idJugador, String tiempo) {
	    try {
	        String insertQuery = "UPDATE jugadores SET tiempo = '" + tiempo + "' WHERE idJugador = " + idJugador;
	        Statement statement = con.createStatement();
	        return statement.executeUpdate(insertQuery) > 0;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


}