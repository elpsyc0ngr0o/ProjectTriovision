package com.isep.triofinal;

import java.util.ArrayList;
public class Board {
    private ArrayList<Squares> cells = new ArrayList<>();
    public Board() {
        for (int i = 0; i < 16; i++) {
            cells.add(new Squares());
        }
        cells.get(1).setColor(Color.Red);
        cells.get(2).setColor(Color.Red);
        cells.get(4).setColor(Color.Blue);
        cells.get(7).setColor(Color.Green);
        cells.get(8).setColor(Color.Blue);
        cells.get(11).setColor(Color.Green);
        cells.get(13).setColor(Color.Yellow);
        cells.get(14).setColor(Color.Yellow);
    }
    public void exchange(Squares c1, Squares c2) {
        int i = cells.indexOf(c1);
        int j = cells.indexOf(c2);
        Color color = cells.get(i).getColor();
        cells.get(i).setColor(null);
        cells.get(j).setColor(color);
    }
    public boolean checkCard(Card card) {
        boolean value = false;
        Color middle = card.getCells().get(2).getColor();
        if (card.getType() == 1) {
            middle = card.getCells().get(3).getColor();
        }
        for (Squares cel : cells) {
            if (cel.getColor() != null && cel.getColor().equals(middle)) {
                boolean value2 = true;
                int cardMidIndex = card.getType() == 0 ? 2 : 3;
                int xDct = card.getSide();
                int yDct = card.getHeight();
                value2 &= matchCells(card.getCells(), cel, cardMidIndex, xDct, yDct);

                if (card.getHeight() == 1) {
                    value2 &= matchCells(card.getCells(), cel, cardMidIndex, 0, -1);
                } else {
                    value2 &= matchCells(card.getCells(), cel, cardMidIndex, 0, 1);
                }
                value |= value2;
            }
        }
        return value;
    }
    public ArrayList<Card> validCards(ArrayList<Card> cards) {
        ArrayList<Card> list = new ArrayList<>();
        for (Card listCards : cards) {
            if (checkCard(listCards)) {
                list.add(listCards);
            }
        }
        return list;
    }
    public boolean matchCells(ArrayList<Squares> cardList, Squares boardCtr, int cardCtrIx, int xDct, int yDct) {
        int ixCard = cardCtrIx + xDct + yDct * 2;
        int ixBoard = cells.indexOf(boardCtr) + xDct + yDct * 4;

        if (ixBoard < 0 || ixBoard >= 16 || ixCard < 0 || ixCard >= 6) {
            return false;
        }
        Color cardColor = cardList.get(ixCard).getColor();
        Color boardColor = cells.get(ixBoard).getColor();


        return cardColor != null && boardColor != null && cardColor.equals(boardColor);
    }
    public ArrayList<Squares> getCells() {
        return cells;
    }
}