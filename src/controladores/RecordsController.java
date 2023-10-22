package controladores;

import daoJugadores.MySQLJugadorDao;
import diseño.JugadoresTableModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import daoJugadores.Jugador;

public class RecordsController {
    private MySQLJugadorDao jugadorDao;

    public RecordsController() {
        jugadorDao = new MySQLJugadorDao();
    }

    /**
     * Inserta un nuevo jugador en la base de datos.
     * @param id El ID del jugador.
     * @param nombre El nombre del jugador.
     * @param contrasena La contraseña del jugador.
     * @param email El correo electrónico del jugador.
     * @param tiempo El tiempo del jugador.
     * @return true si la inserción es exitosa, false de lo contrario.
     */
    public boolean insertarJugador(int id, String nombre, String contrasena, String email, String tiempo) {
        jugadorDao.openConection();

        // Validación de datos de entrada
        if (id <= 0 || nombre.isEmpty() || contrasena.isEmpty() || email.isEmpty() || tiempo.isEmpty()) {
            jugadorDao.closeConexion();
            return false; // Datos de entrada no válidos
        }

        // Verificar si el ID ya existe en la base de datos
        if (existeJugador(id)) {
            jugadorDao.closeConexion();
            // Muestra un JOptionPane si el jugador ya existe
            JOptionPane.showMessageDialog(null, "El jugador con el ID especificado ya existe.", "Jugador existente", JOptionPane.WARNING_MESSAGE);
            return false; // El ID ya existe en la base de datos
        }

        String insertQuery = "INSERT INTO jugadores (idJugador, nombre, contrasena, email, tiempo) " +
                             "VALUES (" + id + ", '" + nombre + "', '" + contrasena + "', '" + email + "', '" + tiempo + "')";
        boolean inserted = jugadorDao.executeUpdate(insertQuery);
        jugadorDao.closeConexion();
        return inserted;
    }

    /**
     * Actualiza la información de un jugador en la base de datos.
     * @param id El ID del jugador a actualizar.
     * @param nombre El nuevo nombre del jugador.
     * @param contrasena La nueva contraseña del jugador.
     * @param email El nuevo correo electrónico del jugador.
     * @param tiempo El nuevo tiempo del jugador.
     * @return true si la actualización es exitosa, false de lo contrario.
     */
    public boolean actualizarJugador(int id, String nombre, String contrasena, String email, String tiempo) {
        jugadorDao.openConection();

        // Validación de datos de entrada
        if (id <= 0 || nombre.isEmpty() || contrasena.isEmpty() || email.isEmpty() || tiempo.isEmpty()) {
            jugadorDao.closeConexion();
            return false; // Datos de entrada no válidos
        }

        String updateQuery = "UPDATE jugadores SET nombre = '" + nombre + "', contrasena = '" + contrasena + "', " +
                             "email = '" + email + "', tiempo = '" + tiempo + "' WHERE idJugador = " + id;
        boolean updated = jugadorDao.executeUpdate(updateQuery);
        jugadorDao.closeConexion();
        return updated;
    }

    /**
     * Elimina un jugador de la base de datos.
     * @param id El ID del jugador a eliminar.
     * @return true si la eliminación es exitosa, false de lo contrario.
     */
    public boolean eliminarJugador(int id) {
        jugadorDao.openConection();

        // Validación de datos de entrada
        if (id <= 0) {
            jugadorDao.closeConexion();
            return false; // ID no válido
        }

        // Verificar si el jugador con el ID existe en la base de datos
        if (!existeJugador(id)) {
            jugadorDao.closeConexion();
            return false; // El jugador no existe en la base de datos
        }

        String deleteQuery = "DELETE FROM jugadores WHERE idJugador = " + id;
        boolean deleted = jugadorDao.executeUpdate(deleteQuery);
        jugadorDao.closeConexion();
        return deleted;
    }

    // Método para verificar si un jugador con el ID especificado existe en la base de datos
    public boolean existeJugador(int id) {
        ResultSet resultSet = jugadorDao.executeQuery("SELECT idJugador FROM jugadores WHERE idJugador = " + id);
        boolean existe = false;
        try {
            existe = resultSet.next(); // Verificar si hay al menos una fila en el resultado
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
        return existe;
    }

    /**
     * Obtiene un modelo de tabla con los datos de los jugadores desde la base de datos.
     * @return El modelo de tabla con los datos de los jugadores.
     */
    public JugadoresTableModel obtenerTablaJugadores() {
        jugadorDao.openConection();
        ResultSet resultSet = jugadorDao.executeQuery("SELECT * FROM jugadores");
        JugadoresTableModel model = new JugadoresTableModel(resultSet);
        jugadorDao.closeConexion();
        return model;
    }
}