package net.sinou.sandbox.javafx;

import java.net.URI;
import java.net.URISyntaxException;

import javafx.application.Application;
import javafx.stage.Stage;

public class SimpleApplication extends Application {

	private final static String[] fileNames = { "bark.wav", "bell_25.ogg", "bell_27.mp3" };

	@Override
	public void start(Stage primaryStage) {
		try {
			// BorderPane root = new BorderPane();
			// Scene scene = new Scene(root, 400, 400);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.setScene(scene);
			// primaryStage.show();

			JavaFxSoundReader reader = new JavaFxSoundReader();

			for (String fname : fileNames)
				reader.printInfo(fname, getUri(fname).toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private URI getUri(String fileName) throws URISyntaxException {
		String baseDir = System.getProperty("user.dir") + "/src/main/resources/sounds/";
		return new URI("file://" + baseDir + fileName);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
