package diseño;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ContrasenaOlvidada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Clip clip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ContrasenaOlvidada dialog = new ContrasenaOlvidada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ContrasenaOlvidada() {
		// Llama al método para reproducir el audio
		reproducirAudio("C:\\Users\\danir\\Music\\Pokemon-Pinball-OST-Game-Over.wav");

		setTitle("Contraseña olvidada");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danir\\Downloads\\Home.jfif"));
		setBounds(100, 100, 268, 423);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\PokeLogo.png"));
			lblNewLabel.setBounds(10, 11, 230, 154);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Email");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel_1.setBounds(25, 216, 54, 35);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField = new JTextField();
			textField.setBounds(89, 226, 151, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("Enviar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					IrAContrasenaEnviada();

				}

				private void IrAContrasenaEnviada() {
					// Detener la reproducción del audio
					clip.stop();
					ContrasenaEnviada contrasenaEnviada = new ContrasenaEnviada();
					contrasenaEnviada.setLocationRelativeTo(null);
					contrasenaEnviada.setModal(true);
					contrasenaEnviada.setVisible(true);

				}
			});
			btnNewButton.setBounds(151, 281, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setBounds(151, 326, 89, 23);
			contentPanel.add(btnSalir);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Jigglypuff2.png"));
			lblNewLabel_2.setBounds(0, 246, 158, 138);
			contentPanel.add(lblNewLabel_2);
		}
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

	// Implementa el método windowClosing para detener la reproducción del audio
	// antes de cerrar la ventana
	public void windowClosing(WindowEvent e) {
		// Detener la reproducción del audio
		clip.stop();
	}
}
