package data;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Map {

    public static int x = 25, y = 100;
    public static boolean mapActive = false, gridVisible = true, layerHighlight = true;
    public static int kachelnX, kachelnY, kachelGroesse, kachelGroesseCurrent;

    public static ArrayList<Point> collision = new ArrayList<>();
    public static int[][] layer1, layer2, layer3;

    public static void setup() {
        layer1 = new int[kachelnX + 1][kachelnY + 1];
        layer2 = new int[kachelnX + 1][kachelnY + 1];
        layer3 = new int[kachelnX + 1][kachelnY + 1];

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
        if (mapActive){
            if(kachelGroesseCurrent >= 2){
                kachelGroesseCurrent -= dir;
            }else{
                kachelGroesseCurrent = 2;
            }
        }
    }

    public static void move(int x, int y) {
        Map.x += x;
        Map.y += y;
    }

    public static void addCollision(MouseEvent e) {
        if (Mouse.insideMap) {
            if (e.getY() >= 75) {
                if (!collision.contains(new Point(Mouse.pos.x, Mouse.pos.y))) {
                    collision.add(new Point(Mouse.pos.x, Mouse.pos.y));
                }
            }
        }
    }

    public static void removeCollision(MouseEvent e) {
        if (Mouse.insideMap) {
            if (e.getY() >= 75) {
                if (e.isShiftDown()) {
                    if (collision.contains(new Point(Mouse.pos.x, Mouse.pos.y))) {
                        collision.remove(new Point(Mouse.pos.x, Mouse.pos.y));
                    }

                }
            }
        }
    }

    public static void addTile(MouseEvent e, int layer) {
        if (Mouse.insideMap) {
            if (e.getY() >= 75) {
                try {
                    if (layer == 0) {
                        layer1[Mouse.pos.x][Mouse.pos.y] = Tiles.active;
                    }
                    if (layer == 1) {
                        layer2[Mouse.pos.x][Mouse.pos.y] = Tiles.active;
                    }
                    if (layer == 2) {
                        layer3[Mouse.pos.x][Mouse.pos.y] = Tiles.active;
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();

                }
            }
        }
    }

    public static void removeTile(MouseEvent e, int layer) {
        if (Mouse.insideMap) {
            if (e.getY() >= 75) {
                if (e.isShiftDown()) {
                    try {
                        if (layer == 0) {
                            layer1[Mouse.pos.x][Mouse.pos.y] = 0;
                        }
                        if (layer == 1) {
                            layer2[Mouse.pos.x][Mouse.pos.y] = 0;
                        }
                        if (layer == 2) {
                            layer3[Mouse.pos.x][Mouse.pos.y] = 0;
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();

                    }
                }

            }
        }
    }


}
