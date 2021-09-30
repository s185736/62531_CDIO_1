/*Kilde: https://www.unf.edu/~wkloster/2551/Dice.java */
package com.content;
import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Dice extends GUI {

    /* Spillet:
     * For at gennemføre spillet genererer vi to tilfældige tal for hver spiller og samler summen af hver kast.
     * Derefter skal der kontrolleres, om de to tal er ens eller ej.
     * Hvis de er de samme, skal vi generere yderligere to til den samme spiller (får ekstra kast).
     * Dog hvis der kastes par 1'ere vil spillerens points nulstilles.
     * Kastes der to par 6'ere i løbet af kampen vil spilleren der har kastet vinde kampen.
     * Så vil der kontrolleres, om deres points (hver for sig) er lig 40 eller større.
     * Dermed første spiller der har opnået 40 points vil vinde kampen.
     */

    public static void Design(String puname1, String puname2) {
        int sumOfDices; //Summen af kastede terninger.
        int requiredPoints = 40; //Points der skal opnås for at kunne vinde..
        //Oprettes object for scanner klassen.
        Scanner scanner = new Scanner(System.in);
        //Her defineres navnene, og anvendes til at afgøre om hvis tur det er.
        String a = puname1;
        String b = puname2;
        //Opretter to spillere med navne..
        User user1, user2;
        user1 = new User(a);
        user2 = new User(b);
        //Opretter to terninger af klassen Dice..
        User dice1, dice2;
        dice1 = new User();
        dice2 = new User();

        /* Terning processen startes:
         * game == true -> Player1's tur.
         * game == false -> Player2's tur.
         */
        boolean game = true;
        JLabel rollLabel = new JLabel();


        //GUI gui = new GUI();


        if (user1.getPoints() <= requiredPoints)
            if (user2.getPoints() <= requiredPoints) {
                do {
                    if (game) {
            System.out.println("\n" + user1.getOption() + ", det er din tur.");
            //rollLabel.setText("\n" + user1.getOption() + ", det er din tur.");
            System.out.println("Din samlede points: " + user1.getPoints());

            /*gui.scoreBoard.setText("hej" + user1.getPoints());
            gui.doLayout();*/

            System.out.println("Indtast kommandoen 'a' for at kaste med terningen.");
            //rollLabel.setText("Din samlede points: " + user1.getPoints());
        } else {
            System.out.println("\n" + user2.getOption() + ", det er din tur.");
            //rollLabel.setText("\n" + user2.getOption() + ", det er din tur.");
            System.out.println("Din samlede points: " + user2.getPoints());
            System.out.println("Indtast kommandoen 'l' for at kaste med terningen.");
            //rollLabel.setText("Din samlede points: " + user2.getPoints());
        }
        //Brugeren skal taste et bogstav for at programmet fortsætter
        String command;
        command = scanner.next();
        if (command.equalsIgnoreCase("a") || command.equalsIgnoreCase("l")) //indtast ethvert bogstav/symbol for at kaste terningen.
            //Hermed kastes to terninger dice 1 og 2 og lægges sammen.
            for (User roll : Arrays.asList(dice1, dice2)) {
                roll.roll();
            }
        //Samlede resultat af kast med 2 personer.
        sumOfDices = dice1.getFaceValue() + dice2.getFaceValue();
        System.out.println("Resultat:\n   Første terning: " + dice1.getFaceValue() + ".\n   Anden terning: " + dice2.getFaceValue() + ".");
        //Spilleregel: To 1'ere nulstiller spillerens points (regel 1).
        //setResetPoints nulstiller points når spillerne rammer par 1'ere..
        if (dice1.getFaceValue() == dice2.getFaceValue() && dice1.getFaceValue() == 1 && game == true) {
            user1.setResetPoints(); //hvis true så nulstilles points.
        } else if (dice1.getFaceValue() == dice2.getFaceValue() && dice1.getFaceValue() == 1 && game == false) {
            user2.setResetPoints(); //hvis true så nulstilles points.
        } else { //Hvis ikke, så fortsættes processen..
            System.out.println("Summen af begge Terning: " + sumOfDices + ".");
            System.out.println("-------------------------------");
            //Spilleregel: Hvis terningen er to 6'ere og den forrige kast var to 6'ere vil dette afbryde løkken (regel 3).
            //If-sætning for at tjekke om man har fået 12 points (6x2) og også forrige kast.
            if (sumOfDices == 12 && user1.getFinalRoll() == 12) {
                break;
            } else {//samme gøres for spiller2.
                if (sumOfDices == 12 && user2.getFinalRoll() == 12) {
                    break;
                } else {
                    if (game) { //spiller1
                    //Hvis begge terninger ikke er ens gives samlede points.
                    if (dice1.getFaceValue() != dice2.getFaceValue()) {
                        user1.givePoints(sumOfDices); //points af samlede kast.
                        game = false;
                    } else {
                        if (dice1.getFaceValue() != dice2.getFaceValue()) {
                        } else { //en ny tilstand tilføjes hvis begge terninger er det samme.
                            //faceValue tjekker om man har slået 6 par samt den forrige.
                            user1.givePoints(sumOfDices); //Giver points af samlede kast.
                            user1.setFinalRoll(sumOfDices); //Kastes der igen et par vinder spilleren.
                            game = true;
                        }
                    }
                    } else if (!game) { //spiller2
                        //Her gives der ekstra point hvis man har fået et par.
                      if (dice1.getFaceValue() == dice2.getFaceValue()) {
                        if (dice1.getFaceValue() == dice2.getFaceValue()) { //faceValue tjekker om man har slået 6 par samt den forrige.
                            user2.givePoints(sumOfDices);
                            user2.setFinalRoll(sumOfDices);
                            game = false;
                        }
                    } else {
                        user2.givePoints(sumOfDices);
                        game = true;
                    }
                  }
                }
            }
        }
                    regel1(user1, user2, dice1, dice2, requiredPoints); //tjek klassen.
                } while (user1.getPoints() <= requiredPoints && user2.getPoints() <= requiredPoints);
            }
        regel2_3(user1, user2, dice1, dice2, requiredPoints); //tjek klassen.
    }

    public static void regel1(User user1, User user2, User dice1, User dice2, int requiredPoints) {
        //Processen fortsættes, hvis der ikke er kastet nogle par.
        if (user1.getPoints() <= requiredPoints) {
            if (user2.getPoints() >= requiredPoints) {
                if (dice1.getFaceValue() != dice2.getFaceValue()) {
                    System.out.println(user2.getOption() + " har nu opnået 40 points og har dermed vundet spillet.\nTillykke!");
                }
            }
        } else {
            if (dice1.getFaceValue() != dice2.getFaceValue()) {
                System.out.println(user1.getOption() + " har nu opnået 40 points og har dermed vundet spillet.\nTillykke!");
            }
        }
    }

    public static void regel2_3(User user1, User user2, User dice1, User dice2, int requiredPoints) {
        boolean game = true; //game process, true = player1 false = player2
        //Meddelelse om man har slået par 6 to gange (regel 3).
        if (dice1.getFaceValue() + dice2.getFaceValue() != 12) {
            if (dice1.getFaceValue() + dice2.getFaceValue() == 12) { //samlet points af to terninger.
                if (user2.getFinalRoll() == 12) {//for spiller2
                    System.out.println(user2.getOption() + " er vinderen, da der er slået to sæt af par 6'ere i træk.");
                }
            }
        } else { //samlet points af to terninger.
            if (user1.getFinalRoll() == 12) {//for spiller1
                System.out.println(user1.getOption() + " er vinderen, da der er slået to sæt af par 6'ere i træk.");
            }
        }
        //Meddelelse om man har slået par (regel 2).
        if (user1.getPoints() < requiredPoints) {
            if (user2.getPoints() >= requiredPoints) {
                if (dice1.getFaceValue() == dice2.getFaceValue()) { //faceValue tjekker om man har slået par.
                    if (game == false) { //player2
                        System.out.println(user2.getOption() + " er vinderen, da der er blevet slået par " + dice1.getFaceValue() + ".");
                    }
                }
            }
        } else {
            if (dice1.getFaceValue() == dice2.getFaceValue()) { //faceValue tjekker om man har slået par.
                if (game == true) { //player1
                    System.out.println(user1.getOption() + " er vinderen, da der er blevet slået par " + dice1.getFaceValue() + ".");
                }
            }
        }
    }
}