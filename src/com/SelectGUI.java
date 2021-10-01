package com;

import com.content.GUI;
import com.test.DiceTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectGUI extends JFrame {
    private JButton spilSpilletButton;
    private JPanel panel1;
    private JButton testSpilletButton;

    public SelectGUI() {
        super("Terningspillet");
        add(panel1);
        setSize(350,200);
        setLocation(500,280);
        panel1.setLayout (null);

        spilSpilletButton.setBounds(70,30,150,20);
        testSpilletButton.setBounds(70,65,150,20);

        panel1.add(testSpilletButton);
        panel1.add(spilSpilletButton);

        getContentPane().add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        spilSpilletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUI ui = new GUI();
                ui.setVisible(true);
            }
        });
        testSpilletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                DiceTest dt = new DiceTest();
                try {
                    dt.Design();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}