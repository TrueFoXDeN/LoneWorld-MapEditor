package actions;

import data.IO;
import data.Map;
import data.Tiles;
import data.Tools;
import draw.IL;
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
                    case 1:
                        IO.safe();
                        break;
                    case 2:
                        IO.load();
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
                    String anz = Gui.inputTileset.getText();
                    while (anz.endsWith("\t")) {
                        anz = anz.substring(0, anz.length() - 1);
                    }

                    Tiles.anzahl = Integer.parseInt(anz);
                    Tiles.active = 1;
                    IL.setupTextures();
                    Tiles.create();

                    if (Tiles.anzahl > 30) {
                        Gui.scroll.setVisibleAmount(10);
                    }

                    Gui.jfTileset.setVisible(false);
                } catch (NumberFormatException e1) {
                    System.out.println("Number input error");
                }

            }
        }

        if (e.getSource().equals(Gui.oksettings)) {
            Map.gridVisible = Gui.checkGridVisible.isSelected();
            Map.layerHighlight = Gui.checkLayerHighlight.isSelected();
            Gui.jfSettings.setVisible(false);
        }

        if (e.getSource().equals(Gui.create)) {

            try {
                if (!Gui.inputNew[0].getText().equals("0") && !Gui.inputNew[1].getText().equals("0") &&
                        !Gui.inputNew[2].getText().equals("0")) {

                    String s1 = Gui.inputNew[0].getText().trim();

                    while (s1.endsWith("\t")) {
                        s1 = s1.substring(0, s1.length() - 1);
                    }
                    Gui.inputNew[0].setText(s1);

                    String s2 = Gui.inputNew[1].getText().trim();

                    while (s2.endsWith("\t")) {
                        s2 = s2.substring(0, s2.length() - 1);
                    }
                    Gui.inputNew[1].setText(s2);

                    String s3 = Gui.inputNew[2].getText().trim();

                    while (s3.endsWith("\t")) {
                        s3 = s3.substring(0, s3.length() - 1);
                    }
                    Gui.inputNew[2].setText(s3);

                    Map.kachelGroesse = Integer.parseInt(s1);
                    Map.kachelnX = Integer.parseInt(s2) - 1;
                    Map.kachelnY = Integer.parseInt(s3) - 1;

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

        //Tools
        for (int i = 0; i < Gui.tools.length; i++) {
            if(e.getSource().equals(Gui.tools[i])){
                Tools.setActive(i);
            }
        }

        //Tiles
        try {
            for (int i = 0; i < Tiles.tiles.length; i++) {
                if (e.getSource().equals(Tiles.tiles[i])) {
                    Tiles.active = i + 1;
                    for (int j = 0; j < Tiles.tiles.length; j++) {
                        Tiles.tiles[j].setBorder(Gui.border);
                    }
                    Tiles.tiles[Tiles.active - 1].setBorder(Gui.borderActive);

                }
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
