package diseño;

import java.awt.BorderLayout;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import puzzlePokemon.PuzzleGame;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import puzzlePokemon.PuzzleGrowlithe;
import puzzlePokemon.PuzzleAbra;
import puzzlePokemon.PuzzleHorsea;
import puzzlePokemon.PuzzleJigglypuff;
import puzzlePokemon.PuzzleScyther;


public class EligePuzzle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Clip clip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EligePuzzle dialog = new EligePuzzle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EligePuzzle() {
		// Llama al método para reproducir el audio
	    reproducirAudio("./src/recursos/Evolution.wav");
		
		setTitle("Elige Puzzle");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./src/recursos/Home.jpg"));
		setBounds(100, 100, 319, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./src/recursos/PokeLogo.png"));
		lblNewLabel.setBounds(34, -11, 216, 174);
		contentPanel.add(lblNewLabel);
		
		JButton btnPikachu = new JButton("");
		btnPikachu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				irAPuzzleGame();
			}

			private void irAPuzzleGame() {
				// Detener la reproducción del audio
		        clip.stop();
		        dispose();
				PuzzleGame puzzleGame = new PuzzleGame();
			
			}
		});
		btnPikachu.setIcon(new ImageIcon("./src/recursos/Pikachu.jpg"));
		btnPikachu.setBounds(56, 209, 59, 59);
		contentPanel.add(btnPikachu);
		
		JButton btnGrowlithe = new JButton("");
		btnGrowlithe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleGrowlithe();
			}

			private void IrAPuzzleGrowlithe() {
				// Detener la reproducción del audio
		        clip.stop();
		        dispose();
				PuzzleGrowlithe puzzleGrowlithe = new PuzzleGrowlithe();
				
			}
		});
		btnGrowlithe.setIcon(new ImageIcon("./src/recursos/Growlithe.jpg"));
		btnGrowlithe.setBounds(191, 209, 59, 59);
		contentPanel.add(btnGrowlithe);
		
		JButton btnJigglypuff = new JButton("");
		btnJigglypuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleJigglypuff();
			}

			private void IrAPuzzleJigglypuff() {
				// Detener la reproducción del audio
		        clip.stop();
		        dispose();
				PuzzleJigglypuff puzzleJigglypuff = new PuzzleJigglypuff();
				
			}
		});
		btnJigglypuff.setIcon(new ImageIcon("./src/recursos/Jigglypuff.jpg"));
		btnJigglypuff.setBounds(56, 279, 59, 59);
		contentPanel.add(btnJigglypuff);
		
		JButton btnHorsea = new JButton("");
		btnHorsea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleHorsea();
			}

			private void IrAPuzzleHorsea() {
				// Detener la reproducción del audio
		        clip.stop();
		        dispose();
				PuzzleHorsea puzzleHorsea = new PuzzleHorsea();
				
			}
		});
		btnHorsea.setIcon(new ImageIcon("./src/recursos/Horsea.jpg"));
		btnHorsea.setBounds(191, 279, 59, 59);
		contentPanel.add(btnHorsea);
		
		JButton btnAbra = new JButton("");
		btnAbra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleAbra();
			}

			private void IrAPuzzleAbra() {
				// Detener la reproducción del audio
		        clip.stop();
		        dispose();
				PuzzleAbra puzzleAbra = new PuzzleAbra();
				
			}
		});
		btnAbra.setIcon(new ImageIcon("./src/recursos/Abra.jpg"));
		btnAbra.setBounds(56, 349, 59, 59);
		contentPanel.add(btnAbra);
		
		JButton btnScyther = new JButton("");
		btnScyther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleScyther();
					
				}
				private void IrAPuzzleScyther() {
					// Detener la reproducción del audio
			    clip.stop();
			    dispose();
				PuzzleScyther puzzleScyther = new PuzzleScyther();
			}
		});
		btnScyther.setIcon(new ImageIcon("./src/recursos/Scyther.jpg"));
		btnScyther.setBounds(191, 349, 59, 59);
		contentPanel.add(btnScyther);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IrAInicio();
			}

			private void IrAInicio() {
				// Detener la reproducción del audio
		        clip.stop();
		        
				Inicio inicio = new Inicio();
				inicio.setLocationRelativeTo(null);
						inicio.setModal(true);
						inicio.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(104, 431, 89, 23);
		contentPanel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("¡Elige a tu Pokémon!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(87, 171, 148, 14);
		contentPanel.add(lblNewLabel_1);
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
