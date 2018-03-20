package actions;

import data.Map;
import data.Mouse;
import data.Tools;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("Duplicates")
public class MouseMotionHandler implements MouseMotionListener {

    public static int startX, startY;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (Map.mapActive) {

            if (SwingUtilities.isRightMouseButton(e)) {
                if (startY >= 75) {
                    Map.move(e.getX() - startX, e.getY() - startY);
                    startX = e.getX();
                    startY = e.getY();
                }
            }

            Mouse.insideMap(e.getX(), e.getY());
            if (Mouse.insideMap) {
                Mouse.coordToPos(e.getX(), e.getY());
                Mouse.posToCoord(Mouse.pos.x, Mouse.pos.y);

                if (SwingUtilities.isLeftMouseButton(e)) {
                    if(!SwingUtilities.isRightMouseButton(e)){
                        if (Tools.active == 2) {
                            Tools.end = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                        }
                    }

                }

            }

        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (Map.mapActive) {
                if (Tools.active == 0) {
                    if (Gui.activeButton == 7) {
                        Map.addCollision(e);
                        Map.removeCollision(e);
                    }
                    Map.setTile(e);

                }


            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        if (Map.mapActive) {

            Mouse.insideMap(e.getX(), e.getY());
            if (Mouse.insideMap) {
                Mouse.coordToPos(e.getX(), e.getY());
                Mouse.posToCoord(Mouse.pos.x, Mouse.pos.y);
            }

        }

    }
}
