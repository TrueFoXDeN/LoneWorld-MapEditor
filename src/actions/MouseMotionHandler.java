package actions;

import data.Map;
import data.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

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
            }


        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (Map.mapActive) {
                Map.addCollision(e);
                Map.removeCollision(e);
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
