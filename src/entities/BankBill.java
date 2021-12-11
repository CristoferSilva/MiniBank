package entities;

public class BankBill {
	private String barCode;
	private int value;
	private String dueDate;
	private String creationDate;
	private int account_id;
	
	public BankBill(String barCode, int value, String dueDate, String creationDate, int account_id) {
		this.barCode = barCode;
		this.value = value;
		this.dueDate = dueDate;
		this.creationDate = creationDate;
		this.account_id = account_id;
	}
	

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		String bankBillString = "BarCode => " + this.barCode + 
				", Value => " + this.value + ", Creation Date => " + this.creationDate
				+ ", Due Date => " + this.dueDate + "\n";
		return bankBillString;
	}
}
