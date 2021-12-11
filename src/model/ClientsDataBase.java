package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import entities.Agency;
import entities.BankAccount;
import entities.BankBill;
import entities.Client;
import entities.CustomerCard;

import java.sql.DriverManager;



public class ClientsDataBase {
	public ClientsDataBase(){
	}

	public boolean insertAddressIntheDatabase(String address) throws Exception {
		
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		
		address = "'" + address + "'";

		try {
			rs = st.executeQuery(
					"INSERT INTO addresses (address) VALUES (" + address +");");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}

	public boolean insertAgencyIntheDatabase(int agencyNumber, int address_id) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection =  this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		
		try {
			rs = st.executeQuery("INSERT INTO agencies (agencyNumber, address) VALUES" + " (" + agencyNumber + ","
					+ address_id + " ); ");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}

	public boolean insertAccountIntheDatabase(int value, int agency_id, String type, int accountNumber) throws Exception {
		type = "'" + type + "'";
		ResultSet rs;
		Statement st;
		Connection connection =  this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("INSERT INTO bankaccounts (value, agency_id, accountNumber, type) VALUES" + " ("
					+ value + "," + agency_id + "," + accountNumber + "," + type + " ); ");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;

	}

	public boolean insertCustomerCardIntheDatabase(String cardNumber, String password, int creditLimit,
			int creditGiven, String dueDate, int checkingAccount_id, int savingsAccount_id,
			String chavePIX, int owner_id) throws Exception {
		dueDate = "'" + dueDate + "'";
		password = "'" + password + "'";
		chavePIX = "'" + chavePIX + "'";
		cardNumber = "'" + cardNumber + "'";
		
		ResultSet rs;
		Statement st;
		Connection connection =  this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery(
					"INSERT INTO customercards (cardNumber, password, creditLimit, creditGiven, dueDate, checkingAccount_id, savingAccount_id, chavePIX, owner_id) VALUES"
							+ " (" + cardNumber + "," + password + "," + creditLimit + ","
							+ creditGiven + "," + dueDate + "," + checkingAccount_id + "," + savingsAccount_id + ","
							+ chavePIX + "," + owner_id +" ); ");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;

	}

	public boolean insertClientIntheDatabase(String fullName, String cpf, String phoneNumber1, String phoneNumber2,
			String country, int salary, int card_id, int client_address_id) throws Exception {
		cpf = "'" + cpf + "'";
		country = "'" + country + "'";
		fullName = "'" + fullName + "'";
		phoneNumber1 = "'" + phoneNumber1 + "'";
		phoneNumber2 = "'" + phoneNumber2 + "'";

		ResultSet rs;
		Statement st;
		Connection connection =  this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		
		try {
			rs = st.executeQuery(
					"INSERT INTO clients (fullName, cpf, phoneNumber1, phoneNumber2, country, salary, card_id, client_address_id) VALUES"
							+ " (" + fullName + "," + cpf + "," + phoneNumber1 + "," + phoneNumber2 + "," + country + "," + salary
							+ "," + card_id + "," + client_address_id + " ); ");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;

	}

	public Client searchClientIntheDatabase(String cpf) throws Exception {

		Client wantedClient = null;
		CustomerCard wantedClientCard = null;
		BankAccount account = null;
		Agency agency = null;
		String address = null;
		
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}

		cpf = "'" + cpf + "'";
		try {

			rs = st.executeQuery("SELECT * FROM clients WHERE cpf = " + cpf + ";");
			rs.next();
			wantedClient = new Client(rs.getInt("id"), rs.getString("fullName"), cpf);
			
			
			wantedClient.setPhoneNumber1(rs.getString("phoneNumber1"));
			wantedClient.setPhoneNumber2(rs.getString("phoneNumber2"));
			wantedClient.setCountry(rs.getString("country"));
			wantedClient.setSalary(rs.getInt("salary"));
			wantedClient.setCard_id(rs.getInt("card_id"));
			wantedClient.setAddress_id(rs.getInt("client_address_id"));
			
			
			

			rs = st.executeQuery("SELECT * FROM customerCards WHERE owner_id = " + wantedClient.getId() + ";");
			rs.next();
			wantedClientCard = new CustomerCard(rs.getInt("id"), rs.getString("cardNumber"), rs.getString("password"),
					rs.getInt("creditLimit"), rs.getInt("creditGiven"),
					rs.getString("dueDate"), rs.getInt("checkingAccount_id"), rs.getInt("savingAccount_id"),
					rs.getInt("owner_id"), rs.getString("PIXkey"));
			wantedClient.setCard(wantedClientCard);

			rs = st.executeQuery("SELECT * FROM bankaccounts WHERE id = " + wantedClientCard.getCheckingAccount_id() + ";");
			rs.next();
			account = new BankAccount(rs.getInt("value"), rs.getInt("agency_id"), rs.getString("accountNumber"),
					rs.getString("type"));
			wantedClientCard.setCheckingAccount(account);

			rs = st.executeQuery("SELECT * FROM agencies WHERE id = " + account.getAgency_id() + ";");
			rs.next();
			agency = new Agency(rs.getInt("id"), rs.getInt("address_id"));
			account.setAgency(agency);

			rs = st.executeQuery("SELECT * FROM addresses WHERE id = " + agency.getAddress_id() + ";");
			rs.next();
			address = rs.getString("address");
			agency.setAddress(address);
			
			rs = st.executeQuery("SELECT * FROM bankaccounts WHERE id = " + wantedClientCard.getSavingAccount_id() + ";");
			rs.next();
			account = new BankAccount(rs.getInt("value"), rs.getInt("agency_id"), rs.getString("accountNumber"),
					rs.getString("type"));
			wantedClientCard.setSavingAccount(account);

			rs = st.executeQuery("SELECT * FROM agencies WHERE id = " + account.getAgency_id() + ";");
			rs.next();
			agency = new Agency(rs.getInt("id"), rs.getInt("address_id"));
			account.setAgency(agency);

			rs = st.executeQuery("SELECT * FROM addresses WHERE id = " + agency.getAddress_id() + ";");
			rs.next();
			address = rs.getString("address");
			agency.setAddress(address);

		} catch (SQLException e) {
			throw new Exception("ERROR in searchClientIntheDatabase function!");
		}
		
		rs.close();
		st.close();
		connection.close();

		return wantedClient;
	}

	public ArrayList<String> checkDebtsIntheDatabase(String cardNumber) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		cardNumber = "'" + cardNumber + "'";
		int cardId;
		
		BankBill bankBill = null;
		ArrayList<BankBill> bankBills = new ArrayList<BankBill>();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		
		try {
			rs = st.executeQuery("SELECT * FROM customerCards WHERE cardNumber = " + cardNumber + ";");
			rs.next();
			cardId = rs.getInt("id");
			rs = st.executeQuery("SELECT * FROM bankBills WHERE bankBill_card_id = " + cardId + ";");
			while (rs.next()) {
				bankBill = new BankBill(rs.getString("barCode"), rs.getInt("value"), rs.getString("dueDate"),
						rs.getString("creationDate"), rs.getInt("bankBill_card_id"));
				bankBills.add(bankBill);
			}

		} catch (SQLException e) {
			throw new Exception("ERROR in checkDebtsIntheDatabase function!");
		}
		
		rs.close();
		st.close();
		connection.close();
		
		
		ArrayList<String> bankBillsTexts = new ArrayList<String>();
		
		for (BankBill bankBill1 : bankBills) {
			bankBillsTexts.add(bankBill1.toString());
		}

		return bankBillsTexts;
	}

