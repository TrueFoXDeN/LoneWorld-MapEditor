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

        if (x1 > Map.kachelnX) x1 = Map.kachelnX;
        if (y1 > Map.kachelnY) y1 = Map.kachelnY;

        pos.x = x1;
        pos.y = y1;

    }

    public static Point posToCoord(Point p) {

        return new Point(p.x * Map.kachelGroesseCurrent + Map.x, p.y * Map.kachelGroesseCurrent + Map.y );

    }

    public static Point coordToPos(Point p) {

        int x1 = (p.x - Map.x) / Map.kachelGroesseCurrent;
        int y1 = (p.y - Map.y) / Map.kachelGroesseCurrent;

        if (x1 > Map.kachelnX) x1 = Map.kachelnX;
        if (y1 > Map.kachelnY) y1 = Map.kachelnY;

        return new Point(x1,y1);

    }



    public static int posXToCood(int x){
        return x * Map.kachelGroesseCurrent + Map.x;
    }

    public static int posYToCood(int y){
        return y * Map.kachelGroesseCurrent + Map.y;
    }

    public static void insideMap(int x, int y) {
        insideMap = x >= Map.x && x <= Map.x + Map.kachelnX * Map.kachelGroesseCurrent + Map.kachelGroesseCurrent&&
                y >= Map.y && y <= Map.y + Map.kachelnY * Map.kachelGroesseCurrent + Map.kachelGroesseCurrent &&
                y >= 75;
    }

}
