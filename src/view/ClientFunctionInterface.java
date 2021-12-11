package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

import entities.Client;
import model.ClientsDataBase;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class ClientFunctionInterface {

	private JFrame frame;
	private Client current_client;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFunctionInterface window = new ClientFunctionInterface();
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
	public ClientFunctionInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(143, 188, 143));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What do you want?");
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 15));
		lblNewLabel.setBounds(199, 31, 136, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btn_PIXTransfer = new JButton("open transfer PIX window");
		btn_PIXTransfer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_PIXTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PIXTransactionView ptv = new PIXTransactionView();
				ptv.setCourrent_client(getCourrent_client());
				getFrame().setVisible(false);
				ptv.getFrame().setVisible(true);
			}
		});
		btn_PIXTransfer.setBounds(194, 110, 157, 23);
		frame.getContentPane().add(btn_PIXTransfer);
		
		JLabel lblNewLabel_1 = new JLabel("PIX transfer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(231, 85, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Change PIX key");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(217, 156, 96, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JButton btn_ChangePIXkey = new JButton("open change PIX window");
		btn_ChangePIXkey.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_ChangePIXkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePIXKey change = new ChangePIXKey();
				getFrame().setVisible(false);
				change.setCourrent_client(getCourrent_client());
				change.getFrame().setVisible(true);
			}
		});
		btn_ChangePIXkey.setBounds(194, 192, 157, 23);
		frame.getContentPane().add(btn_ChangePIXkey);
		frame.setBounds(100, 100, 555, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn_homeScreen = new JButton("Home Screen");
		btn_homeScreen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_homeScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreenView hsv = new HomeScreenView();
				getFrame().setVisible(false);
				hsv.getFrame().setVisible(true);
			}
		});
		btn_homeScreen.setBounds(10, 246, 109, 23);
		frame.getContentPane().add(btn_homeScreen);
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
