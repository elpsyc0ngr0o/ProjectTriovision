package com.isep.triofinal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Card {
    private Random random = new Random();
    private ArrayList<Squares> cells = new ArrayList<>();
    private int type = 0;
    public int height = 0;
    public int side = 0;
    public Card() {
        for (int i = 0; i < 6; i++) {
            cells.add(new Squares());
        }
        cardType();
    }
    public ArrayList<Color> colorPossibility() {
        List<Color> colors = new ArrayList<>(List.of(Color.Red, Color.Red, Color.Green, Color.Green, Color.Blue, Color.Blue, Color.Yellow, Color.Yellow));

        Collections.shuffle(colors);

        ArrayList<Color> returnedColors = new ArrayList<>(colors.subList(0, 3));
        return returnedColors;
    }
    public void cardType() {
        int rdm = random.nextInt(4);
        ArrayList<Color> colors = colorPossibility();

        Squares cell0 = cells.get(0);
        Squares cell1 = cells.get(1);
        Squares cell2 = cells.get(2);
        Squares cell3 = cells.get(3);
        Squares cell4 = cells.get(4);
        Squares cell5 = cells.get(5);

        if (rdm == 0) {
            this.type = 0;
            height = 1;
            side = 1;

            cell0.setColor(colors.get(0));
            cell2.setColor(colors.get(1));
            cell5.setColor(colors.get(2));
        } else if (rdm == 1) {
            this.type = 1;
            height = 1;
            side = -1;

            cell1.setColor(colors.get(0));
            cell3.setColor(colors.get(1));
            cell4.setColor(colors.get(2));
        } else if (rdm == 2) {
            this.type = 0;
            height = -1;
            side = 1;

            cell1.setColor(colors.get(0));
            cell2.setColor(colors.get(1));
            cell4.setColor(colors.get(2));
        } else {
            this.type = 1;
            height = -1;
            side = -1;

            cell0.setColor(colors.get(0));
            cell3.setColor(colors.get(1));
            cell5.setColor(colors.get(2));
        }
    }
    public int getType() {
        return type;
    }
    public int getHeight() {
        return height;
    }
    public int getSide() {
        return side;
    }
    public ArrayList<Squares> getCells() {
        return cells;
    }}

