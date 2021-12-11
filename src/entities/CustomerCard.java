package entities;

public class CustomerCard {
	private int id;
	private String cardNumber;
	private String password;
	private int creditLimit;
	private int creditGiven;
	private String dueDate;
	private int checkingAccount_id;
	private int savingAccount_id;
	private int cardOwner_id;
	private BankAccount checkingAccount;
	private BankAccount savingAccount;
	private String chavePIX;
	
	public CustomerCard(int id ,String cardNumber, String password, int creditLimit, int creditGiven,
			String dueDate, int checkingAccount_id, int savingAccount_id, int cardOwner_id, String chavePIX) {
		this.id = id;
		this.cardNumber = cardNumber;
		this.password = password;
		this.creditLimit = creditLimit;
		this.creditGiven = creditGiven;
		this.dueDate = dueDate;
		this.checkingAccount_id = checkingAccount_id;
		this.savingAccount_id = savingAccount_id;
		this.cardOwner_id = cardOwner_id;
		this.chavePIX = chavePIX;
	}
	
	public CustomerCard() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}

	public int getCreditGiven() {
		return creditGiven;
	}

	public void setCreditGiven(int creditGiven) {
		this.creditGiven = creditGiven;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getCheckingAccount_id() {
		return checkingAccount_id;
	}

	public void setCheckingAccount_id(int checkingAccount_id) {
		this.checkingAccount_id = checkingAccount_id;
	}

	public int getSavingAccount_id() {
		return savingAccount_id;
	}

	public void setSavingAccount_id(int savingAccount_id) {
		this.savingAccount_id = savingAccount_id;
	}

	public int getCardOwner_id() {
		return cardOwner_id;
	}

	public void setCardOwner_id(int cardOwner_id) {
		this.cardOwner_id = cardOwner_id;
	}

	public BankAccount getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(BankAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public BankAccount getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(BankAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getChavePIX() {
		return chavePIX;
	}

	public void setChavePIX(String chavePIX) {
		this.chavePIX = chavePIX;
	}

	
}
