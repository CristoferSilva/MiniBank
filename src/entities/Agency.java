package entities;

public class Agency {
	private int agencyNumber;
	private int address_id;
	private String address;
	
	public Agency(int agencyNumber, int address_id) {
		this.agencyNumber = agencyNumber;
		this.address_id = address_id;
	}


	public int getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(int agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
