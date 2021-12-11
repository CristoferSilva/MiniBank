package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Client;
import model.ClientsDataBase;
import view.ChangePIXKey;
import view.ClientFunctionInterface;

public class ChangePIXkeyController {
	public static void changePIXkeyFunctionController(JFrame jFrame, Client client, String textFildPIXkey) {
		ClientFunctionInterface cfi = new ClientFunctionInterface();
		cfi.setCourrent_client(client);
		ClientsDataBase cdb = new ClientsDataBase();
		String cardNumber = client.getCard().getCardNumber();
		
		if(textFildPIXkey.length() < 9) {
			JOptionPane.showMessageDialog(null, "the key needs to suit at least 9 characters!");
		} else {
			try {
				boolean wasChanged = cdb.changePIXkeyInTheDataBase(cardNumber, textFildPIXkey);
				
				if(wasChanged) {
					JOptionPane.showMessageDialog(null, "Succssesfully done!");
				} else {
					JOptionPane.showMessageDialog(null, "could not perform the operation. Call support!!!");
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "ERRO!!!! REINICIE O PROGRAMA");
			}
		}
		
		jFrame.setVisible(false);
		cfi.getFrame().setVisible(true);
	}
}
	
