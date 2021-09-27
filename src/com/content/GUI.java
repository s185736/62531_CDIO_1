package com.content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;

public class GUI extends JFrame{
    private JButton startSpilletButton;
    private JPanel panel1;
    private JLabel printLabel;

    public GUI() {
        add(panel1);
        setTitle("Rafflebæger");
        setSize(400,250);

        System.setOut(new PrintStream(System.out) {
            @Override
            public void write(byte[] buf, int off, int len) {
                super.write(buf, off, len);
                String msg = new String(buf, off, len);
                printLabel.setText(printLabel.getText() + msg+"\n");
            }
        });

        startSpilletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dice d = new Dice();
                d.Dice();
            }
        });
    }
}
