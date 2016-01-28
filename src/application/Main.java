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
			Group root = new Group();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pokémon Emerald - Bootleg Edition");


	        Canvas canvas = new Canvas(720,480); //500
	        root.getChildren().add(canvas);

	        ArrayList<String> input = new ArrayList<String>();

	        scene.setOnKeyPressed(
	            new EventHandler<KeyEvent>()
	            {
	                public void handle(KeyEvent e)
	                {
	                    String code = e.getCode().toString();

	                    // only add once... prevent duplicates
	                    if (!input.contains(code))
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

	        GraphicsContext gc = canvas.getGraphicsContext2D();

	        Emerald e = new Emerald(50,50,4,0.43);



	        new AnimationTimer()
	        {

		        long t1 = System.nanoTime();
		        long t2;
		        long diff;
		        long interval = 200000000;
		        boolean isBattle = false;
		        Battle b = new Battle();
		        //long interval = 70000000;

	            public void handle(long currentNanoTime)
	            {

	            	//try {
	                // Clear the canvas
	                //gc.clearRect(0, 0, 720,480);

	            	

	            	System.out.println(isBattle);

	            	if(isBattle == false){

	            	TileEngine te = new TileEngine();

	            	te.generateTiles(gc);


	                if (input.contains("LEFT")){
	                	
	                	t2 = System.nanoTime();
	                	diff = t2 - t1;
	                	//System.out.println(diff);
	                	if(diff < interval){
	                		gc.drawImage(e.emerald_left_1,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval && diff < interval * 2){
	                		gc.drawImage(e.emerald_left_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 2 && diff < interval * 3){
	                		gc.drawImage(e.emerald_left_2,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 3){
	                		gc.drawImage(e.emerald_left_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 4){
	                		t1 = System.nanoTime();
	                	}
	                	e.moveLeft();
	                	e.direction = "LEFT";
		            	Random rand = new Random();
		            	int randInt = rand.nextInt(2000) + 1;
		            	if(randInt < 10){

		            		isBattle = true;

		            	}
	                }

	                if (input.contains("RIGHT")){

	                	t2 = System.nanoTime();
	                	diff = t2 - t1;
	                	//System.out.println(diff);
	                	if(diff < interval){
	                		gc.drawImage(e.emerald_right_1,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval && diff < interval * 2){
	                		gc.drawImage(e.emerald_right_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 2 && diff < interval * 3){
	                		gc.drawImage(e.emerald_right_2,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 3){
	                		gc.drawImage(e.emerald_right_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 4){
	                		t1 = System.nanoTime();
	                	}
	                	e.moveRight();
	                	e.direction = "RIGHT";
	                }
	                if (input.contains("UP")){

	                	t2 = System.nanoTime();
	                	diff = t2 - t1;
	                	//System.out.println(diff);
	                	if(diff < interval){
	                		gc.drawImage(e.emerald_up_1,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval && diff < interval * 2){
	                		gc.drawImage(e.emerald_up_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 2 && diff < interval * 3){
	                		gc.drawImage(e.emerald_up_2,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 3){
	                		gc.drawImage(e.emerald_up_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 4){
	                		t1 = System.nanoTime();
	                	}
	                	e.moveUp();
	                	e.direction = "UP";
	                }
	                if (input.contains("DOWN")){

	                	t2 = System.nanoTime();
	                	diff = t2 - t1;
	                	//System.out.println(diff);
	                	if(diff < interval){
	                		gc.drawImage(e.emerald_down_1,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval && diff < interval * 2){
	                		gc.drawImage(e.emerald_down_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 2 && diff < interval * 3){
	                		gc.drawImage(e.emerald_down_2,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 3){
	                		gc.drawImage(e.emerald_down_rest,e.posX,e.posY,e.width,e.height);
	                	}
	                	if(diff > interval * 4){
	                		t1 = System.nanoTime();
	                	}
	                	e.moveDown();
	                	e.direction = "DOWN";
	                }


	                if (input.size() == 0 && e.direction == "LEFT"){
	                    gc.drawImage(e.emerald_left_rest,e.posX,e.posY,e.width,e.height);
	                }
	                if (input.size() == 0 && e.direction == "RIGHT"){
	                    gc.drawImage(e.emerald_right_rest,e.posX,e.posY,e.width,e.height);
	                }
	                if (input.size() == 0 && e.direction == "UP"){
	                    gc.drawImage(e.emerald_up_rest,e.posX,e.posY,e.width,e.height);
	                }
	                if (input.size() == 0 && e.direction == "DOWN"){
	                    gc.drawImage(e.emerald_down_rest,e.posX,e.posY,e.width,e.height);
	                }

	            	}//if statement

	            	if(isBattle == true){

	            		if(b.isBattleStart == false){
	            			b.startTimer();
	            			b.setIsBattleStart(true);
	            		}
	            		//System.out.println(isBattle);
	            		b.updateBattle(gc);
	            		isBattle = b.checkBattleOver();
	            		
	            	}
	            }
	        }.start();


			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
