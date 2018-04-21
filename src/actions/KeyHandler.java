package actions;

import gui.Gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_TAB) {
            if (Gui.inputNew[0].hasFocus()) {
                Gui.inputNew[1].requestFocus();
                e.consume();
            } else if (Gui.inputNew[1].hasFocus()) {
                Gui.inputNew[2].requestFocus();
                e.consume();
            } else if (Gui.inputNew[2].hasFocus()) {
                Gui.inputNew[0].requestFocus();
                e.consume();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Gui.jfNew.isVisible()) {
                Gui.create.doClick();
            } else if (Gui.jfSettings.isVisible()) {
                Gui.oksettings.doClick();
            } else if (Gui.jfTileset.isVisible()) {
                Gui.oktileset.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
