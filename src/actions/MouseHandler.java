package actions;

import data.*;
import gui.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("Duplicates")
public class MouseHandler implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (SwingUtilities.isRightMouseButton(e)) {
            if (Map.mapActive) {
                MouseMotionHandler.startX = e.getX();
                MouseMotionHandler.startY = e.getY();
            }

            if (Tools.rectVisible) {
                Tools.start = null;
                Tools.end = null;
                Tools.rectVisible = false;
            }
        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (Map.mapActive) {
                switch (Tools.active) {
                    case 0:
                        if (Gui.activeButton == 7) {
                            Map.addCollision(e);
                            Map.removeCollision(e);
                        }
                        Map.setTile(e);
                        break;
                    case 1:
                        if (Mouse.insideMap) {
                            switch (Gui.activeButton) {
                                case 4:
                                    Tools.pickupTile = Map.layer1[Mouse.pos.x][Mouse.pos.y];
                                    Tools.fillArea(Mouse.pos.x, Mouse.pos.y, Tools.pickupTile, Tiles.active, Map.layer1);
                                    break;
                                case 5:
                                    Tools.pickupTile = Map.layer2[Mouse.pos.x][Mouse.pos.y];
                                    Tools.fillArea(Mouse.pos.x, Mouse.pos.y, Tools.pickupTile, Tiles.active, Map.layer2);
                                    break;
                                case 6:
                                    Tools.pickupTile = Map.layer3[Mouse.pos.x][Mouse.pos.y];
                                    Tools.fillArea(Mouse.pos.x, Mouse.pos.y, Tools.pickupTile, Tiles.active, Map.layer3);
                                    break;
                            }

                        }
                        break;
                    case 2:
                        if (!SwingUtilities.isRightMouseButton(e)) {
                            if (Mouse.insideMap) {
                                Tools.start = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                                Tools.end = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                                Tools.rectVisible = true;
                            }
                        }
                        break;
                }
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (!SwingUtilities.isRightMouseButton(e)) {
                if (Map.mapActive) {
                    if (Mouse.insideMap) {
                        if (Tools.active == 2) {
                            Tools.end = Mouse.posToCoord(Mouse.coordToPos(new Point(e.getX(), e.getY())));
                            Tools.fillRect(e);

                        }
                    }

                }
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {
                Gui.buttons[i].setBackground(C.buttonHover);
            }
        }
        for (int i = 0; i < Gui.tools.length; i++) {
            if (e.getSource().equals(Gui.tools[i])) {
                Gui.tools[i].setBackground(C.buttonHover);
            }
        }
        if (e.getSource().equals(Gui.reset)) {
            Gui.reset.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.create)) {
            Gui.create.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.oksettings)) {
            Gui.oksettings.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.oktileset)) {
            Gui.oktileset.setBackground(C.buttonHover);
        }
        if (e.getSource().equals(Gui.opentileset)) {
            Gui.opentileset.setBackground(C.buttonHover);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {
                Gui.buttons[i].setBackground(C.buttonFill);
            }
        }
        for (int i = 0; i < Gui.tools.length; i++) {
            if (e.getSource().equals(Gui.tools[i])) {
                Gui.tools[i].setBackground(C.buttonFill);
            }
        }
        if (e.getSource().equals(Gui.reset)) {
            Gui.reset.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.create)) {
            Gui.create.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.oksettings)) {
            Gui.oksettings.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.oktileset)) {
            Gui.oktileset.setBackground(C.buttonFill);
        }
        if (e.getSource().equals(Gui.opentileset)) {
            Gui.opentileset.setBackground(C.buttonFill);
        }
    }
}
