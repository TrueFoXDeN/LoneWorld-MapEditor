package actions;

import data.Map;
import data.Mouse;
import gui.Gui;

import javax.swing.*;
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
            }

        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (Map.mapActive) {
                if(Gui.activeButton == 7){
                    Map.addCollision(e);
                    Map.removeCollision(e);
                }
                else if(Gui.activeButton == 4){
                    Map.addTile(e,0);
                    Map.removeTile(e, 0);
                }
                else if(Gui.activeButton == 5){
                    Map.addTile(e,1);
                    Map.removeTile(e, 1);
                }
                else if(Gui.activeButton == 6){
                    Map.addTile(e,2);
                    Map.removeTile(e, 2);
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
