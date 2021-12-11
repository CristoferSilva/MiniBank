package entities;

public class Client {
	private int id;
	private String fullName;
	private String cpf;
	private String phoneNumber1;
	private String phoneNumber2;
	private String country;
	private int salary;
	private int card_id;
	private int address_id;
	private CustomerCard card;
	
	public Client(int id,String fullName, String cpf ) {
		this.id = id;
		this.cpf = cpf;
		this.fullName = fullName;
	}
	public Client() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomerCard getCard() {
		return card;
	}
	public void setCard(CustomerCard card) {
		this.card = card;
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNuber2) {
		this.phoneNumber2 = phoneNuber2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	@Override
	public String toString() {
		
		String checkingAccountBalance = "Checking Account Value => R$" + this.getCard().getCheckingAccount().getValue();
		String savingsAccountBalance =  "Saving Account Value => R$" + this.getCard().getSavingAccount().getValue();
		String cardNumber = "Card Number => " + this.getCard().getCardNumber();
		String PixKey = "PIX key => " + this.getCard().getChavePIX();
		
		return checkingAccountBalance + "\n" + savingsAccountBalance + "\n" + cardNumber + "\n" + cardNumber;
	}
}
