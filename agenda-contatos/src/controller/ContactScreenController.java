/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Contact;
import model.ContactRecords;
import model.MessageAlert;
import screenManager.ScreenManager;

/**
 *
 * @author User
 */

public class ContactScreenController implements Initializable, EventHandler<ActionEvent> {

	@FXML
	private ListView<Contact> lvContacts = new ListView<>();

	private static ObservableList<Contact> obsContacts;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtAndress;

	@FXML
	private TextField txtPhoneNumber;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtSearch;

	@FXML
	private Button btnSearch;

	@FXML
	private Button btnAddContact;

	@FXML
	private Button btnEditarContact;

	@FXML
	private Button btnRemoveContact;

	@FXML
	private Button btnUpdateContact;

	private static Contact contactSelected = new Contact();

	private static ContactRecords contactRecords = new ContactRecords();

	private ScreenManager screenManager = new ScreenManager();

	private MessageAlert msgAlert = new MessageAlert();

	private FormularioRegisterScreenController formularioRegisterController;
	private EditContactScreenController formularioEditContactController;

	@FXML
	void openFormularioRegisterContact(ActionEvent event) throws IOException {

		screenManager.openNewScreen("FormularioRegisterContactScreen", "Cadastro Contato");

		setReferenciaFormularioRegisterController();
	}

	private void setReferenciaFormularioRegisterController() {

		Object currentController = screenManager.getCurrenController();

		formularioRegisterController = (FormularioRegisterScreenController) currentController;

		formularioRegisterController.addButtonsListener(this);

	}

	@FXML
	void openFormularioEditContact(ActionEvent event) throws IOException {

		contactSelected = lvContacts.getSelectionModel().getSelectedItem();

		if (contactSelected != null) {

			screenManager.openNewScreen("EditContactScreen", "Edição Contato");

			setReferenciaFormularioEditContactController();
		}

		else {

			this.msgAlert.showMessage("Por favor selecione um contato primeiro!", AlertType.ERROR);
		}
	}

	private void setReferenciaFormularioEditContactController() {

		Object currentController = screenManager.getCurrenController();

		formularioEditContactController = (EditContactScreenController) currentController;

		formularioEditContactController.addButtonsListener(this);

	}

	@FXML
	void removeContact(ActionEvent event) {

		Contact contactSelected = lvContacts.getSelectionModel().getSelectedItem();

		if (contactSelected != null) {

			contactRecords.getContactRecords().remove(contactSelected);

			this.msgAlert.showMessage("Contato excluido com Sucesso!", AlertType.INFORMATION);

			cleanInfoContact();

			loadContacts();
		}

		else {

			this.msgAlert.showMessage("Por favor selecione um contato primeiro!", AlertType.ERROR);
		}

	}

	@FXML
	void searchContact(ActionEvent event) {

		String keyWord = txtSearch.getText();

		if (keyWord != "") {

			List<Contact> contactsFound = contactRecords.searchContact(keyWord);

			if (contactsFound.size() != 0) {

				setContactsInView(contactsFound);
			}

			else {

				this.msgAlert.showMessage("Contato não encontrado!", AlertType.INFORMATION);
			}
		}

		else {

			this.msgAlert.showMessage("Preencha com um valor primeiro!", AlertType.ERROR);
		}

	}

	private void setContactsInView(List<Contact> contacts) {

		obsContacts.clear();

		obsContacts.addAll(contacts);

		lvContacts.setItems(obsContacts);

	}

	@FXML
	void showInfoContact() {

		Contact contactSelected = lvContacts.getSelectionModel().getSelectedItem();

		if (contactSelected != null) {

			txtName.setText(contactSelected.getName());
			txtAndress.setText(contactSelected.getAndress());
			txtPhoneNumber.setText(contactSelected.getPhoneNumber());
			txtEmail.setText(contactSelected.getEmail());
		}

	}

	public void cleanInfoContact() {

		txtName.setText("");
		txtAndress.setText("");
		txtPhoneNumber.setText("");
		txtEmail.setText("");

	}

	public void loadContacts() {

		obsContacts = FXCollections.observableArrayList(contactRecords.getContactRecords());

		lvContacts.setItems(obsContacts);

	}

	public static void setContactNew(Contact contactNew) {

		contactRecords.setContact(contactNew);

	}

	public static Contact getContactSelected() {

		return contactSelected;
	}

	@FXML
	void setSpaceSearch() {

		txtSearch.setText("");

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		txtSearch.setText("Nome, Email ou Telefone");

		formularioRegisterController = new FormularioRegisterScreenController();
		formularioEditContactController = new EditContactScreenController();

		loadImages();
		loadContacts();

	}

	public void loadImages() {

		btnSearch.setGraphic(new ImageView("/icons/CadastroBuscar.png"));
		btnEditarContact.setGraphic(new ImageView("/icons/CadastroEditar.png"));
		btnRemoveContact.setGraphic(new ImageView("/icons/CadastroExcluir_32x32.png"));
		btnAddContact.setGraphic(new ImageView("/icons/CadastroNovo_32x32.png"));

	}

	@Override
	public void handle(ActionEvent arg0) {

		if (arg0.getSource() == formularioRegisterController.getBtnSalvarContact()) {

			formularioRegisterController.salvarContact();

			loadContacts();

		} else if (arg0.getSource() == formularioRegisterController.getBtnVoltar()) {

			formularioRegisterController.closeScreen();

		}

		else if (arg0.getSource() == formularioEditContactController.getBtnSalvarEditContact()) {

			formularioEditContactController.editarContact();

			loadContacts();

			showInfoContact();

		}

		else {

			formularioEditContactController.closeScreen();
		}
	}

}
