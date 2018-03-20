package data;

import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Tools {

    public static int active = 0;
    public static Point start = new Point();
    public static Point end = new Point();
    public static boolean rectVisible = false;

    public static int pickupTile = 0;

    public static void setActive(int i) {
        active = i;
        for (JButton tool : Gui.tools) {
            tool.setBorder(Gui.border);
        }
        Gui.tools[active].setBorder(Gui.borderActive);
    }

    public static void fillRect(MouseEvent e) {

        try {
            for (int x = Math.min(Mouse.coordToPos(start).x, Mouse.coordToPos(end).x);
                 x <= Math.max(Mouse.coordToPos(end).x, Mouse.coordToPos(start).x); x++) {

                for (int y = Math.min(Mouse.coordToPos(start).y, Mouse.coordToPos(end).y);
                     y <= Math.max(Mouse.coordToPos(end).y, Mouse.coordToPos(start).y); y++) {

                    if (!e.isShiftDown()) {
                        switch (Gui.activeButton) {
                            case 4:
                                Map.layer1[x][y] = Tiles.active;
                                break;
                            case 5:
                                Map.layer2[x][y] = Tiles.active;
                                break;
                            case 6:
                                Map.layer2[x][y] = Tiles.active;
                                break;
                            case 7:
                                if (!Map.collision.contains(new Point(x, y))) {
                                    Map.collision.add(new Point(x, y));
                                }
                                break;


                        }
                    } else {
                        switch (Gui.activeButton) {
                            case 4:
                                Map.layer1[x][y] = 0;
                                break;
                            case 5:
                                Map.layer2[x][y] = 0;
                                break;
                            case 6:
                                Map.layer2[x][y] = 0;
                                break;
                            case 7:
                                if (Map.collision.contains(new Point(x, y))) {
                                    Map.collision.remove(new Point(x, y));
                                }
                                break;
                        }

                    }

                }
            }
        } catch (Exception e1) {
        }

        start = null;
        end = null;

        rectVisible = false;

    }

    public static void fillArea(int x, int y, int original, int fill, int[][] arr) {
        if(original != fill){
            int maxX = arr.length - 1;
            int maxY = arr[0].length - 1;
            int[][] stack = new int[(maxX + 1) * (maxY + 1)][2];
            int index = 0;

            stack[0][0] = x;
            stack[0][1] = y;
            arr[x][y] = fill;

            while (index >= 0) {
                x = stack[index][0];
                y = stack[index][1];
                index--;

                if ((x > 0) && (arr[x - 1][y] == original)) {
                    arr[x - 1][y] = fill;
                    index++;
                    stack[index][0] = x - 1;
                    stack[index][1] = y;
                }

                if ((x < maxX) && (arr[x + 1][y] == original)) {
                    arr[x + 1][y] = fill;
                    index++;
                    stack[index][0] = x + 1;
                    stack[index][1] = y;
                }

                if ((y > 0) && (arr[x][y - 1] == original)) {
                    arr[x][y - 1] = fill;
                    index++;
                    stack[index][0] = x;
                    stack[index][1] = y - 1;
                }

                if ((y < maxY) && (arr[x][y + 1] == original)) {
                    arr[x][y + 1] = fill;
                    index++;
                    stack[index][0] = x;
                    stack[index][1] = y + 1;
                }
            }
        }

    }

}
