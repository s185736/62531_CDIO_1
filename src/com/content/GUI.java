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
    public JLabel scoreBoard;


    public GUI() { //Konstruktor: initialisere nyoprettede objekter, før det bruges.
        add(panel1);

        setTitle("Terningspil");
        setBounds(100,100,450,300);
        // Stopper programmet hvis vinduet lukkes før start
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Placere GUI midt for skærmen
        setLocationRelativeTo(null);

        //Her bliver knap-funktionen implementeret via ActionListener.
        startSpilletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Funktionen af knappen implementeres herunde.
                //dispose(); //slukker for JFrame(GUI'en).
                Dice game = new Dice(); //Objekter et objekt af Dice.
                game.Design(); //Kører klassen Design i Dice.java.

            }
        });
    }
}