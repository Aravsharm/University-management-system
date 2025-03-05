package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        t = new Thread(this);
        t.start();
        setVisible(true);
        setLocation(250, 50);
        setSize(1000, 700);
        setVisible(true);
    }

    public void run() {
        try {
            Thread.sleep(2000);
            setVisible(false);
            //next fram
            new login();
        } catch (Exception e) {

        }
    }

    public static void main(String ar[]) {
        new Splash();
    }
}
