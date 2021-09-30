package com.content;

class User {
    private int points, finalRoll, fValue;
    private String string;

    public User(String string) { this.string = string;}

    public String getOption() { return this.string;}

    public void givePoints(int sum) { this.points = this.points + sum;}

    public int getPoints() { return this.points;}

    public int getFinalRoll() { return finalRoll; }

    public void setFinalRoll(int value) { this.finalRoll = value;}

    //Spillernes sættes til face value.
    public User() { fValue = 1; }

    //Face value: nuværende værdi, der vises på terningen.
    public int getFaceValue() { return fValue; } //

    //(opretter tilfældige integers fra 1-6).
    public void roll() { fValue = (int)(Math.random() * 6) + 1; } //maximum face value dvs. op til 6.

    //Anvendes for spillere der slå par 1'ere.
    public int setResetPoints() {
        this.points = 0; return this.points;
    }
}