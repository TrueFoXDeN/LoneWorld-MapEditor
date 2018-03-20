package data;

import actions.ActionHandler;
import actions.MouseHandler;
import gui.Gui;

import javax.swing.*;

public class Tiles {

    private static Gui gui = new Gui();

    public static int active = 1, anzahl = 6, scroll = 0, oldVal;

    public static JButton[] tiles;

    public static void create() {

        try {
            for (JButton t : tiles) {
                Gui.d.remove(t);
            }
        } catch (Exception e) {

        }

        tiles = new JButton[anzahl + 1];

        int xversch = 0, yversch = 0;

        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new JButton();

            if (i > 0 && i % 5 == 0) {
                yversch += 34;
                xversch = 0;
            }

            tiles[i].setBounds(gui.getWidth() - 198 + xversch, gui.getHeight() - 204 + yversch, 32, 32);

            xversch += 34;

            tiles[i].setBackground(C.buttonFill);
            tiles[i].setIcon(new ImageIcon("rsc/textures/" + (i + 1) + ".png"));
            tiles[i].setBorderPainted(true);
            tiles[i].addActionListener(new ActionHandler());
            tiles[i].addMouseListener(new MouseHandler());
            tiles[i].setBorder(Gui.border);
            tiles[i].setFocusPainted(false);
            tiles[i].setVisible(true);
            Gui.d.add(tiles[i]);


        }

        tiles[active - 1].setBorder(Gui.borderActive);

    }

    public static void calcScroll() {


        int hspace = 34;
        for (int i = 0; i < tiles.length; i++) {
            if (i % 6 == 0) {
                hspace += 34;
            }
        }

        if (hspace < 238) {
            Gui.scroll.setVisibleAmount(100);
            Gui.scroll.setMaximum(100);
        }

        if (hspace >= 238) {
            Gui.scroll.setVisibleAmount(20);
            Gui.scroll.setMaximum(100);
        }

        if (hspace >= 272) {
            Gui.scroll.setVisibleAmount(20);
            Gui.scroll.setMaximum(200);
        }

        if(hspace > 306){
            Gui.scroll.setVisibleAmount(20);
            Gui.scroll.setMaximum(600);
        }

        Gui.scroll.setValue(0);
    }

    public static void move(int oldVal) {

        for (JButton t : tiles) {
            t.setBounds(t.getBounds().x, t.getBounds().y - scroll, t.getBounds().width, t.getBounds().height);

            if (t.getBounds().y < gui.getHeight() - 208) {
                t.setVisible(false);
            } else {
                t.setVisible(true);
            }
        }
        scroll = 0;
        Tiles.oldVal = oldVal;
    }

}
