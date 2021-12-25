package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Contact;

public class ContactDAO {

	public static boolean create(Contact newContact) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection
					.prepareStatement("INSERT INTO contacts (name, address, phoneNumber, email) VALUES (?,?,?,?)");

			stmt.setString(1, newContact.getName());
			stmt.setString(2, newContact.getAddress());
			stmt.setString(3, newContact.getPhoneNumber());
			stmt.setString(4, newContact.getEmail());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

	public static List<Contact> getContacts() {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Contact> contactsRegistered = new ArrayList<>();

		try {

			stmt = connection.prepareStatement("SELECT * FROM  contacts");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Contact contact = new Contact();

				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setPhoneNumber(rs.getString("phoneNumber"));

				contactsRegistered.add(contact);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt, rs);
		}

		return contactsRegistered;

	}

	public static boolean update(Contact newContact) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement(
					"UPDATE contacts SET name = ?, address = ?, phoneNumber = ?, email = ? WHERE id = ?");

			stmt.setString(1, newContact.getName());
			stmt.setString(2, newContact.getAddress());
			stmt.setString(3, newContact.getPhoneNumber());
			stmt.setString(4, newContact.getEmail());
			stmt.setInt(5, newContact.getId());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

	public static boolean remove(Contact contactTarget) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement("DELETE FROM contacts  WHERE id = ?");

			stmt.setInt(1, contactTarget.getId());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

	public static List<Contact> findByPhoneNumber(String phoneNumber) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Contact> contactsRegistered = new ArrayList<>();

		try {

			stmt = connection.prepareStatement("SELECT * FROM  contacts WHERE phoneNumber LIKE ?");

			stmt.setString(1, "%" + phoneNumber + "%");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Contact contact = new Contact();

				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail(rs.getString("email"));
				contact.setAddress(rs.getString("address"));
				contact.setPhoneNumber(rs.getString("phoneNumber"));
				contactsRegistered.add(contact);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt, rs);
		}

		return contactsRegistered;
	}
}
