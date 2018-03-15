package data;

import actions.ActionHandler;
import actions.MouseHandler;
import gui.Gui;

import javax.swing.*;

public class Tiles {

    private static Gui gui = new Gui();

    public static int active = 0, anzahl = 14, scroll = 0, oldVal;

    public static JButton[] tiles;

    public static void create() {

        try {
            for (int i = 0; i < tiles.length; i++) {
                Gui.d.remove(tiles[i]);
            }
        } catch (Exception e) {

        }

        tiles = new JButton[anzahl];

        int xversch = 0, yversch = 0;
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new JButton();

            if (i > 0 && i % 5 == 0) {
                yversch += 34;
                xversch = 0;
            }

            tiles[i].setBounds(gui.getWidth() - 198 + xversch, gui.getHeight() - 198 + yversch, 32, 32);

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

        tiles[active].setBorder(Gui.borderActive);

    }

    public static void move(int oldVal) {

        for (int i = 0; i < tiles.length; i++) {
            tiles[i].setBounds(tiles[i].getBounds().x, tiles[i].getBounds().y - scroll, tiles[i].getBounds().width,
                    tiles[i].getBounds().height);
            if(tiles[i].getBounds().y < gui.getHeight() - 200){
                tiles[i].setVisible(false);
            }else{
                tiles[i].setVisible(true);
            }
        }
        scroll = 0;
        Tiles.oldVal = oldVal;
    }

}
