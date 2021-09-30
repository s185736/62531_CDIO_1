package com.content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * Status: In-progress.
 */

public class GUI extends JFrame{
    private JButton startButton;
    private JPanel panel1;
    private JTextPane programmetSimulererEtTerningspilTextPane;


    public GUI() { //Konstruktor: initialisere nyoprettede objekter, før det bruges.
        add(panel1);
        setTitle("Terningspil");
        setBounds(100,100,450,300);
        // Stopper programmet hvis vinduet lukkes før start
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Placere GUI midt for skærmen
        setLocationRelativeTo(null);

        //Her bliver knap-funktionen implementeret via ActionListener.
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Funktionen af knappen implementeres herunde.
                dispose(); //slukker for JFrame(GUI'en).
                String username1 = "";
                String username2 = "";
                UserGUI ug = new UserGUI(); //Objekter et objekt af Dice.
                ug.start();

            }
        });
    }
}