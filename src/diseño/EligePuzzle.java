package diseño;

import java.awt.BorderLayout;
import puzzlePokemon.PuzzleGame;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import puzzlePokemon.PuzzleGame;
import puzzlePokemon.PuzzleGrowlithe;
import puzzlePokemon.PuzzleAbra;
import puzzlePokemon.PuzzleHorsea;
import puzzlePokemon.PuzzleJigglypuff;
import puzzlePokemon.PuzzleScyther;
import diseño.Inicio;

public class EligePuzzle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
		setTitle("Elige Puzzle");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danir\\Pictures\\Home.jpg"));
		setBounds(100, 100, 319, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\PokeLogo.png"));
		lblNewLabel.setBounds(34, -11, 216, 174);
		contentPanel.add(lblNewLabel);
		
		JButton btnPikachu = new JButton("");
		btnPikachu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				irAPuzzleGame();
			}

			private void irAPuzzleGame() {
				
				PuzzleGame puzzleGame = new PuzzleGame();
			
			}
		});
		btnPikachu.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Iconos\\Pikachu.jpg"));
		btnPikachu.setBounds(56, 209, 59, 59);
		contentPanel.add(btnPikachu);
		
		JButton btnGrowlithe = new JButton("");
		btnGrowlithe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleGrowlithe();
			}

			private void IrAPuzzleGrowlithe() {
				PuzzleGrowlithe puzzleGrowlithe = new PuzzleGrowlithe();
				
			}
		});
		btnGrowlithe.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Iconos\\Growlithe.jpg"));
		btnGrowlithe.setBounds(191, 209, 59, 59);
		contentPanel.add(btnGrowlithe);
		
		JButton btnJigglypuff = new JButton("");
		btnJigglypuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleJigglypuff();
			}

			private void IrAPuzzleJigglypuff() {
				PuzzleJigglypuff puzzleJigglypuff = new PuzzleJigglypuff();
				
			}
		});
		btnJigglypuff.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Iconos\\Jigglypuff.jpg"));
		btnJigglypuff.setBounds(56, 279, 59, 59);
		contentPanel.add(btnJigglypuff);
		
		JButton btnHorsea = new JButton("");
		btnHorsea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleHorsea();
			}

			private void IrAPuzzleHorsea() {
				PuzzleHorsea puzzleHorsea = new PuzzleHorsea();
				
			}
		});
		btnHorsea.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Iconos\\Horsea.jpg"));
		btnHorsea.setBounds(191, 279, 59, 59);
		contentPanel.add(btnHorsea);
		
		JButton btnAbra = new JButton("");
		btnAbra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IrAPuzzleAbra();
			}

			private void IrAPuzzleAbra() {
				PuzzleAbra puzzleAbra = new PuzzleAbra();
				
			}
		});
		btnAbra.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Iconos\\Abra.jpg"));
		btnAbra.setBounds(56, 349, 59, 59);
		contentPanel.add(btnAbra);
		
		JButton btnScyther = new JButton("");
		btnScyther.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PuzzleScyther puzzleScyther = new PuzzleScyther();
			}
		});
		btnScyther.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\Iconos\\Scyther.jpg"));
		btnScyther.setBounds(191, 349, 59, 59);
		contentPanel.add(btnScyther);
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IrAInicio();
			}

			private void IrAInicio() {
				
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
}
