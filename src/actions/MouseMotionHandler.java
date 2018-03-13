package actions;

import data.Map;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionHandler implements MouseMotionListener {

    public static int startX, startY;

    @Override
    public void mouseDragged(MouseEvent e) {
        if (Map.mapActive) {
            if (SwingUtilities.isRightMouseButton(e)) {
                Map.move(e.getX() - startX, e.getY() - startY);
                startX = e.getX();
                startY = e.getY();
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
