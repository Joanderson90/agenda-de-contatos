package model;

public class Contact {
	
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	private String email;

	public Contact() {
	};

	public Contact(String name, String andress, String phoneNumber, String email) {

		this.name = name;
		this.address = andress;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String andress) {
		this.address = andress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {

		return this.getName();
	}

}
