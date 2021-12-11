package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.Canvas;
import javax.swing.JTextField;

import controller.PIXTransactionController;
import entities.Client;
import model.ClientsDataBase;

import java.awt.event.ActionListener;

public class PIXTransactionView {

	private JFrame frame;
	private JTextField textField_PIXKEYReceiver;
	private JTextField textField_Value;
	private Client current_client;
	

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PIXTransactionView window = new PIXTransactionView();
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
	public PIXTransactionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PIX Transaction");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel.setBounds(160, 11, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Value:");
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(151, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_PIXKEYReceiver = new JTextField();
		textField_PIXKEYReceiver.setBackground(new Color(240, 255, 255));
		textField_PIXKEYReceiver.setBounds(248, 127, 140, 20);
		frame.getContentPane().add(textField_PIXKEYReceiver);
		textField_PIXKEYReceiver.setColumns(10);
		
		JButton btnNewButton = new JButton("transfer now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PIXTransactionController.pixTransactionControllerFunction(frame, current_client, textField_Value.getText(), textField_PIXKEYReceiver.getText());
			}
		});
		btnNewButton.setBackground(new Color(245, 222, 179));
		btnNewButton.setBounds(170, 192, 107, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Receiver PIX key:");
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(94, 126, 117, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_Value = new JTextField();
		textField_Value.setColumns(10);
		textField_Value.setBackground(new Color(240, 255, 255));
		textField_Value.setBounds(248, 86, 140, 20);
		frame.getContentPane().add(textField_Value);
		
		JButton btn_back = new JButton("<<");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientFunctionInterface ifc = new ClientFunctionInterface();
				getFrame().setVisible(false);
				ifc.getFrame().setVisible(true);
			}
		});
		btn_back.setBounds(10, 227, 55, 23);
		frame.getContentPane().add(btn_back);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
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
