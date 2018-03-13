package actions;

import data.Map;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ScrollHandler implements MouseWheelListener{

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        Map.scroll(e.getWheelRotation());

    }
}
