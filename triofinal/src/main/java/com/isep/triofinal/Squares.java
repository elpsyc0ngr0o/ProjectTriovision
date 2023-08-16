package com.isep.triofinal;

public class Squares {
    private Color color;
    public Squares(){
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public boolean isEmpty(){
        return this.color == null;
    }
}