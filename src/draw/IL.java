package draw;

import data.Tiles;
import gui.Gui;

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

    public static void setupTextures() {
        System.out.println(Tiles.anzahl);
        texture = new BufferedImage[Tiles.anzahl];
        for (int i = 0; i < texture.length; i++) {
            try {
                texture[i] = ImageIO.read(new FileInputStream(new File("rsc/textures/" + (i + 1) + ".png")));
                Tiles.anzahl = i;
                Gui.inputTileset.setText(""+(i+1));
            } catch (IOException e) {
                System.out.println("Tiles not found error");
            }
        }
    }

}
