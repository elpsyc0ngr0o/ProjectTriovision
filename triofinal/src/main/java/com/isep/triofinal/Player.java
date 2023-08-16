package com.isep.triofinal;

public class Player {
    public int points = 0;
    public Player(){}
    public void setNumWinCards(int numWinCards) {
        this.points = numWinCards;
    }
    public int getNumWinCards() {
        return points;
    }
}