package application;

import javafx.scene.image.Image;

import java.util.function.Function;

public enum Direction {

	UP(e -> e.emerald_up_rest),
	DOWN(e -> e.emerald_down_rest),
	LEFT(e -> e.emerald_left_rest),
	RIGHT(e -> e.emerald_right_rest);

	Direction(Function<Emerald, Image> image) {
		this.image = image;
	}

	final Function<Emerald, Image> image;

}
