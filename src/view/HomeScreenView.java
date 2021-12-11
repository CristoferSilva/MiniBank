package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

import controller.LoginController;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class HomeScreenView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreenView window = new HomeScreenView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeScreenView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 569, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController.showLoginWindow(getFrame());
			}
		});
		btnNewButton.setBounds(215, 125, 112, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Pear Bank");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 26));
		lblNewLabel.setBounds(215, 46, 128, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		lblNewLabel_1_1.setBounds(10, 204, 533, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		TextArea textArea = new TextArea();
		textArea.setColumns(10);
		textArea.setText("ABOUT: \r\n\r\nIn Portuguese: Este \u00E9 um mini sistema para realizar algumas opera\u00E7\u00F5es. Para acessar voc\u00EA\r\nprecisa ser um cliente cadastrado. Para se cadastrar, nesta vers\u00E3o, ligue para o suporte.\r\nNesta vers\u00E3o embrion\u00E1ria do sistema \u00E9 poss\u00EDvel apenas fazer transa\u00E7\u00F5es pix e mudar sua chave pix.\r\n\r\nFique atento \u00E0s vers\u00F5es futuras.\r\n\r\nIn English: This is a mini system to perform some operations. To access you\r\nmust be a registered customer. To register, call support. In this embryonic \r\nversion of the system it is only possible to do pix transactions and change your pix key. \r\n\r\nKeep an eye out for future releases.\r\n\r\n");
		textArea.setBackground(new Color(255, 248, 220));
		textArea.setBounds(10, 240, 533, 144);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(10, 11, 533, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
	}
	public JFrame getFrame() {
		return frame;
	}
}
