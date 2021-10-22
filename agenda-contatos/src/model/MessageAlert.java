package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageAlert {

	private Alert alert;

	public void getMessageNomeEmBranco() {

		alert = new Alert(AlertType.WARNING);
		alert.setContentText("Nome obrigatório!");

		alert.show();

	}

	public void getMessageContatoSalvo() {

		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Contato Salvo com Sucesso!");

		alert.show();
	}

	public void getMessageContatoEditado() {

		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Contato Editado com Sucesso!");

		alert.show();
	}

	public void getMessageContatoNaoSelecionada() {

		alert = new Alert(AlertType.WARNING);
		alert.setContentText("Por favor selecione um contato primeiro!");

		alert.show();
	}

	public void getMessageContatoExcluida() {

		alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText("Contato excluído com Sucesso!");

		alert.show();
	}

	public void getMessageContatoNaoEncontrado() {

		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Contato não encontrado!");

		alert.show();

	}

	public void getMessageCampoObrigatorio() {

		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Preencha com um valor primeiro!");

		alert.show();
	}

	public void getMessageSobreSistema() {

		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Agenda de contatos 1.0");

		alert.show();
	}
}
