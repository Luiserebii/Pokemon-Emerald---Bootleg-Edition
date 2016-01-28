package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Battle { //Really messy class, needs to be developed


	Image grassBattle = new Image("file:images/grass_battle.png");
	Image battleBox = new Image("file:images/battle_box.png");

	Image HPBox1 = new Image("file:images/hp_box_1.png"); //goes on the right - main
	Image HPBox2 = new Image("file:images/hp_box_2.png"); //
	boolean isBattleStart;
	long t1;
	long t2;


	public Battle(){


	}

	public void startTimer(){

		t1 = System.nanoTime();
		isBattleStart = true;
	}

	public void updateBattle(GraphicsContext gc){

		t2 = System.nanoTime();

		System.out.println("VALUE DIFF OF BATTLE" + (t2-t1));

		if((t2 - t1) > 4000000000L){
			 isBattleStart = false;
		}

		gc.drawImage(grassBattle,0,0);
		gc.drawImage(battleBox,0,336);
		gc.drawImage(HPBox2,39,48);
		gc.drawImage(HPBox1,378,222);

	}

	public boolean checkBattleOver(){

		return isBattleStart;
	}



	public void setIsBattleStart(boolean input){

		isBattleStart = input;

	}












}




