package data;

import gui.Gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Map {

    public static int x = 25, y = 100;
    public static boolean mapActive = false, gridVisible = true;
    public static int kachelnX, kachelnY, kachelGroesse, kachelGroesseCurrent;

    public static ArrayList<Point> collision = new ArrayList<>();
    public static int[][] layer1, layer2, layer3;

    public static void setup() {
        layer1 = new int[kachelnX][kachelnY];
        layer2 = new int[kachelnX][kachelnY];
        layer3 = new int[kachelnX][kachelnY];

        for (int i = 0; i < kachelnX; i++) {
            for (int j = 0; j < kachelnY; j++) {
                layer1[i][j] = 0;
                layer2[i][j] = 0;
                layer3[i][j] = 0;
            }
        }
    }

    public static void reset() {
        x = 25;
        y = 100;
        kachelGroesseCurrent = kachelGroesse;
    }

    public static void scroll(int dir) {
        if (mapActive) kachelGroesseCurrent -= dir;
    }

    public static void move(int x, int y) {
        Map.x += x;
        Map.y += y;
    }

    public static void addCollision(MouseEvent e) {
        if (Mouse.insideMap) {
            if (Gui.activeButton == 7) {
                if (e.getY() >= 75) {
                    if (!collision.contains(new Point(Mouse.pos.x, Mouse.pos.y))) {
                        collision.add(new Point(Mouse.pos.x, Mouse.pos.y));
                    }

                }
            }
        }
    }

    public static void removeCollision(MouseEvent e) {
        if (Mouse.insideMap) {
            if (Gui.activeButton == 7) {
                if (e.getY() >= 75) {
                    if (e.isShiftDown()) {
                        if (collision.contains(new Point(Mouse.pos.x, Mouse.pos.y))) {
                            collision.remove(new Point(Mouse.pos.x, Mouse.pos.y));
                        }

                    }
                }
            }
        }
    }
}
