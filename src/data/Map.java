package data;

import java.awt.*;
import java.util.ArrayList;

public class Map {

    public static int x = 25, y = 100;
    public static boolean mapActive = false;
    public static int kachelnX, kachelnY, kachelGroesse, kachelGroesseCurrent;

    public static ArrayList<Point> collision = new ArrayList<>();

    public static void reset() {
        x = 25;
        y = 100;
        kachelGroesseCurrent = kachelGroesse;
    }

    public static void scroll(int dir){
        if(mapActive) kachelGroesseCurrent -= dir;
    }

    public static void move(int x, int y){
        Map.x += x;
        Map.y += y;
    }

}