	public boolean insertBankBillIntheDatabase(String barCode, int value, String dueDate, String creationDate,
			int bankBill_card_id) throws Exception {
		barCode = "'" + barCode + "'";
		dueDate = "'" + dueDate + "'";
		creationDate = "'" + creationDate + "'";
		
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}

		try {
			rs = st.executeQuery("INSERT INTO bankbills (barCode, value, dueDate, creationDate, bankBill_card_id) VALUE ("
					+ barCode + "," + value + "," + dueDate + "," + creationDate + "," + bankBill_card_id + ");");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}

	public boolean transferValueinTheDatabase(String senderAccounNumber, String receiverPIXkEY, int value) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		senderAccounNumber = "'" + senderAccounNumber + "'";
		receiverPIXkEY = "'" + receiverPIXkEY + "'";
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("UPDATE bankaccounts SET value = value - " + value + " WHERE accountNumber ="
					+ senderAccounNumber + ";");
			
			rs = st.executeQuery("SELECT * FROM customerCards WHERE PIXkey = " + receiverPIXkEY + ";");
			
			rs.next();
			int receiverCheckingAccountId = rs.getInt("checkingAccount_id");
			
			rs = st.executeQuery("UPDATE bankaccounts SET value = value + " + value + " WHERE id ="
					+ receiverCheckingAccountId + ";");
			
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}

	public boolean depositValueDataBase(String accountNumber, int value) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("UPDATE bankaccounts SET value = value + " + value + " WHERE accountNumber ="
					+ accountNumber + ";");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}

	public boolean changePIXkeyInTheDataBase(String cardNumber, String PIXkey) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		cardNumber = "'" + cardNumber + "'";
		PIXkey = "'" + PIXkey + "'";
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery(
					"UPDATE customercards SET PIXkey = " + PIXkey + " WHERE cardNumber =" + cardNumber + ";");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}

	public boolean withdrawMoneyDB(String accountNumber, int value) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("UPDATE bankaccounts SET value = value - " + value + " WHERE accountNumber ="
					+ accountNumber + ";");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}
	public boolean deleteBankBillIntheDatabase(String barCode ) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("DELETE FROM bankBills WHERE barCode = " + barCode + ";");
		} catch (SQLException e) {
			return false;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}
	public boolean validateLogIn(String cardNumber, String password) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("SELECT * FROM customerCards WHERE cardNumber = " + cardNumber + ";");
			rs.next();
			if(rs.getString("password").equals(password)) {
				return true;
			}
		} catch (Exception e) {
			throw new Exception("ERROR IN THE validateLogIn function");
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return true;
	}
	
	public Connection getConnection() throws Exception {
		
		String url = "jdbc:mariadb://localhost:3306/bankdatabase";
		String user = "root";
		String password = "projetoBanco";
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new Exception("ERROR IN THE ClientsDataBase constructor");
		}
		return connection;
	}
	public boolean thePixKeyIsInTheDataBase(String PIXkey) throws Exception {
		Statement st;
		ResultSet rs;
		Connection connection = this.getConnection();
		
		PIXkey = "'" + PIXkey + "'";
		
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("SELECT * FROM customerCards WHERE PIXkey = " + PIXkey + ";");
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			throw new Exception("ERROR IN THE thePixKeyIsInTheDataBase function");
		}
		
		return false;
	}
	public int getAddressId(String address) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		int id = 0;
		address = "'" + address + "'";
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("SELECT * FROM addresses WHERE address = " + address + ";");
			rs.next();
			id = rs.getInt("id");
		} catch (SQLException e) {
			return -1;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return id;
	}
	public int getAccountId(int accountNumber) throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		int id = 0;
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("SELECT * FROM bankaccounts WHERE address = " + accountNumber + ";");
			rs.next();
			id = rs.getInt("id");
		} catch (SQLException e) {
			return -1;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return id;
	}
	public int getLastClientId() throws Exception {
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		int id = 0;
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("SELECT id FROM employees ORDER BY id DESC LIMIT 1;");
			rs.next();
			id = rs.getInt("id");
		} catch (SQLException e) {
			return -1;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return id;
	}
	public int getCustomerCardId(String cardNumber) throws Exception {
		cardNumber = "'" + cardNumber + "'";
		ResultSet rs;
		Statement st;
		Connection connection = this.getConnection();
		
		int id = 0;
		
		try {
			st = connection.createStatement();
		} catch (SQLException e1) {
			throw new Exception("CONNECTION ERROR IN insertAddressIntheDatabase FUNCTION !!!!!");
		}
		try {
			rs = st.executeQuery("SELECT * FROM customercards WHERE cardNumber = " + cardNumber + ";");
			rs.next();
			id = rs.getInt("id");
		} catch (SQLException e) {
			return -1;
		}
		
		rs.close();
		st.close();
		connection.close();
		
		return id;

	}

}
