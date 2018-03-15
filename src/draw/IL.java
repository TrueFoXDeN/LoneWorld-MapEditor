package draw;

import data.Tiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IL {

    public static BufferedImage collision;
    public static BufferedImage[] texture;

    public IL() {
        try {
            collision = ImageIO.read(new FileInputStream(new File("rsc/collision.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setupTextures(){

        texture = new BufferedImage[Tiles.anzahl];
        for (int i = 0; i < texture.length; i++) {
            try {
                texture[i] = ImageIO.read(new FileInputStream(new File("rsc/textures/" + (i+1) + ".png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
