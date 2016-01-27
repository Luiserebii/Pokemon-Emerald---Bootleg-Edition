package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TileEngine {

	int[][] tileMap = {

		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
		{0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 7, 7, 7, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
	};

	Image regTile = new Image("file:images/reg_tile_scaled.png");
	Image grassTile = new Image("file:images/grass_tile.png");
	Image flowerTile = new Image("file:images/flower_tile.png");

	int tileLength = 48;
	int tileWidth = 48;

	public void generateTiles(GraphicsContext gc){

		int mapLength = tileMap.length;
		int mapWidth = tileMap[0].length;

		for(int i = 0; i < mapLength; i++){
			for(int j = 0; j < mapWidth; j++){

				System.out.println(j*tileWidth + "    " + i*tileLength);

				if(tileMap[i][j] == 0){

					gc.drawImage(regTile, j*tileWidth, i*tileLength);
				}
				if(tileMap[i][j] == 1){

					gc.drawImage(grassTile, j*tileWidth, i*tileLength);
				}
				if(tileMap[i][j] == 7){

					gc.drawImage(flowerTile, j*tileWidth, i*tileLength);
				}

			}
		}




	}







	public void readTileMap(){





	}


}
