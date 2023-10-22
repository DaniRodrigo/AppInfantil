package diseño;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Toolkit;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private final JButton btnNoContrasena = new JButton("Si");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
	    setTitle("Pokemon Puzzle League");
	    setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danir\\Downloads\\Home.jfif"));

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 235, 488);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(contentPane);

	    JButton btnRegistro = new JButton("Registro");
	    btnRegistro.setBounds(55, 366, 108, 23);
	    btnRegistro.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            irARegistro();
	        }

	        public void irARegistro() {
                // Cerrar la ventana actual
                dispose();
                // Crear una nueva ventana de Registro
                Registro registro = new Registro();
                // Configurar la ubicación en el centro de la pantalla
                registro.setLocationRelativeTo(null);
                // Hacer la ventana modal (bloquear la interacción con otras ventanas)
                registro.setModal(true);
                // Mostrar la ventana de Registro
                registro.setVisible(true);
            }
        });

	    contentPane.setLayout(null);
	    contentPane.add(btnRegistro);

	    JLabel lblLogo = new JLabel("");
	    lblLogo.setIcon(new ImageIcon("C:\\Users\\danir\\Downloads\\Home.jfif"));
	    lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
	    lblLogo.setBounds(0, 0, 225, 225);
	    contentPane.add(lblLogo);

	    textFieldUsuario = new JTextField();
	    textFieldUsuario.setBounds(93, 257, 103, 20);
	    contentPane.add(textFieldUsuario);
	    textFieldUsuario.setColumns(10);

	    textFieldContrasena = new JTextField();
	    textFieldContrasena.setColumns(10);
	    textFieldContrasena.setBounds(93, 288, 103, 20);
	    contentPane.add(textFieldContrasena);

	    JLabel lblNewLabel_1 = new JLabel("Usuario");
	    lblNewLabel_1.setBounds(10, 263, 73, 14);
	    contentPane.add(lblNewLabel_1);

	    JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
	    lblNewLabel_1_1.setBounds(10, 291, 73, 14);
	    contentPane.add(lblNewLabel_1_1);

	    JButton btnInicio = new JButton("Inicio");
	    btnInicio.setBounds(55, 333, 108, 23);
	    btnInicio.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Obtener el contenido de los campos "Usuario" y "Contraseña"
	            String usuario = textFieldUsuario.getText();
	            String contrasena = textFieldContrasena.getText();

	            // Validar si los campos están vacíos
	            if (usuario.isEmpty() || contrasena.isEmpty()) {
	                // Mostrar un mensaje de error si los campos están vacíos
	                JOptionPane.showMessageDialog(null, "Por favor, ingrese el usuario y la contraseña.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
	            } else {
	                // Si los campos no están vacíos, continuar con la acción del botón "Inicio"
	                irAInicio();
	            }
	        }

	        private void irAInicio() {
                // Cerrar la ventana actual
                dispose();
                // Crear una nueva ventana de Inicio
                Inicio inicio = new Inicio();
                // Configurar la ubicación en el centro de la pantalla
                inicio.setLocationRelativeTo(null);
                // Hacer la ventana modal (bloquear la interacción con otras ventanas)
                inicio.setModal(true);
                // Mostrar la ventana de Inicio
                inicio.setVisible(true);
            }
        });

	    contentPane.add(btnInicio);

	    JLabel lblNewLabel_1_1_1 = new JLabel("¿Olvidaste tu contraseña? ");
	    lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
	    lblNewLabel_1_1_1.setBounds(10, 413, 128, 25);
	    contentPane.add(lblNewLabel_1_1_1);

	    btnNoContrasena.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            IrAContrasenaOlvidada();
	        }

	        private void IrAContrasenaOlvidada() {
                // Crear una nueva ventana de ContrasenaOlvidada
                ContrasenaOlvidada contrasenaOlvidada = new ContrasenaOlvidada();
                // Configurar la ubicación en el centro de la pantalla
                contrasenaOlvidada.setLocationRelativeTo(null);
                // Hacer la ventana modal (bloquear la interacción con otras ventanas)
                contrasenaOlvidada.setModal(true);
                // Mostrar la ventana de ContrasenaOlvidada
                contrasenaOlvidada.setVisible(true);
            }
        });

	    btnNoContrasena.setBounds(144, 414, 52, 23);
	    contentPane.add(btnNoContrasena);
	}
}
