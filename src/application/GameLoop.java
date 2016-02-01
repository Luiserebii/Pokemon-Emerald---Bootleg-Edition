package application;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class GameLoop extends AnimationTimer {

	private long t1 = System.nanoTime(); //Gets total time elapsed in nanoseconds, so early value
	private long t2; //to be initialized as later value to compare (t2-t1)
	private long diff;
	private long interval = 200000000;
	private boolean isBattle = false;
	private GraphicsContext gc;
	private Emerald e;
	private ArrayList<String> input;
	private Battle b = new Battle();

	//long interval = 70000000;

	GameLoop(ArrayList<String> inInput, GraphicsContext inGC, Emerald inE) {
		input = inInput;
		gc = inGC;
		e = inE;
	}

	public void handle(long currentNanoTime) { //code of start, handle called by .start()
		//System.out.println(isBattle);

		//System.out.println(Arrays.toString(input.toArray()));

		if (!isBattle) { //If there is no battle, make tiles and check for input

			TileEngine te = new TileEngine();
			te.generateTiles(gc);

			if (input.contains("LEFT")) {
				t2 = System.nanoTime();
				diff = t2 - t1; //check time elapsed, reset t1 if gets too late
				//System.out.println(diff);
				if (diff < interval) {
					gc.drawImage(e.emerald_left_1, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval && diff < interval * 2) {
					gc.drawImage(e.emerald_left_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 2 && diff < interval * 3) {
					gc.drawImage(e.emerald_left_2, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 3) {
					gc.drawImage(e.emerald_left_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 4) {
					t1 = System.nanoTime();
				}
				e.moveLeft();
				e.direction = "LEFT";

				int randInt = ThreadLocalRandom.current().nextInt(2000) + 1;
				if (randInt < 10) {
					isBattle = true;
				}
			}

			if (input.contains("RIGHT")) {
				t2 = System.nanoTime();
				diff = t2 - t1;
				//System.out.println(diff);
				if (diff < interval) {
					gc.drawImage(e.emerald_right_1, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval && diff < interval * 2) {
					gc.drawImage(e.emerald_right_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 2 && diff < interval * 3) {
					gc.drawImage(e.emerald_right_2, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 3) {
					gc.drawImage(e.emerald_right_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 4) {
					t1 = System.nanoTime();
				}
				e.moveRight();
				e.direction = "RIGHT";

				int randInt = ThreadLocalRandom.current().nextInt(2000) + 1;
				if (randInt < 10) {
					isBattle = true;
				}
			}
			if (input.contains("UP")) {

				t2 = System.nanoTime();
				diff = t2 - t1;
				//System.out.println(diff);
				if (diff < interval) {
					gc.drawImage(e.emerald_up_1, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval && diff < interval * 2) {
					gc.drawImage(e.emerald_up_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 2 && diff < interval * 3) {
					gc.drawImage(e.emerald_up_2, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 3) {
					gc.drawImage(e.emerald_up_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 4) {
					t1 = System.nanoTime();
				}
				e.moveUp();
				e.direction = "UP";

				int randInt = ThreadLocalRandom.current().nextInt(2000) + 1;
				if (randInt < 10) {
					isBattle = true;
				}
			}
			if (input.contains("DOWN")) {

				t2 = System.nanoTime();
				diff = t2 - t1;
				//System.out.println(diff);
				if (diff < interval) {
					gc.drawImage(e.emerald_down_1, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval && diff < interval * 2) {
					gc.drawImage(e.emerald_down_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 2 && diff < interval * 3) {
					gc.drawImage(e.emerald_down_2, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 3) {
					gc.drawImage(e.emerald_down_rest, e.posX, e.posY, e.width, e.height);
				}
				if (diff > interval * 4) {
					t1 = System.nanoTime();
				}
				e.moveDown();
				e.direction = "DOWN";

				int randInt = ThreadLocalRandom.current().nextInt(2000) + 1;
				if (randInt < 10) {
					isBattle = true;
				}
			}


			if (input.size() == 0 && e.direction == "LEFT") {
				gc.drawImage(e.emerald_left_rest, e.posX, e.posY, e.width, e.height);
			}
			if (input.size() == 0 && e.direction == "RIGHT") {
				gc.drawImage(e.emerald_right_rest, e.posX, e.posY, e.width, e.height);
			}
			if (input.size() == 0 && e.direction == "UP") {
				gc.drawImage(e.emerald_up_rest, e.posX, e.posY, e.width, e.height);
			}
			if (input.size() == 0 && e.direction == "DOWN") {
				gc.drawImage(e.emerald_down_rest, e.posX, e.posY, e.width, e.height);
			}

		}

		if (isBattle) {

			if (!b.isBattleStart) { // Do we really need isBattle and isBattleStart???
				b.startTimer();
				b.setIsBattleStart(true);
			}

			if (input.contains("Z")) {
				b.setIsReadyForTG2(true);
			}

			//System.out.println(isBattle);
			b.updateBattle(gc);
			isBattle = b.checkBattleOver();
		}
	}

}
