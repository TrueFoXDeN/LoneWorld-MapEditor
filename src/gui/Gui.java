package gui;

import actions.*;
import data.C;
import data.Tiles;
import data.Tools;
import draw.Draw;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Gui {

    public static Draw d;

    public static JFrame jfNew, jfMain, jfSettings, jfTileset;
    public static JButton[] buttons = new JButton[9];
    public static JButton reset, create, oksettings, oktileset, opentileset;

    public static JButton[] tools = new JButton[3];

    public static JTextArea[] inputNew = new JTextArea[3];
    public static JTextArea inputTileset;
    public static JLabel[] lblNew = new JLabel[3];

    public static JScrollPane scrollPane;
    public static JPanel scrollPanel;

    public static JCheckBox checkGridVisible, checkLayerHighlight;

    public static Border border = BorderFactory.createLineBorder(Color.BLACK);
    public static Border borderActive = BorderFactory.createLineBorder(Color.RED);

    public static int activeButton = 0;

    private static int WIDTH = 1280, HEIGHT = 720;


    public void create() {
        jfMain = new JFrame("Mapeditor");
        jfMain.setSize(WIDTH, HEIGHT);
        jfMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMain.setLocationRelativeTo(null);
        jfMain.addMouseWheelListener(new ScrollHandler());
        jfMain.setResizable(true);
        jfMain.addKeyListener(new KeyHandler());
        jfMain.setIconImage(Toolkit.getDefaultToolkit().getImage("rsc/icons/mapeditor_logo.png"));
        jfMain.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                setWIDTH(e.getComponent().getWidth());
                setHEIGHT(e.getComponent().getHeight());

            }
        });
        jfMain.setLayout(null);

        jfNew = new JFrame("New");
        jfNew.setSize(300, 225);
        jfNew.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfNew.setLocationRelativeTo(null);
        jfNew.setResizable(false);
        jfNew.setLayout(null);

        jfTileset = new JFrame("Tileset");
        jfTileset.setSize(300, 225);
        jfTileset.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfTileset.setLocationRelativeTo(null);
        jfTileset.setResizable(false);
        jfTileset.setLayout(null);

        jfSettings = new JFrame("Settings");
        jfSettings.setSize(300, 225);
        jfSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfSettings.setLocationRelativeTo(null);
        jfSettings.setResizable(false);
        jfSettings.setLayout(null);
        jfSettings.addKeyListener(new KeyHandler());

        JLabel[] lblSettings = new JLabel[5];
        for (int i = 0; i < lblSettings.length; i++) {
            lblSettings[i] = new JLabel();
            lblSettings[i].setBounds(10, 22 + i * 30, 250, 20);
            lblSettings[i].setVisible(true);
            jfSettings.add(lblSettings[i]);
        }

        JLabel[] lblSettings2 = new JLabel[3];
        for (int i = 0; i < lblSettings2.length; i++) {
            lblSettings2[i] = new JLabel();
            lblSettings2[i].setBounds(105, 22 + i * 30, 250, 20);
            lblSettings2[i].setVisible(true);
            jfSettings.add(lblSettings2[i]);
        }

        lblSettings2[0].setText("Rightclick");
        lblSettings2[1].setText("Leftclick");
        lblSettings2[2].setText("Shift + Leftclick");

        lblSettings[0].setText("Move Map:");
        lblSettings[1].setText("Draw Tile:");
        lblSettings[2].setText("Delete Tile:");
        lblSettings[3].setText("Show Grid:");
        lblSettings[4].setText("Layer Highlight:");

        checkGridVisible = new JCheckBox();
        checkGridVisible.setSelected(true);
        checkGridVisible.setVisible(true);
        checkGridVisible.setBounds(102, 112, 20, 20);
        checkGridVisible.addActionListener(e -> {
            jfSettings.requestFocus();
        });
        jfSettings.add(checkGridVisible);

        checkLayerHighlight = new JCheckBox();
        checkLayerHighlight.setSelected(true);
        checkLayerHighlight.setVisible(true);
        checkLayerHighlight.setBounds(102, 143, 20, 20);
        checkLayerHighlight.addActionListener(e -> {
            jfSettings.requestFocus();
        });
        jfSettings.add(checkLayerHighlight);

        oksettings = new JButton("Ok");
        oksettings.setBounds(200, 150, 75, 25);
        oksettings.setBackground(C.buttonFill);
        oksettings.setBorder(border);
        oksettings.setBorderPainted(true);
        oksettings.addActionListener(new ActionHandler());
        oksettings.addMouseListener(new MouseHandler());
        oksettings.setFocusPainted(false);
        oksettings.setVisible(true);
        jfSettings.add(oksettings);

        oktileset = new JButton("Ok");
        oktileset.setBounds(200, 150, 75, 25);
        oktileset.setBackground(C.buttonFill);
        oktileset.setBorder(border);
        oktileset.setBorderPainted(true);
        oktileset.addActionListener(new ActionHandler());
        oktileset.addMouseListener(new MouseHandler());
        oktileset.setFocusPainted(false);
        oktileset.setVisible(true);
        jfTileset.add(oktileset);

        opentileset = new JButton("Tileset Ordner");
        opentileset.setBounds(10, 75, 125, 25);
        opentileset.setBackground(C.buttonFill);
        opentileset.setBorder(border);
        opentileset.setBorderPainted(true);
        opentileset.addActionListener(new ActionHandler());
        opentileset.addMouseListener(new MouseHandler());
        opentileset.setFocusPainted(false);
        opentileset.setVisible(true);
        jfTileset.add(opentileset);

        JLabel lblTileset = new JLabel("Tile Count:");
        lblTileset.setBounds(10, 22, 250, 20);
        lblTileset.setVisible(true);
        jfTileset.add(lblTileset);

        inputTileset = new JTextArea(String.valueOf(Tiles.anzahl));
        inputTileset.setBounds(125, 25, 75, 20);
        inputTileset.setVisible(true);
        inputTileset.addKeyListener(new KeyHandler());
        jfTileset.add(inputTileset);

        scrollPanel = new JPanel();
        scrollPanel.setLayout(new ModifiedFlowLayout(FlowLayout.LEFT));

        scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setBounds(getWidth() - 246, getHeight() - 210, 246, 210);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setVisible(true);
        scrollPane.add(scrollPanel);


        for (int i = 0; i < inputNew.length; i++) {
            inputNew[i] = new JTextArea();
            inputNew[i].setBounds(125, 25 + i * 40, 75, 20);
            inputNew[i].addKeyListener(new KeyHandler());
            inputNew[i].setVisible(true);
            jfNew.add(inputNew[i]);
        }

        for (int i = 0; i < lblNew.length; i++) {
            lblNew[i] = new JLabel();
            lblNew[i].setBounds(20, 22 + i * 40, 75, 20);
            lblNew[i].setVisible(true);
            jfNew.add(lblNew[i]);
        }
        lblNew[0].setText("Tile Size:");
        lblNew[1].setText("Tiles x:");
        lblNew[2].setText("Tiles y:");

        JLabel lblNewPx = new JLabel("px");
        lblNewPx.setBounds(210, 22, 75, 20);
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

        buttons[0].setToolTipText("Create new Map");
        buttons[1].setToolTipText("Save Map");
        buttons[2].setToolTipText("Open existing Map");
        buttons[3].setToolTipText("Open Tileset");
        buttons[4].setToolTipText("Edit Layer 3");
        buttons[5].setToolTipText("Edit Layer 2");
        buttons[6].setToolTipText("Edit Layer 1");
        buttons[7].setToolTipText("Edit Collision Map");
        buttons[8].setToolTipText("Settings");


        setButtonActive(4);

        reset = new JButton("Reset");
        reset.setBounds(WIDTH - 105, 7, 60, 60);
        reset.setBackground(C.buttonFill);
        reset.setBorder(border);
        reset.setBorderPainted(true);
        reset.addActionListener(new ActionHandler());
        reset.addMouseListener(new MouseHandler());
        reset.setFocusPainted(false);
        reset.setVisible(true);
        reset.setToolTipText("Reset Map position & size. Not the Map.");
        jfMain.add(reset);

        for (int i = 0; i < tools.length; i++) {
            tools[i] = new JButton();
            tools[i].setBounds((i * 75) + 30, 7, 60, 60);
            tools[i].setBackground(C.buttonFill);
            tools[i].setIcon(new ImageIcon("rsc/icons/tools/t" + (i + 1) + ".png"));
            tools[i].setBorder(border);
            tools[i].setBorderPainted(true);
            tools[i].addActionListener(new ActionHandler());
            tools[i].addMouseListener(new MouseHandler());
            tools[i].setFocusPainted(false);
            tools[i].setVisible(true);
            jfMain.add(tools[i]);
        }

        tools[Tools.active].setBorder(borderActive);


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


        d = new Draw();
        d.setSize(getWidth(), getHeight());
        d.setVisible(true);
        d.requestFocus();
        d.addMouseWheelListener(new ScrollHandler());
        d.addMouseListener(new MouseHandler());
        d.addMouseMotionListener(new MouseMotionHandler());
        jfMain.add(d);

        d.add(scrollPane);

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

    public static int getWidth() {
        return WIDTH - 14;
    }

    public static int getHeight() {
        return HEIGHT - 36;
    }

    public void setWIDTH(int WIDTH) {
        Gui.WIDTH = WIDTH;

        try {
            jfMain.revalidate();
            d.setSize(WIDTH, getHeight());
            scrollPane.setBounds(WIDTH - 250, getHeight() - 250, 246, 210);

            int space = WIDTH / 2 - buttons.length * 75;
            if (space < 0) {
                space = 0;
            }

            System.out.println(space);

            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setBounds((i * 75) + (WIDTH / 4) + space/2, 7, 60, 60);
            }
            reset.setBounds(WIDTH - 105, 7, 60, 60);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setHEIGHT(int HEIGHT) {
        Gui.HEIGHT = HEIGHT;
        try {
            jfMain.revalidate();
            d.setSize(getWidth(), HEIGHT);
            scrollPane.setBounds(getWidth() - 250, HEIGHT - 250, 246, 210);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
