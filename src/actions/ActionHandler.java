package actions;

import data.Map;
import gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    Gui gui = new Gui();

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < Gui.buttons.length; i++) {
            if (e.getSource().equals(Gui.buttons[i])) {

                gui.setButtonActive(i);

                switch (i){
                    case 0:

                        Gui.jfNew.setVisible(true);
                }

            }
        }

        if(e.getSource().equals(Gui.reset)){
            Map.reset();
        }

        if(e.getSource().equals(Gui.create)){

            try {
                Map.kachelGroesse = Integer.parseInt(Gui.inputNew[0].getText());
                Map.kachelnX = Integer.parseInt(Gui.inputNew[1].getText());
                Map.kachelnY = Integer.parseInt(Gui.inputNew[2].getText());

                Map.kachelGroesseCurrent = Map.kachelGroesse;

                Gui.jfNew.setVisible(false);
                Map.mapActive = true;
            } catch (NumberFormatException e1) {
                System.out.println("Number input error");

            }


        }

    }
}
