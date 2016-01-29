package application;

import java.awt.image.BufferedImage;
import java.net.URISyntaxException;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimatedGif extends Animation {

    public AnimatedGif(String filename, double durationMs) {

        GifDecoder d = new GifDecoder();
        d.read(filename);

        Image[] sequence = new Image[ d.getFrameCount()];
        for(int i=0; i < d.getFrameCount(); i++) {

            WritableImage wimg = null;
            BufferedImage bimg = d.getFrame(i);
            sequence[i] = SwingFXUtils.toFXImage( bimg, wimg);

        }

        super.init(sequence, durationMs);
    }

}

