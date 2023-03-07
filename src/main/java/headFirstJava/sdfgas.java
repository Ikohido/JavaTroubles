package headFirstJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

class sdfgas extends Exception {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        sdfgas gui = new sdfgas();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setSize(300, 300);
        frame.setVisible(true);
        }

}
