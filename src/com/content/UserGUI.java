package com.content;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserGUI extends JFrame {
    private JButton button1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField hejMedJerTextField;
    private JPanel panel;

    UserGUI(){
        super("Skriv venligst jeres navne!");
        setSize(350,200);
        setLocation(500,280);
        panel.setLayout (null);


        textField1.setBounds(70,30,150,20);
        textField2.setBounds(70,65,150,20);
        button1.setBounds(110,100,80,20);

        panel.add(textField1);
        panel.add(textField2);
        panel.add(button1);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogin();
    }

    public void actionlogin(){
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                String username1 = textField1.getText();
                String username2 = textField2.getText();
                User u1 = new User(username1);
                User u2 = new User(username2);
                Dice d = new Dice();
                d.Design(username1, username2);
            }
        });
    }
    public void start() {
        dispose();
        UserGUI user = new UserGUI();
    }
}