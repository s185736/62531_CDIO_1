package com.content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Status: In-progress.
 */

public class GUI extends JFrame{
    private JButton startSpilletButton;
    private JPanel panel1;
    private JLabel printLabel;

    public GUI() { //Konstruktor..
        add(panel1);
        setTitle("Game");
        setSize(250,100);
        startSpilletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
