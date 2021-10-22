/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Contact;
import model.MessageAlert;

/**
 *
 * @author User
 */

public class FormularioRegisterScreenController implements Initializable {

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtAndress;

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
		String andress = txtAndress.getText();
		String phoneNumber = txtPhoneNumber.getText();
		String email = txtEmail.getText();

		if (name != "") {

			Contact contactNew = new Contact(name, andress, phoneNumber, email);

			ContactScreenController.setContactNew(contactNew);

			this.msgAlert.getMessageContatoSalvo();

			cleanFormulario();

		}

		else {

			this.msgAlert.getMessageNomeEmBranco();
		}

	}

	public void closeScreen() {

		Stage stage = (Stage) btnVoltar.getScene().getWindow();

		stage.close();
	}

	public void cleanFormulario() {

		txtName.setText("");
		txtAndress.setText("");
		txtPhoneNumber.setText("");
		txtEmail.setText("");

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		 loadImages();
	}
	
	public void loadImages(){
		
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
