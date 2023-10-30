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
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Inicio extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Clip clip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inicio() {
		// Llama al método para reproducir el audio
	    reproducirAudio("C:\\Users\\danir\\Music\\Música de Pokemon Red & Blue - Camino a la Casa de Bill.wav");
	    
		setTitle("Inicio");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danir\\Downloads\\Home.jfif"));
		setBounds(100, 100, 285, 585);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\PokeLogo.png"));
		lblNewLabel.setBounds(17, -16, 252, 203);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Jugar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAEligePuzzle();
			}

			private void IrAEligePuzzle() {
				//Parar audio
		        clip.stop();
				dispose();
				EligePuzzle eligePuzzle = new EligePuzzle();
				eligePuzzle.setLocationRelativeTo(null);
				
				eligePuzzle.setVisible(true);			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(23, 267, 179, 48);
		contentPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\pokes.jpg"));
		lblNewLabel_1.setBounds(23, 182, 182, 87);
		contentPanel.add(lblNewLabel_1);
		
		JButton btnRecords = new JButton("Records");
		btnRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrARecords();
			}

			private void IrARecords() {
				//Parar audio
		        clip.stop();
				dispose();
				Records records = new Records();
				records.setLocationRelativeTo(null);
				records.setModal(true);
				records.setVisible(true);
				
			}
		});
		btnRecords.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRecords.setBounds(23, 429, 182, 48);
		contentPanel.add(btnRecords);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\danir\\Downloads\\14721e3a-3653-4fd7-80ac-047ba0e829fb_1190x500.jpg"));
		lblNewLabel_1_1.setBounds(23, 342, 182, 87);
		contentPanel.add(lblNewLabel_1_1);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IrAHome();
			}

			private void IrAHome() {
				//Parar audio
		        clip.stop();
				Home home = new Home();
					home.setLocationRelativeTo(null);
					home .setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSalir.setBounds(23, 488, 179, 48);
		contentPanel.add(btnSalir);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Charmander2.png"));
		lblNewLabel_2.setBounds(194, 367, 174, 180);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Eevee2.png"));
		lblNewLabel_2_1.setBounds(194, 155, 174, 191);
		contentPanel.add(lblNewLabel_2_1);
	}

	//Método para reproducir audio
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