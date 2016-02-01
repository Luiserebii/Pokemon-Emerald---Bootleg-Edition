package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.ArrayList;

public final class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pokémon Emerald - Bootleg Edition");

			Canvas canvas = new Canvas(720, 480); //Based on GBA Resolution
			root.getChildren().add(canvas);

			ArrayList<String> input = new ArrayList<>(); //I suppose gets input through ArrayList... is this necessary?

			scene.setOnKeyPressed(e -> {
				String code = e.getCode().toString();
				if (!input.contains(code)) // only add once... prevent duplicates
					input.add(code);
			});

			scene.setOnKeyReleased(e -> {
				String code = e.getCode().toString();
				input.remove(code);
			});


			GraphicsContext gc = canvas.getGraphicsContext2D(); //You could make this in GameLoop...?
			Emerald e = new Emerald(50, 50, 4, 0.43);

			GameLoop gl = new GameLoop(input, gc, e);
			gl.start();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
