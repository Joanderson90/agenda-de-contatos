
package screenManager;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ScreenManager {

	private Object currentController;

	/**
	 * Abri um nova <b>tela</b>.
	 * 
	 * @param path  caminho referente � <b>tela</b>.
	 * @param title t�tulo da tela.
	 * @throws IOException 
	 */

	public void openNewScreen(String path, String title) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader();

		Pane p = fxmlLoader.load(getClass().getResource("/view/" + path + ".fxml").openStream());

		Object controller = fxmlLoader.getController();

		Stage stage = new Stage();

		stage.setScene(new Scene(p));
		stage.setTitle(title);
		stage.setResizable(false);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();

		this.currentController = controller;

	}

	/**
	 * Obt�m o controlador referente � �ltima <b>tela</b> aberta.
	 * 
	 * @return controlador referente � �ltima <b>tela</b> aberta.
	 */

	public Object getCurrenController() {
		return this.currentController;
	}
}
