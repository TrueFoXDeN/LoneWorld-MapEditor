package data;

import java.awt.*;

public class Mouse {

    public static Point pos = new Point();
    public static Point coord = new Point();
    public static boolean insideMap = false;

    public static void posToCoord(int x, int y) {

        coord.x = x * Map.kachelGroesseCurrent + Map.x;
        coord.y = y * Map.kachelGroesseCurrent + Map.y;
    }

    public static void coordToPos(int x, int y) {

        int x1 = (x - Map.x) / Map.kachelGroesseCurrent;
        int y1 = (y - Map.y) / Map.kachelGroesseCurrent;

        if (x1 > Map.kachelnX) x1 = Map.kachelnX - 1;
        if (y1 > Map.kachelnY) y1 = Map.kachelnY - 1;

        pos.x = x1;
        pos.y = y1;

    }

    public static void insideMap(int x, int y) {
        insideMap = x >= Map.x && x <= Map.x + Map.kachelnX * Map.kachelGroesseCurrent + Map.kachelGroesseCurrent&&
                y >= Map.y && y <= Map.y + Map.kachelnY * Map.kachelGroesseCurrent + Map.kachelGroesseCurrent &&
                y >= 75;
    }

}
