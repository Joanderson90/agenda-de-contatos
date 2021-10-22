/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import model.MessageAlert;
import screenManager.ScreenManager;

/**
 *
 * @author User
 */

public class MainScreenController implements Initializable {

	@FXML
	private Menu menuArquivo;

	@FXML
	private MenuItem menuItemContatos;

	@FXML
	private Menu menuSobre;

	@FXML
	private MenuItem menuItemSair;

	@FXML
	private MenuItem menuItemSistema;

	private ScreenManager screenManager = new ScreenManager();

	@FXML
	void openContatos(ActionEvent event) throws IOException {

		screenManager.openNewScreen("ContactScreen", "Contatos");
	}

	@FXML
	void showSobreSistema(ActionEvent event) {

		MessageAlert alertMessage = new MessageAlert();

		alertMessage.getMessageSobreSistema();
	}

	@FXML
	void sair(ActionEvent event) {

		System.exit(0);

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		menuItemContatos.setGraphic(new ImageView("/icons/iconeMenuContato.png"));
		menuItemSistema.setGraphic(new ImageView("/icons/iconeMenuSobre.png"));
		menuItemSair.setGraphic(new ImageView("/icons/iconeMenuSair.png"));

	}

}
