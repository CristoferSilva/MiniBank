package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import entities.Client;
import model.ClientsDataBase;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textCPF;
	private Client current_client;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setLayout(null);
		
		JButton btn_LogIn = new JButton("Log In");
		btn_LogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClientFunctionInterface ifc = new ClientFunctionInterface();
					ClientsDataBase cdb = new ClientsDataBase();
					Client courrentClient = cdb.searchClientIntheDatabase(textCPF.getText());
					
					boolean passwordIsValid;
					String password = "";
					char[] passwordChar = passwordField.getPassword();
					for (int i = 0; i < passwordChar.length; i++) {
						password += passwordChar[i];
					}
					passwordIsValid = cdb.validateLogIn(textField.getText(), password);
					
					if (passwordIsValid) {
						getFrame().setVisible(false);
						ifc.setCourrent_client(courrentClient);
						ifc.getFrame().setVisible(true);
					}
					
					current_client = courrentClient;
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btn_LogIn.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btn_LogIn);
		
		textField = new JTextField();
		textField.setBackground(new Color(240, 255, 255));
		textField.setBounds(106, 129, 228, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Card Number:");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblNewLabel.setBounds(106, 104, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 14));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(106, 160, 74, 14);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Who are you?");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(170, 11, 105, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(240, 255, 255));
		passwordField.setBounds(106, 185, 228, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(106, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textCPF = new JTextField();
		textCPF.setBackground(new Color(240, 255, 255));
		textCPF.setBounds(106, 73, 228, 20);
		frame.getContentPane().add(textCPF);
		textCPF.setColumns(10);
		frame.setBounds(100, 100, 450, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public JFrame getFrame() {
		return frame;
	}
	public Client getCourrent_client() {
		return current_client;
	}
}
