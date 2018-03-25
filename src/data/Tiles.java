package data;

import actions.ActionHandler;
import actions.MouseHandler;
import gui.Gui;

import javax.swing.*;
import java.awt.*;

public class Tiles {


    public static int active = 1, anzahl = 6;

    public static JButton[] tiles;

    public static void create() {

        try {
            for (JButton t : tiles) {
                Gui.scrollPanel.remove(t);
                Gui.scrollPanel.revalidate();
            }
        } catch (Exception e) {

        }

        tiles = new JButton[anzahl + 1];

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new JButton();
            tiles[i].setPreferredSize(new Dimension(32, 32));
            tiles[i].setBackground(C.buttonFill);
            tiles[i].setIcon(new ImageIcon("rsc/textures/" + (i + 1) + ".png"));
            tiles[i].setBorderPainted(true);
            tiles[i].addActionListener(new ActionHandler());
            tiles[i].addMouseListener(new MouseHandler());
            tiles[i].setBorder(Gui.border);
            tiles[i].setFocusPainted(false);
            tiles[i].setVisible(true);

            Gui.scrollPanel.add(tiles[i]);
            Gui.scrollPanel.revalidate();
            Gui.scrollPane.getViewport().add(Gui.scrollPanel);
            Gui.scrollPane.revalidate();

        }

        tiles[active - 1].setBorder(Gui.borderActive);

    }


}
