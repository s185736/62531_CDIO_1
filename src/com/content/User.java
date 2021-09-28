package com.content;

class User {
    private int points, finalRoll, fValue;
    private String string;

    public User(String string) { this.string = string;}

    public String getOption() { return this.string;}

    public void givePoints(int sum) { this.points = this.points + sum;}

    public void setPoints(int points) { this.points = points;}

    public int getPoints() { return this.points;}

    public int getFinalRoll() { return finalRoll; }

    public void setFinalRoll(int value) { this.finalRoll = value;}

    public User() { fValue = 1; }

    public int getFaceValue() { return fValue; } //

    public void roll() { fValue = (int)(Math.random() * 6) + 1; } //(opretter tilfældige integers fra 1-6).

    public int setResetPoints() {
        this.points = 0; return this.points;
    }
}