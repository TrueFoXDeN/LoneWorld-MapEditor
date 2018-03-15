package actions;

import data.Map;
import data.Tiles;
import gui.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ActionHandler implements ActionListener {

    Gui gui = new Gui();

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {

                gui.setButtonActive(i);

                switch (i) {
                    case 0:
                        Gui.jfNew.setVisible(true);
                        break;
                    case 3:
                        Gui.jfTileset.setVisible(true);
                        break;
                    case 8:
                        Gui.jfSettings.setVisible(true);
                        break;
                }

            }
        }

        if (e.getSource().equals(Gui.reset)) {
            Map.reset();
        }

        if (e.getSource().equals(Gui.opentileset)) {
            try {
                Desktop.getDesktop().open(new File("rsc/textures/"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource().equals(Gui.oktileset)) {
            if (!Gui.inputTileset.getText().equals("0")) {
                try {
                    Tiles.anzahl = Integer.parseInt(Gui.inputTileset.getText());
                    Tiles.active = 0;
                    Tiles.create();
                    Gui.jfTileset.setVisible(false);
                } catch (NumberFormatException e1) {
                    System.out.println("Number input error");
                }

            }
        }

        if (e.getSource().equals(Gui.oksettings)) {
            Map.gridVisible = Gui.checkGridVisible.isSelected();
            Gui.jfSettings.setVisible(false);
        }

        if (e.getSource().equals(Gui.create)) {

            try {
                if (!Gui.inputNew[0].getText().equals("0") && !Gui.inputNew[1].getText().equals("0") &&
                        !Gui.inputNew[2].getText().equals("0")) {

                    Map.kachelGroesse = Integer.parseInt(Gui.inputNew[0].getText());
                    Map.kachelnX = Integer.parseInt(Gui.inputNew[1].getText()) - 1;
                    Map.kachelnY = Integer.parseInt(Gui.inputNew[2].getText()) - 1;

                    Map.kachelGroesseCurrent = Map.kachelGroesse;
                    Map.collision.clear();
                    Gui.jfNew.setVisible(false);
                    Map.setup();
                    Map.mapActive = true;
                }
            } catch (NumberFormatException e1) {
                System.out.println("Number input error");

            }


        }

        //Tiles
        try {
            for (int i = 0; i < Tiles.tiles.length; i++) {
                if(e.getSource().equals(Tiles.tiles[i])){
                    Tiles.active = i;
                    for(int j = 0; j<Tiles.tiles.length; j++){
                        Tiles.tiles[j].setBorder(Gui.border);
                    }
                    Tiles.tiles[Tiles.active].setBorder(Gui.borderActive);
                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
