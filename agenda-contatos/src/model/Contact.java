package model;

public class Contact {

	private String name;
	private String andress;
	private String phoneNumber;
	private String email;

	public Contact() {
	};

	public Contact(String name, String andress, String phoneNumber, String email) {

		this.name = name;
		this.andress = andress;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAndress() {
		return andress;
	}

	public void setAndress(String andress) {
		this.andress = andress;
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

	@Override
	public String toString() {

		return this.getName();
	}

}
