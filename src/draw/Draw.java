package draw;

import data.C;
import data.Map;
import data.Mouse;
import data.Tools;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    Gui gui = new Gui();

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);


        if (Map.mapActive) {
            g.setColor(C.layerInactive);
            //DrawTiles
            for (int x = 0; x < Map.layer1.length; x++) {
                for (int y = 0; y < Map.layer1[x].length; y++) {
                    if (Map.layer1[x][y] > 0) {
                        g.drawImage(IL.texture[Map.layer1[x][y] - 1], Mouse.posXToCood(x), Mouse.posYToCood(y),
                                Map.kachelGroesseCurrent, Map.kachelGroesseCurrent, null);

                        if (Map.layerHighlight) {
                            if (Gui.activeButton != 4) {
                                g.fillRect(Mouse.posXToCood(x), Mouse.posYToCood(y),
                                        Map.kachelGroesseCurrent, Map.kachelGroesseCurrent);
                            }
                        }
                    }
                }
            }

            for (int x = 0; x < Map.layer2.length; x++) {
                for (int y = 0; y < Map.layer2[x].length; y++) {
                    if (Map.layer2[x][y] > 0) {
                        g.drawImage(IL.texture[Map.layer2[x][y] - 1], Mouse.posXToCood(x), Mouse.posYToCood(y),
                                Map.kachelGroesseCurrent, Map.kachelGroesseCurrent, null);

                        if (Map.layerHighlight) {
                            if (Gui.activeButton != 5) {
                                g.fillRect(Mouse.posXToCood(x), Mouse.posYToCood(y),
                                        Map.kachelGroesseCurrent, Map.kachelGroesseCurrent);
                            }
                        }
                    }
                }
            }

            for (int x = 0; x < Map.layer3.length; x++) {
                for (int y = 0; y < Map.layer3[x].length; y++) {
                    if (Map.layer3[x][y] > 0) {
                        g.drawImage(IL.texture[Map.layer3[x][y] - 1], Mouse.posXToCood(x), Mouse.posYToCood(y),
                                Map.kachelGroesseCurrent, Map.kachelGroesseCurrent, null);

                        if (Map.layerHighlight) {
                            if (Gui.activeButton != 6) {
                                g.fillRect(Mouse.posXToCood(x), Mouse.posYToCood(y),
                                        Map.kachelGroesseCurrent, Map.kachelGroesseCurrent);
                            }
                        }
                    }
                }
            }

            //DrawCollision
            if (Gui.activeButton == 7) {
                for (Point p : Map.collision) {
                    g.drawImage(IL.collision, Mouse.posXToCood(p.x), Mouse.posYToCood(p.y),
                            Map.kachelGroesseCurrent, Map.kachelGroesseCurrent, null);

                }
            }

            //DrawHover
            if (Mouse.insideMap) {
                g.setColor(C.mapHover);
                g.fillRect(Mouse.coord.x, Mouse.coord.y, Map.kachelGroesseCurrent, Map.kachelGroesseCurrent);
            }

            //DrawGrid
            g.setColor(Color.GRAY);
            if (Map.gridVisible) {
                for (int x = 0; x <= Map.kachelnX; x++) {
                    for (int y = 0; y <= Map.kachelnY; y++) {
                        g.drawRect(x * Map.kachelGroesseCurrent + Map.x,
                                y * Map.kachelGroesseCurrent + Map.y, Map.kachelGroesseCurrent, Map.kachelGroesseCurrent);
                    }
                }
            } else {
                g.drawRect(Map.x, Map.y, Map.kachelGroesseCurrent * Map.kachelnX + Map.kachelGroesseCurrent,
                        Map.kachelGroesseCurrent * Map.kachelnY + Map.kachelGroesseCurrent);

            }

            //DrawRect
            if (Tools.rectVisible) {
                g.setColor(Color.RED);
                int x = Math.min(Tools.start.x + Map.kachelGroesseCurrent / 2, Tools.end.x + Map.kachelGroesseCurrent / 2);
                int y = Math.min(Tools.start.y + Map.kachelGroesseCurrent / 2, Tools.end.y + Map.kachelGroesseCurrent / 2);

                int width = Math.abs(Tools.start.x - Tools.end.x);
                int height = Math.abs(Tools.start.y - Tools.end.y);

                g.drawRect(x, y, width, height);

            }
        }

        //DrawTileScreen
        g.setColor(C.background);
        g.fillRect(gui.getWidth() - 200, gui.getHeight() - 208, 200, 208);

        g.setColor(C.border);
        g.drawRect(gui.getWidth() - 200, gui.getHeight() - 208, 200, 208);

        g.setColor(C.background);
        g.fillRect(0, 0, gui.getWidth(), 75);

        g.setColor(C.border);
        g.drawLine(0, 75, gui.getWidth(), 75);

        repaint();
    }


}
