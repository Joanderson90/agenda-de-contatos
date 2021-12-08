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

public class FormularioRegisterScreenController implements Initializable {

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtAddress;

	@FXML
	private TextField txtPhoneNumber;

	@FXML
	private TextField txtEmail;

	@FXML
	private Button btnSalvarContact;

	@FXML
	private Button btnVoltar;

	private MessageAlert msgAlert = new MessageAlert();

	public void salvarContact() {

		String name = txtName.getText();
		String address = txtAddress.getText();
		String phoneNumber = txtPhoneNumber.getText();
		String email = txtEmail.getText();

		if (name != "") {

			Contact contactNew = new Contact(name, address, phoneNumber, email);

			ContactDAO.create(contactNew);

			this.msgAlert.showMessage("Contato Salvo com Sucesso!", AlertType.INFORMATION);

			ScreenManager.closeScreen(btnVoltar);

		}

		else {

			this.msgAlert.showMessage("Nome obrigat�rio!", AlertType.WARNING);
		}

	}

	public void closeScreen() {

		ScreenManager.closeScreen(btnVoltar);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		loadImages();
	}

	public void loadImages() {

		btnSalvarContact.setGraphic(new ImageView("/icons/CadastroSalvar_32x32.png"));
		btnVoltar.setGraphic(new ImageView("/icons/CadastroVoltar.png"));

	}

	public void addButtonsListener(EventHandler<ActionEvent> listener) {

		btnSalvarContact.setOnAction(listener);
		btnVoltar.setOnAction(listener);
	}

	public Button getBtnSalvarContact() {
		return btnSalvarContact;
	}

	public Button getBtnVoltar() {
		return btnVoltar;
	}

}
