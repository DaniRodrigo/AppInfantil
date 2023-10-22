package puzzlePokemon;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class PuzzleHorsea{
    private JFrame frame;
    private JPanel puzzlePanel;
    private JButton[][] puzzleButtons;
    private BufferedImage originalImage;
    private BufferedImage[] puzzleImages;
    private int numRows = 3;
    private int numCols = 3;
    private int emptyRow = 2;
    private int emptyCol = 2;

    // Agregar un contador de tiempo
    private int elapsedTime = 0;
    private JLabel timeLabel;
    private Timer timer;

    public PuzzleHorsea() {
        frame = new JFrame("Puzzle Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            originalImage = ImageIO.read(new File("C:\\Users\\danir\\Pictures\\Iconos\\HorseaPuzzle.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        puzzleImages = splitImage(originalImage, numRows, numCols);

        // Mezcla aleatoriamente las piezas del rompecabezas
        List<ImageIcon> imageList = new ArrayList<>();
        for (BufferedImage img : puzzleImages) {
            imageList.add(new ImageIcon(img));
        }
        Collections.shuffle(imageList);

        puzzlePanel = new JPanel(new GridLayout(numRows, numCols));
        puzzleButtons = new JButton[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int index = i * numCols + j;
                puzzleButtons[i][j] = new JButton(imageList.get(index));
                puzzleButtons[i][j].addActionListener(new ButtonClickListener(i, j));
                puzzlePanel.add(puzzleButtons[i][j]);
            }
        }

        frame.add(puzzlePanel, BorderLayout.CENTER);

        JPanel guidePanel = new JPanel();
        JLabel guideLabel = new JLabel(new ImageIcon(originalImage));
        guidePanel.add(guideLabel);
        frame.add(guidePanel, BorderLayout.EAST);

        // Agregar un JLabel para mostrar el tiempo transcurrido
        timeLabel = new JLabel("Tiempo: 0 segundos");
        guidePanel.add(timeLabel);

        frame.pack();
        frame.setPreferredSize(new Dimension(400, 400)); // Ajusta el tamaño de la ventana
        frame.setVisible(true);

        // Configura un Timer para actualizar el tiempo cada segundo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                timeLabel.setText("Tiempo: " + elapsedTime + " segundos");
            }
        });
        timer.start();
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
            if ((Math.abs(row - emptyRow) == 1 && col == emptyCol) || (Math.abs(col - emptyCol) == 1 && row == emptyRow)) {
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
            new PuzzleHorsea();
        });
    }
}
