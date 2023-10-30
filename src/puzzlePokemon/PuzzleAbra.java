package puzzlePokemon;

import javax.swing.*;

import diseño.EligePuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PuzzleAbra {
	private JFrame frame; // La ventana principal del juego
	private JPanel puzzlePanel; // Panel que contiene los botones del rompecabezas
	private JButton[][] puzzleButtons; // Botones que representan las piezas del rompecabezas
	private BufferedImage originalImage; // La imagen original
	private BufferedImage[] puzzleImages; // Piezas del rompecabezas
	private int numRows = 3; // Número de filas del rompecabezas
	private int numCols = 3; // Número de columnas del rompecabezas
	private int emptyRow = 2; // Fila vacía
	private int emptyCol = 2; // Columna vacía
	private Clip clip;

	// Agregar un contador de tiempo
	private int elapsedTime = 0; // Contador de tiempo en segundos
	private JLabel timeLabel; // Etiqueta para mostrar el tiempo transcurrido
	private Timer timer; // Temporizador para actualizar el tiempo

	public PuzzleAbra() {
		// Llama al método para reproducir el audio
		reproducirAudioEnBucle("./src/recursos/Pokemon Pinball OST  Blue Field.wav");

		frame = new JFrame("Puzzle Game"); // Crear la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar acción de cierre

		try {
			originalImage = ImageIO.read(new File("./src/recursos/AbraPuzzle.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		puzzleImages = splitImage(originalImage, numRows, numCols); // Dividir la imagen en piezas

		// Mezcla aleatoriamente las piezas del rompecabezas
		List<ImageIcon> imageList = new ArrayList<>();
		for (BufferedImage img : puzzleImages) {
			imageList.add(new ImageIcon(img));
		}
		Collections.shuffle(imageList);

		puzzlePanel = new JPanel(new GridLayout(numRows, numCols)); // Crear el panel del rompecabezas
		puzzleButtons = new JButton[numRows][numCols]; // Crear la matriz de botones

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				int index = i * numCols + j;
				puzzleButtons[i][j] = new JButton(imageList.get(index)); // Asignar imágenes a los botones
				puzzleButtons[i][j].addActionListener(new ButtonClickListener(i, j)); // Agregar ActionListener
				puzzlePanel.add(puzzleButtons[i][j]); // Agregar botón al panel
			}
		}

		frame.add(puzzlePanel, BorderLayout.CENTER); // Agregar el panel al centro de la ventana

		JPanel guidePanel = new JPanel();
		JLabel guideLabel = new JLabel(new ImageIcon(originalImage));
		guidePanel.add(guideLabel);
		frame.add(guidePanel, BorderLayout.EAST); // Agregar la imagen guía a la derecha

		// Agregar un JLabel para mostrar el tiempo transcurrido
		timeLabel = new JLabel("Tiempo: 0 segundos");
		guidePanel.add(timeLabel);

		Image icon = Toolkit.getDefaultToolkit().getImage("./src/recursos/Home.jfif");
		frame.setIconImage(icon);

		frame.pack(); // Ajustar el tamaño de la ventana
		frame.setPreferredSize(new Dimension(400, 400)); // Establecer el tamaño preferido
		frame.setVisible(true); // Hacer visible la ventana
		
		// Crear el botón "Volver" y agregarlo a la ventana
        JButton backButton = new JButton("Volver a Elegir");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regresarAEligePuzzle();
            }
        });
        
        guidePanel.add(backButton);

		// Configura un Timer para actualizar el tiempo cada segundo
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				elapsedTime++;
				timeLabel.setText("Tiempo: " + elapsedTime + " segundos");
			}
		});
		timer.start(); // Iniciar el temporizador
	}

	private BufferedImage[] splitImage(BufferedImage image, int rows, int cols) {
		int pieceWidth = image.getWidth() / cols;
		int pieceHeight = image.getHeight() / rows;
		BufferedImage[] images = new BufferedImage[rows * cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int x = j * pieceWidth;
				int y = i * pieceHeight;
				images[i * cols + j] = image.getSubimage(x, y, pieceWidth, pieceHeight);
			}
		}

		return images;
	}

	private class ButtonClickListener implements ActionListener {
		private int row;
		private int col;

		public ButtonClickListener(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if ((Math.abs(row - emptyRow) == 1 && col == emptyCol)
					|| (Math.abs(col - emptyCol) == 1 && row == emptyRow)) {
				puzzleButtons[emptyRow][emptyCol].setIcon(puzzleButtons[row][col].getIcon());
				puzzleButtons[row][col].setIcon(null);
				emptyRow = row;
				emptyCol = col;

				if (isPuzzleSolved()) {
					timer.stop(); // Detener el contador de tiempo
					JOptionPane.showMessageDialog(frame, "¡Felicidades! Has completado el rompecabezas.");
				}
			}
		}
	}

	private boolean isPuzzleSolved() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (puzzleButtons[i][j].getIcon() != puzzleImages[i * numCols + j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new PuzzleAbra();
		});
	}

	// Método para reproducir audio en bucle
	private void reproducirAudioEnBucle(String rutaArchivoAudio) {
		try {
			// Obtén una instancia de Clip
			clip = AudioSystem.getClip();

			// Abre el archivo de audio
			clip.open(AudioSystem.getAudioInputStream(new File(rutaArchivoAudio)));

			// Reproduce el audio en bucle infinitamente (-1)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
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
	// Agregar el método para regresar a EligePuzzle
    private void regresarAEligePuzzle() {
        frame.dispose(); // Cierra la ventana actual
      //Parar audio
        clip.stop();
		
		EligePuzzle eligePuzzle = new EligePuzzle();
		eligePuzzle.setLocationRelativeTo(null);
		
		eligePuzzle.setVisible(true);	
    }
}
