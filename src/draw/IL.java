package draw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IL {

   public static BufferedImage collision;

    public IL(){
        try {
            collision = ImageIO.read(new FileInputStream(new File("rsc/collision.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
