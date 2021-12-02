package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageAlert {

	private Alert alert;

	public void showMessage(String message, AlertType alertTypeMessage) {

		alert = new Alert(alertTypeMessage);
		alert.setContentText(message);

		alert.show();

	}

}
