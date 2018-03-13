package actions;

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

            }
        }

    }
}
