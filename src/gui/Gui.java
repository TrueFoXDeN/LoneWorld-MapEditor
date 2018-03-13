package gui;

import actions.ActionHandler;
import actions.MouseHandler;
import actions.MouseMotionHandler;
import actions.ScrollHandler;
import data.C;
import draw.Draw;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Gui {

    static public JFrame jfNew, jfMain;
    public static JButton[] buttons = new JButton[9];
    public static JButton reset, create;

    public static JTextArea[] inputNew = new JTextArea[3];
    public static JLabel[] lblNew = new JLabel[3];


    private Border border = BorderFactory.createLineBorder(Color.BLACK);
    private Border borderActive = BorderFactory.createLineBorder(Color.RED);

    private static int activeButton = 0;

    private final int WIDTH = 1280, HEIGHT = 720;


    public void create() {
        jfMain = new JFrame("Lone World - Mapeditor");
        jfMain.setSize(WIDTH, HEIGHT);
        jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMain.setLocationRelativeTo(null);
        jfMain.addMouseWheelListener(new ScrollHandler());
        jfMain.setResizable(false);
        jfMain.setLayout(null);


        jfNew = new JFrame("New");
        jfNew.setSize(300, 225);
        jfNew.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfNew.setLocationRelativeTo(null);
        jfNew.setResizable(false);
        jfNew.setLayout(null);

        for (int i = 0; i < inputNew.length; i++) {
            inputNew[i] = new JTextArea();
            inputNew[i].setBounds(125, 25 + i * 40, 75, 20);
            inputNew[i].setVisible(true);
            jfNew.add(inputNew[i]);
        }


        for (int i = 0; i < lblNew.length; i++) {
            lblNew[i] = new JLabel();
            lblNew[i].setBounds(20, 25 + i * 40, 75, 20);
            lblNew[i].setVisible(true);
            jfNew.add(lblNew[i]);
        }
        lblNew[0].setText("Kachelgöße");
        lblNew[1].setText("Anzahl x:");
        lblNew[2].setText("Anzahl y:");

        JLabel lblNewPx = new JLabel("px");
        lblNewPx.setBounds(210, 25, 75, 20);
        lblNewPx.setVisible(true);
        jfNew.add(lblNewPx);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setBounds((i * 75) + WIDTH / 4 - 15, 7, 60, 60);
            buttons[i].setBackground(C.buttonFill);
            buttons[i].setIcon(new ImageIcon("rsc/icons/" + (i + 1) + ".png"));
            buttons[i].setBorder(border);
            buttons[i].setBorderPainted(true);
            buttons[i].addActionListener(new ActionHandler());
            buttons[i].addMouseListener(new MouseHandler());
            buttons[i].setFocusPainted(false);
            buttons[i].setVisible(true);
            jfMain.add(buttons[i]);
        }

        setButtonActive(4);

        reset = new JButton("Reset");
        reset.setBounds(WIDTH - 250, 7, 60, 60);
        reset.setBackground(C.buttonFill);
        reset.setBorder(border);
        reset.setBorderPainted(true);
        reset.addActionListener(new ActionHandler());
        reset.addMouseListener(new MouseHandler());
        reset.setFocusPainted(false);
        reset.setVisible(true);
        jfMain.add(reset);


        create = new JButton("Create");
        create.setBounds(200, 150, 75, 25);
        create.setBackground(C.buttonFill);
        create.setBorder(border);
        create.setBorderPainted(true);
        create.addActionListener(new ActionHandler());
        create.addMouseListener(new MouseHandler());
        create.setFocusPainted(false);
        create.setVisible(true);
        jfNew.add(create);


        Draw d = new Draw();
        d.setSize(getWidth(), getHeight());
        d.setVisible(true);
        d.requestFocus();
        d.addMouseWheelListener(new ScrollHandler());
        d.addMouseListener(new MouseHandler());
        d.addMouseMotionListener(new MouseMotionHandler());
        jfMain.add(d);


        jfMain.requestFocus();
        jfMain.setVisible(true);
    }

    public void setButtonActive(int index) {

        if (index >= 4 && index <= 7) {

            for (JButton b : buttons) {
                b.setBorder(border);
            }

            buttons[index].setBorder(borderActive);
            activeButton = index;
        }

    }

    public int getWidth() {
        return WIDTH - 14;
    }

    public int getHeight() {
        return HEIGHT - 36;
    }

}
