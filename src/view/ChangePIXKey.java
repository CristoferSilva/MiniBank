package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.ChangePIXkeyController;
import entities.Client;
import model.ClientsDataBase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePIXKey {

	private JFrame frame;
	private JTextField textField;
	private Client current_client;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePIXKey window = new ChangePIXKey();
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
	public ChangePIXKey() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter new key:");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		lblNewLabel.setBounds(124, 81, 95, 19);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(229, 82, 95, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("change now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				ChangePIXkeyController.changePIXkeyFunctionController(getFrame(), current_client, textField.getText());
			}
		});
		btnNewButton.setBackground(new Color(240, 230, 140));
		btnNewButton.setBounds(174, 164, 106, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Change PIX key");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel_1.setBounds(161, 11, 108, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btn_back = new JButton("<<");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFunctionInterface ifc = new ClientFunctionInterface();
				getFrame().setVisible(false);
				ifc.getFrame().setVisible(true);
			}
		});
		btn_back.setBounds(10, 227, 49, 23);
		frame.getContentPane().add(btn_back);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public Client getCourrent_client() {
		return current_client;
	}
	public void setCourrent_client(Client courrent_client) {
		this.current_client = courrent_client;
	}
}
