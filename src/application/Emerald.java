package application;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Emerald {

	Image emerald_down_rest; //Do we really need all these defs? Maybe for later project, figure out easier way
	Image emerald_down_1;
	Image emerald_down_2;
	Image emerald_left_rest;
	Image emerald_left_1;
	Image emerald_left_2;
	Image emerald_right_rest;
	Image emerald_right_1;
	Image emerald_right_2;
	Image emerald_up_rest;
	Image emerald_up_1;
	Image emerald_up_2;

	int xSpeed;
	int ySpeed;
	int posX, posY;
	int width, height;

	String direction;

	public Emerald(){

		emerald_down_rest = new Image("file:images/emerald_down_rest.png");
		emerald_down_1 = new Image("file:images/emerald_down_1.png");
		emerald_down_2 = new Image("file:images/emerald_down_2.png");
		emerald_left_rest = new Image("file:images/emerald_left_rest.png");
		emerald_left_1 = new Image("file:images/emerald_left_1.png");
		emerald_left_2 = new Image("file:images/emerald_left_2.png");
		emerald_right_rest = new Image("file:images/emerald_right_rest.png");
		emerald_right_1 = new Image("file:images/emerald_right_1.png");
		emerald_right_2 = new Image("file:images/emerald_right_2.png");
		emerald_up_rest = new Image("file:images/emerald_up_rest.png");
		emerald_up_1 = new Image("file:images/emerald_up_1.png");
		emerald_up_2 = new Image("file:images/emerald_up_2.png");

		xSpeed = 5;
		ySpeed = 5;

		posX = 50;
		posY = 50;

		direction = "DOWN";

		width = 100;
		height = 150;
	}

	public Emerald(int inPosX, int inPosY, int speed, double whMult){

		emerald_down_rest = new Image("file:images/emerald_down_rest.png");
		emerald_down_1 = new Image("file:images/emerald_down_1.png");
		emerald_down_2 = new Image("file:images/emerald_down_2.png");
		emerald_left_rest = new Image("file:images/emerald_left_rest.png");
		emerald_left_1 = new Image("file:images/emerald_left_1.png");
		emerald_left_2 = new Image("file:images/emerald_left_2.png");
		emerald_right_rest = new Image("file:images/emerald_right_rest.png");
		emerald_right_1 = new Image("file:images/emerald_right_1.png");
		emerald_right_2 = new Image("file:images/emerald_right_2.png");
		emerald_up_rest = new Image("file:images/emerald_up_rest.png");
		emerald_up_1 = new Image("file:images/emerald_up_1.png");
		emerald_up_2 = new Image("file:images/emerald_up_2.png");

		xSpeed = speed;
		ySpeed = speed;

		posX = inPosX;
		posY = inPosY;

		direction = "DOWN";

		width = (int) (100 * whMult);
		height = (int) (150 * whMult);
	}


	public void moveLeft() {
		posX = posX - xSpeed;
	}

	public void moveRight() {
		posX = posX + xSpeed;
	}

	public void moveUp() {
		posY = posY - ySpeed;
	}

	public void moveDown() {
		posY = posY + ySpeed;
	}

	public void moveLogic(GraphicsContext gc, ArrayList<String> input, long t1, long t2, long diff, long interval) {



	}
}
