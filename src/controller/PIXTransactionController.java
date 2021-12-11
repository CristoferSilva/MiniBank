package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entities.Client;
import model.ClientsDataBase;
import view.ClientFunctionInterface;

public class PIXTransactionController {
	public static void pixTransactionControllerFunction(JFrame jFrame, Client client, String textValue, String PIXKEYReceiver) {

		boolean successfulTransfer;
		ClientsDataBase cdb = new ClientsDataBase();
		ClientFunctionInterface cfi = new ClientFunctionInterface();
		cfi.setCourrent_client(client);
		
		String senderAccountNumber = client.getCard().getCheckingAccount().getAccountNumber();
		
		int valueInTheCheckingAccount = client.getCard().getCheckingAccount().getValue();
		int valueToTransfer = Integer.parseInt(textValue);
		
		try {
			if(valueInTheCheckingAccount < valueToTransfer) {
				JOptionPane.showMessageDialog(null, "you dont't have enough balance!!!!!!");
			}else if (!cdb.thePixKeyIsInTheDataBase(PIXKEYReceiver)){
				JOptionPane.showMessageDialog(null, "this PIX key doesn't exist in the Data Base!!!!!!");
			}else {
				successfulTransfer = cdb.transferValueinTheDatabase(senderAccountNumber, PIXKEYReceiver, valueToTransfer);
				
				if(successfulTransfer) {
					JOptionPane.showMessageDialog(null, "SUCCESSFUL TRANSFER !!!!!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "could not perform the operation. Call support!");
				}
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "could not perform the operation. Call support!");
		}
		
		jFrame.setVisible(false);
		cfi.getFrame().setVisible(true);
	}
}
