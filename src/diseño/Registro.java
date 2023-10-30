package diseño;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Registro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Clip clip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registro() {
		// Llama al método para reproducir el audio
		reproducirAudio("./src/recursos/Música de Pokemon Red & Blue - El Camino a Ciudad Verde.wav");

		setIconImage(Toolkit.getDefaultToolkit().getImage("./src/recursos/Home.jfif"));
		setTitle("Registro");
		setBounds(100, 100, 547, 443);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Inicio");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (camposValidos()) {
						irAInicio();
					} else {
						mostrarMensajeDeError();
					}
				}

				private void irAInicio() {
					// Detener la reproducción del audio
					clip.stop();
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

				private void mostrarMensajeDeError() {
					JOptionPane.showMessageDialog(contentPanel,
							"Por favor, complete todos los campos antes de ir a la pantalla de inicio.",
							"Campos vacíos", JOptionPane.ERROR_MESSAGE);
				}
			});
			btnNewButton.setBounds(143, 370, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("Usuario");
			lblNewLabel.setBounds(164, 264, 89, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblContrasea = new JLabel("Contraseña");
			lblContrasea.setBounds(164, 295, 68, 14);
			contentPanel.add(lblContrasea);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setBounds(164, 328, 68, 14);
			contentPanel.add(lblEmail);
		}
		{
			textField = new JTextField();
			textField.setBounds(263, 261, 141, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(263, 325, 141, 20);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(263, 292, 141, 20);
			contentPanel.add(textField_2);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(
					new ImageIcon("./src/recursos/DreamHackDallas2023_Freeplay_PokemonPuzzleLeague.png"));
			lblNewLabel_1.setBounds(0, 0, 531, 253);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Cerrar la ventana actual
					dispose();
					// Llamar al método para ir a la ventana de inicio
					IrAHome();
				}

				private void IrAHome() {
					// Detener la reproducción del audio
					clip.stop();
					// Crear una nueva ventana de Home
					Home home = new Home();
					// Configurar la ubicación en el centro de la pantalla
					home.setLocationRelativeTo(null);
					// Mostrar la ventana de Home
					home.setVisible(true);
				}
			});
			btnVolver.setBounds(263, 370, 89, 23);
			contentPanel.add(btnVolver);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("./src/recursos/Squirtle2.png"));
			lblNewLabel_2.setBounds(406, 204, 125, 200);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon("./src/recursos/Bulbasaur2.png"));
			lblNewLabel_3.setBounds(-17, 231, 182, 173);
			contentPanel.add(lblNewLabel_3);
		}
	}

	// Método para verificar si los campos están vacíos
	private boolean camposValidos() {
		String usuario = textField.getText();
		String contrasena = textField_2.getText();
		String email = textField_1.getText();
		return !usuario.isEmpty() && !contrasena.isEmpty() && !email.isEmpty();
	}

	// Método para reproducir audio
	private void reproducirAudio(String rutaArchivoAudio) {
		try {
			// Obtén una instancia de Clip
			clip = AudioSystem.getClip();

			// Abre el archivo de audio
			clip.open(AudioSystem.getAudioInputStream(new File(rutaArchivoAudio)));

			// Reproduce el audio
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void windowClosing(WindowEvent e) {
		// Detener la reproducción del audio
		clip.stop();
	}
}
