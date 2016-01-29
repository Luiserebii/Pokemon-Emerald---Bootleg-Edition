package application;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Battle { //Really messy class, needs to be developed


	Image grassBattle = new Image("file:images/grass_battle.png");
	Image grassBattleBackground = new Image("file:images/grass_battle_background.png");
	Image grassBattleGrass1 = new Image("file:images/grass_battle_grass_1.png");
	Image grassBattleGrass2 = new Image("file:images/grass_battle_grass_2.png");

	Image battleBox = new Image("file:images/battle_box.png");

	Image emeraldBattle1 = new Image("file:images/emerald_battle_1.png");

	Image pokemon = new Image("file:images/261_scaled.gif");
	int num;

	Image HPBox1 = new Image("file:images/hp_box_1.png"); //goes on the right - main
	Image HPBox2 = new Image("file:images/hp_box_2.png"); //
	boolean isBattleStart;
	long t1;
	long t2;

	int g1x = 720;
	int g2x = -396;


	public Battle(){


	}

	public void startTimer(){

		t1 = System.nanoTime();
		isBattleStart = true;
		g1x = 732;//720,
		g2x = -384; //384. + 21 if @ 3
		randomPokemon();
	}

	public void updateBattle(GraphicsContext gc){

		t2 = System.nanoTime();

		//System.out.println("VALUE DIFF OF BATTLE" + (t2-t1));

		if((t2 - t1) > 10000000000L){
			 isBattleStart = false;
		}

		if(g1x > 12){

			g1x = g1x - 3;
		}

		if(g2x < 336){

			g2x = g2x + 3;
		}
		System.out.println(g1x + "     " + g2x);
		gc.drawImage(grassBattleBackground,0,0);
		gc.drawImage(grassBattleGrass1,g1x,303);
		gc.drawImage(grassBattleGrass2,g2x,144);
		int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
		gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight());//87 //g2x+90.5,104 //decided just to do simple alg, too complicated to be precise
		gc.drawImage(emeraldBattle1,g1x + 186,180);


		gc.drawImage(battleBox,0,336);
		//gc.drawImage(HPBox2,39,48);
		//gc.drawImage(HPBox1,378,222);

	}



	public boolean checkBattleOver(){

		return isBattleStart;
	}



	public void setIsBattleStart(boolean input){

		isBattleStart = input;

	}




	public void randomPokemon(){

		num = new Random().nextInt(386) + 1;
		pokemon = new Image("file:images/pokemon_sprites/" + num + ".gif_.gif");

	}







}




