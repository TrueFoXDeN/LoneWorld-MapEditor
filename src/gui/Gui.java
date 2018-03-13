package gui;

import actions.ScrollHandler;
import draw.Draw;

import javax.swing.*;

public class Gui {

    JFrame jfMain;
    JButton[] buttons = new JButton[9];

    Draw d;

    private final int WIDTH = 1280, HEIGHT = 720;


    public void create() {
        jfMain = new JFrame("Lone World - Mapeditor");
        jfMain.setSize(WIDTH, HEIGHT);
        jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMain.setLocationRelativeTo(null);
        jfMain.addMouseWheelListener(new ScrollHandler());
        jfMain.setResizable(true);
        jfMain.setLayout(null);

        int temp = 0;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBounds((i * 75 + 5 + temp) + WIDTH / 4 - 15, 7, 60, 60);
            buttons[i].setVisible(true);
            jfMain.add(buttons[i]);
        }

        d = new Draw();
        d.setSize(getWidth(),getHeight());
        d.setVisible(true);
        d.requestFocus();
        d.addMouseWheelListener(new ScrollHandler());
        jfMain.add(d);

        jfMain.setVisible(true);
    }

    public int getWidth() {
        return WIDTH -14;
    }

    public int getHeight() {
        return HEIGHT -36;
    }
}
