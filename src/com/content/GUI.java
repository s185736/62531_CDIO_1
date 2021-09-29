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

    public GUI() { //Konstruktor: initialisere nyoprettede objekter, før det bruges.
        add(panel1);
        setTitle("Game");
        setSize(250,100);
        //Her bliver knap-funktionen implementeret via ActionListener.
        startSpilletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Funktionen af knappen implementeres herunde.
                dispose(); //slukker for JFrame(GUI'en).
                Dice game = new Dice(); //Objekter et objekt af Dice.
                game.Design(); //Kører klassen Design i Dice.java.
            }
        });
    }
}