package actions;

import data.C;
import gui.Gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HoverHandler implements MouseListener{


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(int i= 0; i< Gui.buttons.length; i++){
            if(e.getSource().equals(Gui.buttons[i])){
                Gui.buttons[i].setBackground(C.buttonHover);
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(int i= 0; i< Gui.buttons.length; i++){
            if(e.getSource().equals(Gui.buttons[i])){
                Gui.buttons[i].setBackground(C.buttonFill);
            }
        }
    }
}
