package com.isep.triofinal;

import java.util.ArrayList;
public class Operation {
    private Game game;
    private Turn turn = Turn.Wait;
    private Board board;
    private ArrayList<Card> activatedCards = new ArrayList<>();
    private Player player = null;
    private ArrayList<Player> players = new ArrayList<>();
    public Operation(Game game) {
        this.game = game;
        this.board = new Board();
        for (int i = 0; i < 12; i++) {
            activatedCards.add(new Card());
        }
    }
    public void setplayer(Player player) {
        this.player = player;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public Turn getTurn() {
        return turn;
    }
    public Board getBoard() {
        return board;
    }
    public void newPlayer() {

        players.add(new Player());
    }
    public ArrayList<Card> getactivatedCards() {
        return activatedCards;
    }
    public Game getGame() {
        return game;
    }
    public void playerWinsCards(ArrayList<Card> validCards) {
        for (Card card : validCards) {
            processCard(card);
        }
        setplayer(null);
    }
    public void processCard(Card card) {
        int index = activatedCards.indexOf(card);
        activatedCards.set(index, new Card());
        player.setNumWinCards(player.getNumWinCards() + 1);
    }
}