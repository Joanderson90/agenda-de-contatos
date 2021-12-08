/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.ContactDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Contact;
import model.MessageAlert;
import screenManager.ScreenManager;

/**
 *
 * @author User
 */

public class EditContactScreenController implements Initializable {

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtAddress;

	@FXML
	private TextField txtPhoneNumber;

	@FXML
	private TextField txtEmail;

	@FXML
	private Button btnSalvarEditContact;

	@FXML
	private Button btnVoltar;

	private Contact contactSelected = ContactScreenController.getContactSelected();

	private MessageAlert msgAlert = new MessageAlert();

	public void editarContact() {

		String name = txtName.getText();
		String address = txtAddress.getText();
		String phoneNumber = txtPhoneNumber.getText();
		String email = txtEmail.getText();

		if (name != "") {

			contactSelected.setName(name);
			contactSelected.setAddress(address);
			contactSelected.setPhoneNumber(phoneNumber);
			contactSelected.setEmail(email);

			ContactDAO.update(contactSelected);

			this.msgAlert.showMessage("Contato Editado com Sucesso!", AlertType.INFORMATION);

			ScreenManager.closeScreen(btnVoltar);

		}

		else {

			this.msgAlert.showMessage("Nome obrigatório!", AlertType.ERROR);
		}

	}

	public void closeScreen() {

		ScreenManager.closeScreen(btnVoltar);

	}

	public void loadInfoContactSelected() {

		txtName.setText(contactSelected.getName());
		txtAddress.setText(contactSelected.getAddress());
		txtEmail.setText(contactSelected.getEmail());
		txtPhoneNumber.setText(contactSelected.getPhoneNumber());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		loadInfoContactSelected();
		loadImages();

	}

	public void loadImages() {

		btnSalvarEditContact.setGraphic(new ImageView("/icons/CadastroSalvar_32x32.png"));
		btnVoltar.setGraphic(new ImageView("/icons/CadastroVoltar.png"));

	}

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnSalvarEditContact.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	public Button getBtnSalvarEditContact() {
		return btnSalvarEditContact;
	}

	public Button getBtnVoltar() {
		return btnVoltar;
	}

}
