package gui;

import actions.ActionHandler;
import actions.HoverHandler;
import actions.MouseHandler;
import actions.ScrollHandler;
import data.C;
import draw.Draw;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Gui {

    JFrame jfMain;
    public static JButton[] buttons = new JButton[9];
    public static Border border = BorderFactory.createLineBorder(Color.BLACK);
    public static Border borderActive = BorderFactory.createLineBorder(Color.RED);

    public static int activeButton = 5;

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


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBounds((i * 75) + WIDTH / 4 - 15, 7, 60, 60);
            buttons[i].setBackground(C.buttonFill);
            buttons[i].setIcon(new ImageIcon("rsc/icons/" + (i + 1) + ".png"));
            buttons[i].setBorder(border);
            buttons[i].setBorderPainted(true);
            buttons[i].addActionListener(new ActionHandler());
            buttons[i].addMouseListener(new HoverHandler());
            buttons[i].setFocusPainted(false);
            buttons[i].setVisible(true);
            jfMain.add(buttons[i]);
        }

        d = new Draw();
        d.setSize(getWidth(), getHeight());
        d.setVisible(true);
        d.requestFocus();
        d.addMouseWheelListener(new ScrollHandler());
        jfMain.add(d);

        jfMain.setVisible(true);
    }

    public void setButtonActive(int index) {

        if (index >= 4 && index <= 7){

            for(JButton b : buttons){
                b.setBorder(border);
            }

            if (Gui.activeButton != index) {
                Gui.buttons[index].setBorder(Gui.borderActive);
                Gui.activeButton = index;
            } else {
                Gui.buttons[index].setBorder(Gui.border);
            }
        }

    }

    public int getWidth() {
        return WIDTH - 14;
    }

    public int getHeight() {
        return HEIGHT - 36;
    }
}
