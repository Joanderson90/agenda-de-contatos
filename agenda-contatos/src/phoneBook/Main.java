
package phoneBook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/MainScreen.fxml"));
		Parent root = loader.load();

		Image applicationIcon = new Image(getClass().getResourceAsStream("/icons/iconeAplicacao.png"));

		stage.getIcons().add(applicationIcon);

		Scene scene = new Scene(root);

		scene.getStylesheets().add("/Styles/Styles.css");

		stage.setTitle("MainScreen");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
