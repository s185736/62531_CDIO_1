package com.content;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Dice extends GUI {

    public static void Design() {
        int sumOfDices; //Summen af kastede terninger.
        int requiredPoints = 40; //Points der skal opnås for at vinde..
        //Oprettes object for scanner klassen.
        Scanner scanner = new Scanner(System.in);
        //Her defineres navnene, og anvendes til at afgøre om hvis tur det er.
        String a = "Player1";
        String b = "Player2";
        //Opretter to spillere med navne..
        User user1 = new User(a);
        User user2 = new User(b);
        //Opretter to terninger af klassen Dice..
        User dice1 = new User();
        User dice2 = new User();

        /*
         * Terning processen startes:
         * game == true -> Player1's tur.
         * game == false -> Player2's tur.
         */
        boolean game = true;
        JLabel rollLabel = new JLabel();
        if (user1.getPoints() <= requiredPoints)
            if (user2.getPoints() <= requiredPoints) {
                do {
                    if (game) {
                        System.out.println("\n" + user1.getOption() + ", det er din tur.");
                        //rollLabel.setText("\n" + user1.getOption() + ", det er din tur.");
                        System.out.println("Din samlede points: " + user1.getPoints());
                        System.out.println("Indtast kommandoen 'a' for at kaste med terningen.");
                        //rollLabel.setText("Din samlede points: " + user1.getPoints());
                    } else {
                        System.out.println("\n" + user2.getOption() + ", det er din tur.");
                        //rollLabel.setText("\n" + user2.getOption() + ", det er din tur.");
                        System.out.println("Din samlede points: " + user2.getPoints());
                        System.out.println("Indtast kommandoen 'l' for at kaste med terningen.");
                        //rollLabel.setText("Din samlede points: " + user2.getPoints());
                    }

                    //Brugeren skal taste roll for at programmet fortsætter
                    String command;
                    command = scanner.next();
                    if (command.equalsIgnoreCase("a")) //indtast ethvert bogstav/symbol for at kaste terningen.
                        //Hermed kastes to terninger d1 og d2 og lægges sammen.
                        for (User roll : Arrays.asList(dice1, dice2)) {
                            roll.roll();
                        }
                    sumOfDices = dice1.getFaceValue() + dice2.getFaceValue();
                    System.out.println("Resultat:\n   Første terning: " + dice1.getFaceValue() + ".\n   Anden terning: " + dice2.getFaceValue() + ".");
                    //Spilleregel: To 1'ere nulstiller spillerens points (regel 1).
                    if (dice1.getFaceValue() == dice2.getFaceValue() && dice1.getFaceValue() == 1 && game == true) {
                        user1.setResetPoints();
                    } else if (dice1.getFaceValue() == dice2.getFaceValue() && dice1.getFaceValue() == 1 && game == false) {
                        user2.setResetPoints();
                    } else { //Hvis ikke, så fortsættes processen..
                        System.out.println("Summen af begge Terning: " + sumOfDices + ".");
                        System.out.println("-------------------------------");
                        //Spilleregel: Hvis terningen er to 6'ere og den forrige kast var to 6'ere vil dette afbryde løkken (regel 3).
                        if (sumOfDices == 12 && user1.getFinalRoll() == 12) {
                            break;
                        } else {
                            if (sumOfDices == 12 && user2.getFinalRoll() == 12) {
                                break;
                            } else {
                                if (game == true) {
                                    //Her gives der ekstra point hvis man har fået et par.
                                    if (dice1.getFaceValue() != dice2.getFaceValue()) {
                                        user1.givePoints(sumOfDices);
                                        game = false;
                                    } else if (dice1.getFaceValue() == dice2.getFaceValue()) {
                                        user1.givePoints(sumOfDices);
                                        user1.setFinalRoll(sumOfDices);
                                        game = true;
                                    }
                                } else if (game == false) {
                                    //Her gives der ekstra point hvis man har fået et par.
                                    if (dice1.getFaceValue() != dice2.getFaceValue()) {
                                        user2.givePoints(sumOfDices);
                                        game = true;
                                    } else if (dice1.getFaceValue() == dice2.getFaceValue()) {
                                        user2.givePoints(sumOfDices);
                                        user2.setFinalRoll(sumOfDices);
                                        game = false;
                                    }
                                }
                            }
                        }
                    }
                    //Fortsætter hvis der ikke er slået nogle par.
                    if (user1.getPoints() > requiredPoints && dice1.getFaceValue() != dice2.getFaceValue()) {
                        user1.setPoints(40);
                        System.out.println(user1.getOption() + " har nu opnået 40 points, du har nu sidste chance!");
                    } else {
                        if (user2.getPoints() > requiredPoints && dice1.getFaceValue() != dice2.getFaceValue()) {
                            user2.setPoints(40);
                            System.out.println(user2.getOption() + " har nu opnået 40 points, du har nu sidste chance!");
                        }
                    }
                } while (user1.getPoints() <= requiredPoints && user2.getPoints() <= requiredPoints);
            }
        //Meddelelse om man har slået par 6 to gange (regel 3).
        if (dice1.getFaceValue() + dice2.getFaceValue() == 12) {
            if (user1.getFinalRoll() == 12) {
                System.out.println(user1.getOption() + " er vinderen, da der er slået to sæt af par 6'ere i træk.");
            }
        } else if (dice1.getFaceValue() + dice2.getFaceValue() == 12) {
            if (user2.getFinalRoll() == 12) {
                System.out.println(user2.getOption() + " er vinderen, da der er slået to sæt af par 6'ere i træk.");
            }
        }
        //Meddelelse om man har slået par (regel 2).
        if (user1.getPoints() >= requiredPoints) {
            if (dice1.getFaceValue() == dice2.getFaceValue()) {
                if (game == true) {
                    System.out.println(user1.getOption() + " er vinderen, da der er blevet slået par " + dice1.getFaceValue() + ".");
                }
            }
        } else if (user2.getPoints() >= requiredPoints) {
            if (dice1.getFaceValue() == dice2.getFaceValue()) {
                if (game == false) {
                    System.out.println(user2.getOption() + " er vinderen, da der er blevet slået par " + dice1.getFaceValue() + ".");
                }
            }
        }
    }
}