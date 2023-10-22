package diseño;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import daoJugadores.Jugador;

public class JugadoresTableModel extends AbstractTableModel {
    // Lista que almacena los jugadores a mostrar en la tabla
    private List<Jugador> jugadores = new ArrayList<>();
    
    // Nombres de las columnas de la tabla
    private String[] columnNames = {"ID", "Nombre", "Contraseña", "Email", "Tiempo"};

    // Constructor que inicializa el modelo con datos de un ResultSet
    public JugadoresTableModel(ResultSet resultSet) {
        try {
            // Recorre el ResultSet y agrega los jugadores a la lista
            while (resultSet.next()) {
                int idJugador = resultSet.getInt("idJugador");
                String nombre = resultSet.getString("nombre");
                String contrasena = resultSet.getString("contrasena");
                String email = resultSet.getString("email");
                String tiempo = resultSet.getString("tiempo");
                jugadores.add(new Jugador(idJugador, nombre, contrasena, email, tiempo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        // Devuelve el número de filas en la tabla (cantidad de jugadores)
        return jugadores.size();
    }

    @Override
    public int getColumnCount() {
        // Devuelve el número de columnas en la tabla
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jugador jugador = jugadores.get(rowIndex);
        // Devuelve el valor en la posición (fila, columna) de la tabla
        switch (columnIndex) {
            case 0:
                return jugador.getIdJugador(); // ID del jugador
            case 1:
                return jugador.getNombre(); // Nombre del jugador
            case 2:
                return jugador.getContrasena(); // Contraseña del jugador
            case 3:
                return jugador.getEmail(); // Email del jugador
            case 4:
                return jugador.getTiempo(); // Tiempo del jugador
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        // Devuelve el nombre de la columna en la posición especificada
        return columnNames[column];
    }
}
