package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group(); //Making Group to add Canvas to
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pokémon Emerald - Bootleg Edition"); //all stuff you know ^^^


	        Canvas canvas = new Canvas(720,480); //Based on GBA Resolution
	        root.getChildren().add(canvas);

	        ArrayList<String> input = new ArrayList<String>(); //I suppose gets input through ArrayList... is this necessary?

	        scene.setOnKeyPressed( //May or may not want to look into how this works, maybe move into other class
	            new EventHandler<KeyEvent>() //Looks like two anonymous classes...? which would otherwise be extended
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();	                    
	                    if (!input.contains(code))// only add once... prevent duplicates
	                        input.add(code);
	                }
	            });

	        scene.setOnKeyReleased(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();
	                    input.remove(code);
	                }
	            });

	        
	        GraphicsContext gc = canvas.getGraphicsContext2D(); //You could make this in GameLoop...?
	        Emerald e = new Emerald(50,50,4,0.43);

	        GameLoop gl = new GameLoop(input,gc,e);
	        gl.start();



			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
