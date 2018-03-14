package actions;

import clocks.ApplicationLoop;
import draw.IL;
import gui.Gui;

public class Main {
    public static void main(String[] args) {

        new IL();
        Gui g = new Gui();
        g.create();
        //ApplicationLoop.start();
    }
}
