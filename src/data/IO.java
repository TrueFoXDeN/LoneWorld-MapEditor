package data;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class IO {

  private  static File folder = new File("data");
  private  static File file;
  private  static StringBuilder sb = new StringBuilder();

    public static void safe() {

        file = new File("data/mapdata.txt");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {

                System.out.println("IO safe error");
            }
        }

        try {
            sb.delete(0,sb.capacity());
            sb.append(Map.kachelnX + 1);
            sb.append(",");
            sb.append(Map.kachelnY + 1);
            sb.append(",");
            sb.append(Map.kachelGroesse);

            sb.append("\n");

            for (Point p : Map.collision) {
                sb.append(p.x);
                sb.append(",");
                sb.append(p.y);
                sb.append(",");
            }

            sb.append("\n");

            for (int[] i : Map.layer1) {
                for (int tile : i) {
                    sb.append(tile);
                    sb.append(",");
                }
            }

            sb.append("\n");

            for (int[] i : Map.layer2) {
                for (int tile : i) {
                    sb.append(tile);
                    sb.append(",");
                }
            }

            sb.append("\n");

            for (int[] i : Map.layer3) {
                for (int tile : i) {
                    sb.append(tile);
                    sb.append(",");
                }
            }


            try {
                OutputStream stream = new FileOutputStream(file);
                stream.write(sb.toString().getBytes());
                stream.close();
                System.out.println("safe...");
                Desktop.getDesktop().open(folder);

            } catch (IOException e) {

                System.out.println("IO safe error");
            }
        } catch (Exception e) {

            System.out.println("IO Value safe error");
        }


    }

    public static void load() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("UIManager error");
        }
        JFileChooser chooser = new JFileChooser(folder);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("mapdata.txt", "txt"));
        chooser.setAcceptAllFileFilterUsed(false);
        int temp = chooser.showOpenDialog(null);

        if (temp == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();

            if (path.endsWith(".txt")) {
                file = new File(path);
                try {
                    Scanner sc = new Scanner(file);

                    String s1 = sc.nextLine();
                    String s2 = sc.nextLine();
                    String s3 = sc.nextLine();
                    String s4 = sc.nextLine();
                    String s5 = sc.nextLine();

                    String[] ss1 = s1.split(",");
                    String[] ss2 = s2.split(",");
                    String[] ss3 = s3.split(",");
                    String[] ss4 = s4.split(",");
                    String[] ss5 = s5.split(",");


                    Map.kachelnX = Integer.parseInt(ss1[0])-1;
                    Map.kachelnY = Integer.parseInt(ss1[1])-1;
                    Map.kachelGroesse = Integer.parseInt(ss1[2]);
                    Map.mapActive = true;
                    Map.reset();

                    Map.collision.clear();
                    for (int i = 0; i < ss2.length - 1; i++) {
                        Map.collision.add(new Point(Integer.parseInt(ss2[i]), Integer.parseInt(ss2[i + 1])));
                    }

                    Map.setup();

                    int temp2 = 0;
                    for (int x = 0; x < Map.kachelnX+1; x++) {
                        for (int y = 0; y < Map.kachelnY+1; y++) {
                            Map.layer1[x][y] = Integer.parseInt(ss3[temp2]);
                            Map.layer2[x][y] = Integer.parseInt(ss4[temp2]);
                            Map.layer3[x][y] = Integer.parseInt(ss5[temp2]);
                            temp2 ++;

                        }

                    }

                    sc.close();
                    System.out.println("loaded...");
                } catch (FileNotFoundException e) {
                    System.out.println("IO data parse error");
                }
            } else {
                System.out.println("IO data type error");
            }
        }
    }
}
