package diseño;

import java.awt.BorderLayout;

import daoJugadores.MySQLJugadorDao;
import java.awt.FlowLayout;
import daoJugadores.Jugador;
import daoJugadores.MySQLJugadorDao;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

import daoJugadores.MySQLJugadorDao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;

import controladores.RecordsController;

public class Records extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable JtableJugadores;
	private JTextField textid;
	private JTextField textnombre;
	private JTextField textcontrasena;
	private JTextField textemail;
	private JTextField texttiempo;
	private RecordsController controller;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Records dialog = new Records();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Create the dialog.
	 */
	public Records() {
        // Inicialización del controlador
        controller = new RecordsController();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                // Realizar acciones cuando la ventana se activa
            }
        });
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danir\\Downloads\\Home.jfif"));
		setTitle("Records");
		setBounds(100, 100, 635, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		// Creación de una etiqueta de imagen
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\danir\\Downloads\\14721e3a-3653-4fd7-80ac-047ba0e829fb_1190x500.jpg"));
			lblNewLabel.setBounds(208, -32, 204, 122);
			contentPanel.add(lblNewLabel);
		}
		
		// Botón "Nuevo" para insertar un nuevo registro en la base de datos
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			     // Validación de campos vacíos
		        if (textid.getText().isEmpty() || textnombre.getText().isEmpty() || textcontrasena.getText().isEmpty() || textemail.getText().isEmpty() || texttiempo.getText().isEmpty()) {
		            // Muestra un mensaje de error o realiza alguna acción apropiada
		            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de insertar un nuevo registro.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
		        } else {
		            int id = Integer.parseInt(textid.getText());
		            String nombre = textnombre.getText();
		            String contrasena = textcontrasena.getText();
		            String email = textemail.getText();
		            String tiempo = texttiempo.getText();
		            
		            // Luego, procede con la inserción de datos en la base de datos
				
				boolean inserted = controller.insertarJugador(id, nombre, contrasena, email, tiempo);

                if (inserted) {
                    actualizarTabla();
                }
                
		        }

			}
		});
		btnNewButton.setBounds(69, 157, 89, 23);
		contentPanel.add(btnNewButton);
		
		
		// Botón "Modificar" para actualizar un registro en la base de datos
		JButton btnNewButton_1 = new JButton("Modificar");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 // Validación de campos vacíos
		        if (textid.getText().isEmpty() || textnombre.getText().isEmpty() || textcontrasena.getText().isEmpty() || textemail.getText().isEmpty() || texttiempo.getText().isEmpty()) {
		            // Muestra un mensaje de error o realiza alguna acción apropiada
		            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de insertar un nuevo registro.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
		        } else {
		            int id = Integer.parseInt(textid.getText());
		            String nombre = textnombre.getText();
		            String contrasena = textcontrasena.getText();
		            String email = textemail.getText();
		            String tiempo = texttiempo.getText();
		            
		            // Luego, procede con la inserción de datos en la base de datos

		        boolean updated = controller.actualizarJugador(id, nombre, contrasena, email, tiempo);

		        if (updated) {
		            actualizarTabla();
		        }
		    }
		    }
		});
		
		btnNewButton_1.setBounds(168, 157, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		// Botón "Eliminar" para eliminar un registro de la base de datos
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Obtén el valor del campo idJugador que se va a eliminar
		        String idText = textid.getText();

		        // Validación de campo "id" no vacío
		        if (idText.isEmpty()) {
		            // Muestra un mensaje de error si el campo "id" está vacío
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido para eliminar un registro.", "ID vacío", JOptionPane.WARNING_MESSAGE);
		        } else {
		            try {
		                int id = Integer.parseInt(idText);

		                // Llamar al controlador para manejar la eliminación
		                RecordsController controller = new RecordsController();
		                boolean deleted = controller.eliminarJugador(id);

		                if (deleted) {
		                    System.out.println("Borrado en la base de datos exitosa");
		                    // Actualiza la tabla después de eliminar un jugador
		                    actualizarTabla();
		                } else {
		                    // Mostrar un mensaje de error si la eliminación falla
		                    JOptionPane.showMessageDialog(null, "Hubo un error en la eliminación o el ID no existe.", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (NumberFormatException ex) {
		                // Muestra un mensaje de error si el campo "id" no es un número válido
		                JOptionPane.showMessageDialog(null, "El campo ID no es un número válido.", "ID inválido", JOptionPane.WARNING_MESSAGE);
		            }
		        }
		    }
		});
		btnNewButton_2.setBounds(267, 157, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		// Botón "Actualizar tabla" para refrescar la tabla
		JButton btnNewButton_4 = new JButton("Actualizar tabla");
		btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// Llama a la función actualizarTabla para refrescar la tabla
		        actualizarTabla();
			}
		});
		btnNewButton_4.setBounds(366, 157, 188, 23);
		contentPanel.add(btnNewButton_4);
		
		// Botón "Salir" para cerrar la ventana actual y volver a la ventana de inicio
		JButton btnNewButton_5 = new JButton("Salir");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Cerrar la ventana actual
				IrAInicio(); // Llamar al método para ir a la ventana de inicio
			}

			private void IrAInicio() {
				Inicio inicio = new Inicio();	
					
				inicio.setLocationRelativeTo(null);
				inicio.setModal(true);
				inicio.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(269, 391, 89, 23);
		contentPanel.add(btnNewButton_5);
		
		// Crear un JScrollPane para contener la tabla
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 191, 485, 189);
		contentPanel.add(scrollPane);
		
		 // Crea una instancia de tu modelo de tabla personalizado y pásale los datos de la base de datos
        MySQLJugadorDao dao = new MySQLJugadorDao();
        dao.openConection();
        ResultSet resultSet = dao.executeQuery("SELECT * FROM jugadores");
        JugadoresTableModel model = new JugadoresTableModel(resultSet);
        dao.closeConexion();

        // Crea la JTable y asigna el modelo personalizado
        JtableJugadores = new JTable(model);

        // Agrega la JTable al JScrollPane
        scrollPane.setViewportView(JtableJugadores);
    
		
		textid = new JTextField();
		textid.setColumns(10);
		textid.setBounds(69, 126, 86, 20);
		contentPanel.add(textid);
		
		
		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(168, 126, 86, 20);
		contentPanel.add(textnombre);
		
		textcontrasena = new JTextField();
		textcontrasena.setColumns(10);
		textcontrasena.setBounds(267, 126, 86, 20);
		contentPanel.add(textcontrasena);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(366, 126, 86, 20);
		contentPanel.add(textemail);
		
		texttiempo = new JTextField();
		texttiempo.setColumns(10);
		texttiempo.setBounds(468, 126, 86, 20);
		contentPanel.add(texttiempo);
		
		// Etiquetas para los campos
		JLabel lblNewLabel_1 = new JLabel("IDJugador");
		lblNewLabel_1.setBounds(69, 101, 76, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(168, 101, 46, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contraseña");
		lblNewLabel_1_2.setBounds(267, 101, 76, 14);
		contentPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setBounds(366, 101, 46, 14);
		contentPanel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tiempo");
		lblNewLabel_1_4.setBounds(468, 101, 46, 14);
		contentPanel.add(lblNewLabel_1_4);
		
		
	}
	// Función para actualizar la tabla con datos de la base de datos
	private void actualizarTabla() {
	    JugadoresTableModel model = controller.obtenerTablaJugadores();
	    JtableJugadores.setModel(model);
	}
}