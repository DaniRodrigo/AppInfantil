package diseño;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class ContrasenaEnviada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ContrasenaEnviada dialog = new ContrasenaEnviada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ContrasenaEnviada() {
		setTitle("Contraseña enviada");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danir\\Downloads\\Home.jfif"));
		setBounds(100, 100, 252, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\danir\\Pictures\\PokeLogo.png"));
			lblNewLabel.setBounds(0, 0, 250, 160);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contraseña enviada a tu email");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setBounds(25, 171, 185, 59);
			contentPanel.add(lblNewLabel_1);
		}
	}

}
