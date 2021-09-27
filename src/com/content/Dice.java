package com.content;

public class Dice {

    public static void Dice() {
        int Ole[] = new int[50], Jens[] = new int[50]; //1. terning.
        int Ole1[] = new int[50], Jens1[] = new int[50]; //2. terning.
        int OlePoints = 0, JensPoints = 0;
        int matches = 50, i =0; //matches; antal runder.

        while (i < Ole.length) {
            System.out.println("Status: " + matches+". runde.");
            Ole[i] = (int) ((Math.random() * 6) + 1);
            Jens[i] = (int) ((Math.random() * 6) + 1);
            Ole1[i] = (int) ((Math.random() * 6) + 1);
            Jens1[i] = (int) ((Math.random() * 6) + 1);
            System.out.println("Ole kaster " + Ole[i]+" og " + Ole1[i]+".");
            System.out.println("Jens kaster " + Jens[i]+" og " + Jens1[i]+".");
            System.out.println("---------------------------");

            if (Ole[i] != Jens[i]) {
                if (Ole[i] > Jens[i]) OlePoints = OlePoints + 5;
                else if (Jens[i] > Ole[i]) {
                    JensPoints = JensPoints + 5;
                }
                OlePoints += 3;
                JensPoints += 3;
            } else {
                OlePoints += 3;
                JensPoints += 3;
            }
            if (OlePoints >= 50) {
                break;
            } else if (JensPoints >= 50) {
                break;
            }
            i++;
        }
        System.out.println("\nDer er i alt blevet spillet "+matches+" runder.");
        System.out.println("Resultatet: Ole ("+OlePoints+") og Jens("+JensPoints+").");

        if (Jens[i] == Ole[i]) {
            System.out.println("Spillet er uafgjort!");
        } else {
            System.out.println(OlePoints >= JensPoints ? "Ole har vundet!" : "Jens har vundet!");
        }
    }
}