package actions;

import data.C;
import data.Map;
import gui.Gui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

        }

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (Map.mapActive) {
                Map.addCollision(e);
                Map.removeCollision(e);
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {
                Gui.buttons[i].setBackground(C.buttonHover);
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
