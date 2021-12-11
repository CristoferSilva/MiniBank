package entities;

public class BankAccount {
	private int value;
	private int agency_id;
	private String accountNumber;
	private String type;
	private Agency agency;
	
	public BankAccount(int value, int agency_id, String accountNumber, String type) {
		this.value = value;
		this.agency_id = agency_id;
		this.accountNumber = accountNumber;
		this.type = type;
	}
	public BankAccount() {
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getAgency_id() {
		return agency_id;
	}

	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
}
