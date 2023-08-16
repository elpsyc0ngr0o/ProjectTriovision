package com.isep.triofinal;

public enum Color {
    Red, Green, Blue, Yellow, ;
    public javafx.scene.paint.Color getPaint(){
        javafx.scene.paint.Color defColor = null;

        javafx.scene.paint.Color redColor = javafx.scene.paint.Color.rgb(255, 0, 0);
        javafx.scene.paint.Color greenColor = javafx.scene.paint.Color.rgb(0, 255, 0);
        javafx.scene.paint.Color blueColor = javafx.scene.paint.Color.rgb(0, 0, 255);
        javafx.scene.paint.Color yellowColor = javafx.scene.paint.Color.rgb(255, 255, 0);

        switch (this) {
            case Red:
                defColor = redColor;
                break;
            case Green:
                defColor = greenColor;
                break;
            case Blue:
                defColor = blueColor;
                break;
            case Yellow:
                defColor = yellowColor;
                break;
        }
        return defColor;
    }
}