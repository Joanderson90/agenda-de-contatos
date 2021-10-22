package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactRecords {

	private List<Contact> contactRecords;

	public ContactRecords() {

		this.contactRecords = new ArrayList<>();
	}

	public List<Contact> searchContact(String keyWord) {

		List<Contact> contactsFound = new ArrayList<>();

		Iterator<Contact> it = this.contactRecords.iterator();

		Contact contactRecord;

		boolean contactRecordContainsKeyWord;

		while (it.hasNext()) {

			contactRecord = it.next();

			contactRecordContainsKeyWord = contactContainsKeyWord(contactRecord, keyWord);

			if (contactRecordContainsKeyWord) contactsFound.add(contactRecord);

		}

		return contactsFound;

	}

	private boolean contactContainsKeyWord(Contact contact, String keyWord) {

		boolean contactContainsKeyWord = false;

		String nameContact = contact.getName();
		String emailContact = contact.getEmail();
		String phoneNumberContact = contact.getPhoneNumber();

		if (nameContact.equals(keyWord) || emailContact.equals(keyWord) || phoneNumberContact.equals(keyWord)) {

			contactContainsKeyWord = true;
		}

		return contactContainsKeyWord;
	}

	public List<Contact> getContactRecords() {
		return this.contactRecords;
	}

	public void setContact(Contact contact) {

		this.contactRecords.add(contact);
	}

	public void setContactRecords(List<Contact> contactRecords) {
		this.contactRecords = contactRecords;
	}

}
