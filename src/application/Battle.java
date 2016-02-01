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
	Image emeraldBattle2 = new Image("file:images/emerald_battle_2.png");
	Image emeraldBattle3 = new Image("file:images/emerald_battle_3.png");
	Image emeraldBattle4 = new Image("file:images/emerald_battle_4.png");

	Image pokemon = new Image("file:images/261_scaled.gif");
	Image pokemonBack;
	int num;

	Image HPBox1 = new Image("file:images/hp_box_1.png"); //goes on the right - main
	Image HPBox2 = new Image("file:images/hp_box_2.png"); //
	boolean isBattleStart;
	boolean isTrainerGrass1;
	boolean isTrainerGrass2;
	boolean isReadyForTG2;
	boolean isReadyHPBox;
	boolean isTrainerGrass3;
	boolean isTrainerGrass4;
	boolean isEncounterAct;
	boolean isReadyHPBox2;
	long t1;
	long t2;
	int trainerXPos;
	int trainerSpeed;
	int HPBoxXPos;
	int HPBoxSpeed;
	int HPBoxXPos2;
	int HPBoxSpeed2;

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
		randomPokemonBack();
		isTrainerGrass1 = true;
		isTrainerGrass2 = false;
		isReadyForTG2 = false;
		isReadyHPBox = false;
		isTrainerGrass3 = false;
		isTrainerGrass4 = false;
		isEncounterAct = false;
		isReadyHPBox = false;
		isReadyHPBox2 = false;
		trainerSpeed = 6; //6
		HPBoxXPos2 = -300;
		HPBoxSpeed2 = 14;
		HPBoxXPos = 720;
		HPBoxSpeed = 14;
	}

	public void updateBattle(GraphicsContext gc){

		t2 = System.nanoTime();

		//System.out.println("VALUE DIFF OF BATTLE" + (t2-t1));

		if((t2 - t1) > 15000000000L){
			 isBattleStart = false;
		}

//		if(g1x > 12){
//
//			g1x = g1x - 3;
//		}
//
//		if(g2x < 336){
//
//			g2x = g2x + 3;
//		}
		//System.out.println(g1x + "     " + g2x);
		//System.out.println(isReadyForTG2);
		gc.drawImage(grassBattleBackground,0,0);
		gc.drawImage(grassBattleGrass1,g1x,303);
		gc.drawImage(grassBattleGrass2,g2x,144);

		if(isTrainerGrass1){

			g1x = g1x - 3; //moving grassBattleGrass
			g2x = g2x + 3;

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight());//87 //g2x+90.5,104 //decided just to do simple alg, too complicated to be precise

			gc.drawImage(emeraldBattle1,g1x + 186,180);

		}

		if(isTrainerGrass1 && (g2x > 333 && g1x < 15)){ //if TrainerGrass1 and grassBattle is in final position

			isTrainerGrass1 = false;
			isTrainerGrass2 = true;

		}

		if(isTrainerGrass2 && !isReadyHPBox2 && !isReadyForTG2){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2; //draws Pokemon
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight()); //draws Pokemon
			gc.drawImage(emeraldBattle1,g1x + 186,180); //draws static Trainer
			trainerXPos = 138;

			HPBoxXPos2 = HPBoxXPos2 + HPBoxSpeed2;
			gc.drawImage(HPBox2,HPBoxXPos2,48);//39
		}

		if(isTrainerGrass2 && !isReadyHPBox2 && (HPBoxXPos2) >= 39){

			isReadyHPBox2 = true;

		}

		if(isTrainerGrass2 && isReadyHPBox2 && !isReadyForTG2){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2; //draws Pokemon
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight()); //draws Pokemon
			gc.drawImage(emeraldBattle1,g1x + 186,180); //draws static Trainer

			gc.drawImage(HPBox2,HPBoxXPos2,48);
		}

		if(isTrainerGrass2 && isReadyForTG2 && isReadyHPBox2){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight());
			trainerXPos = trainerXPos - trainerSpeed; //move Trainer
			//trainerSpeed++;
			gc.drawImage(emeraldBattle2,trainerXPos,183); //draw Trainer moving

			gc.drawImage(HPBox2,HPBoxXPos2,48);
		}

		if(isTrainerGrass2 && (trainerXPos) <= 0){

			isTrainerGrass2 = false;
			isReadyForTG2 = false;
			isTrainerGrass3 = true;
		}

		if(isTrainerGrass3){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight());
			trainerXPos = trainerXPos - trainerSpeed;
			//trainerSpeed++;
			gc.drawImage(emeraldBattle3,trainerXPos,186); //drawTrainer3 moving

			gc.drawImage(HPBox2,HPBoxXPos2,48);
		}

		if(isTrainerGrass3 && (trainerXPos) <= -108){

			isTrainerGrass3 = false;
			isTrainerGrass4 = true;

		}

		if(isTrainerGrass4){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight()); //drawPokemon
			trainerXPos = trainerXPos - trainerSpeed;
			//trainerSpeed++;
			gc.drawImage(emeraldBattle4,trainerXPos,189); //drawTrainer4 moving

			gc.drawImage(HPBox2,HPBoxXPos2,48);

		}

		if(isTrainerGrass4 && (trainerXPos) <= -300){

			isTrainerGrass4 = false;
			isEncounterAct = true;

		}

		if(isEncounterAct && !isReadyHPBox){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight()); //drawPokemon

			int pokemonOffset2 = (int) (grassBattleGrass1.getWidth() - pokemonBack.getWidth())/2;
			gc.drawImage(pokemonBack,g1x+pokemonOffset2+30,350-pokemonBack.getHeight()); //drawPokemon

			HPBoxXPos = HPBoxXPos - HPBoxSpeed;
			System.out.println(HPBoxXPos);
			gc.drawImage(HPBox2,HPBoxXPos2,48);
			gc.drawImage(HPBox1,HPBoxXPos,222);

		}

		if(isEncounterAct && !isReadyHPBox && HPBoxXPos <= 378){

			isReadyHPBox = true;
		}

		if(isEncounterAct && isReadyHPBox){

			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight()); //drawPokemon

			int pokemonOffset2 = (int) (grassBattleGrass1.getWidth() - pokemonBack.getWidth())/2;
			gc.drawImage(pokemonBack,g1x+pokemonOffset2+30,350-pokemonBack.getHeight()); //drawPokemon

			gc.drawImage(HPBox2,HPBoxXPos2,48);
			gc.drawImage(HPBox1,HPBoxXPos,222);

		}





//		if(g2x < 336 || g1x > 12){
//
//			isTrainerGrass1 = true;
//			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
//			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight());//87 //g2x+90.5,104 //decided just to do simple alg, too complicated to be precise
//
//			gc.drawImage(emeraldBattle1,g1x + 186,180);
//		}
//
//
//
//
//		if(g2x > 333 && g1x < 15){
//
//			int pokemonOffset = (int) (grassBattleGrass2.getWidth() - pokemon.getWidth())/2;
//			gc.drawImage(pokemon,g2x+pokemonOffset,215-pokemon.getHeight());
//			i++;
//			gc.drawImage(emeraldBattle2,138-i,183); //g1x + 186 - i
//		}


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

	public void setIsReadyForTG2(boolean inIsReadyTG2){

		isReadyForTG2 = inIsReadyTG2;

	}

	public void moveTrainer(){

		trainerSpeed = 2;

	}


	public void randomPokemon(){

		num = new Random().nextInt(386) + 1;
		pokemon = new Image("file:images/pokemon_sprites/" + num + ".gif_.gif");

	}

	public void randomPokemonBack(){

		num = new Random().nextInt(386) + 1;
		pokemonBack = new Image("file:images/pokemon_back_sprites/" + num + ".png");

	}





}




