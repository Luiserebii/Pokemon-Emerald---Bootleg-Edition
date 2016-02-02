package application;

import javafx.scene.image.Image;

import java.util.function.Consumer;
import java.util.function.Function;

public enum Direction {

	UP(e -> e.emerald_up_rest, e -> e.emerald_up_1, e -> e.emerald_up_2, Emerald::moveUp),
	DOWN(e -> e.emerald_down_rest, e -> e.emerald_down_1, e -> e.emerald_down_2, Emerald::moveDown),
	LEFT(e -> e.emerald_left_rest, e -> e.emerald_left_1, e -> e.emerald_left_2, Emerald::moveLeft),
	RIGHT(e -> e.emerald_right_rest, e -> e.emerald_right_1, e -> e.emerald_right_2, Emerald::moveRight);

	final Function<Emerald, Image> image;
	final Function<Emerald, Image> image1;
	final Function<Emerald, Image> image2;
	final Consumer<Emerald> move;

	Direction(Function<Emerald, Image> image, Function<Emerald, Image> image1,
	          Function<Emerald, Image> image2, Consumer<Emerald> move) {
		this.image = image;
		this.image1 = image1;
		this.image2 = image2;
		this.move = move;
	}

	static final Direction[] cachedValues = values();

}
