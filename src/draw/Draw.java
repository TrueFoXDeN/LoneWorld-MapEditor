package draw;

import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel{

    Gui gui = new Gui();

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.decode("0xccd6de"));
        g.fillRect(0,0,gui.getWidth(), 75);


        repaint();
    }


}
