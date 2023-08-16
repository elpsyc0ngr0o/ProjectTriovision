package com.isep.triofinal;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

public class Trio extends Controller {
    private Board board;
    private Operation operation;
    private Squares selection = null;
    @FXML
    private GridPane gridPane;
    @FXML
    private GridPane card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11,card12;
    @FXML
    private Label player1Label, pointsP1;
    private ArrayList<GridPane> cardGrids;
    @Override
    public void init(Operation operation) {

        this.operation = operation;
        this.board = operation.getBoard();
        this.cardGrids = new ArrayList<>(List.of(card1,card2,card3,card4,card5,card6,
                card7,card8,card9,card10,card11,card12));
        updateBoard();
        updateCards();

        operation.getGame().getScene().setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case UP:
                    operation.setTurn(Turn.Turn);
                    operation.setplayer(operation.getPlayers().get(0));
                    break;
                case DOWN:
                    operation.setTurn(Turn.Twice);
                    operation.setplayer(operation.getPlayers().get(0));
                    break;

            }
        });

    }

    public void updateBoard(){

        for(Squares c : board.getCells()){

            Circle circle = getBoardCircleFromCase(c);

            circle.setOnMouseClicked(mouseEvent -> {

                Squares c1 = getCaseFromCircle(circle);

                if(selection != null){
                    Circle circle1 = getBoardCircleFromCase(selection);
                    circle1.setStrokeWidth(1);
                    circle1.setStroke(Color.BLACK);
                    if( !c1.equals(selection) && c1.isEmpty()){
                        if(operation.getTurn().equals(Turn.Turn)){
                            board.exchange(selection,c1);
                            operation.playerWinsCards(board.validCards(operation.getactivatedCards()));
                            player1Label.setTextFill(Color.BLACK);
                            operation.setTurn(Turn.Wait);

                        } else if (operation.getTurn().equals(Turn.Twice)) {
                            board.exchange(selection,c1);
                            operation.setTurn(Turn.Turn);
                        }
                        updateBoard();
                        updateCards();
                        pointsP1.setText("Total de points = "+ operation.getPlayers().get(0).getNumWinCards());
                    }
                    selection = null;
                }else if(!c1.isEmpty()){

                    selection = c1;
                    Circle circle1 = getBoardCircleFromCase(c1);
                    circle1.setStrokeWidth(5);
                }
            });
            if(c.isEmpty()){
                circle.setOpacity(0.0);
            }else {
                circle.setOpacity(1);
                circle.setFill(c.getColor().getPaint());
            }
        }
    }
    public Circle getChildrenFromIndex(GridPane grid,int i, int j){
        Circle result = new Circle();
        ObservableList<Node> childrens = grid.getChildren();
        for(Node circle : childrens) {
            if(grid.getRowIndex(circle) == i && grid.getColumnIndex(circle) == j) {
                result = (Circle)circle;
                break;
            }
        }
        return result;
    }
    public Circle getBoardCircleFromCase(Squares c1){
        int i = board.getCells().indexOf(c1)/4;
        int j = board.getCells().indexOf(c1)%4;
        return getChildrenFromIndex(this.gridPane,i,j);
    }
    public Squares getCaseFromCircle(Circle circle){
        for(int j = 0; j<4; j++){
            for(int i = 0; i<4; i++){
                if(this.gridPane.getRowIndex(circle) == i && this.gridPane.getColumnIndex(circle) == j){
                    int index = i*4+j;
                    return board.getCells().get(index);
                }
            }
        }
        return null;
    }
    public void updateCards(){

        for(Card card : operation.getactivatedCards()){
            int index = operation.getactivatedCards().indexOf(card);

            for(Squares c : card.getCells()){
                GridPane grid = cardGrids.get(index);
                int i = card.getCells().indexOf(c)/2;
                int j = card.getCells().indexOf(c)%2;
                Circle circle = getChildrenFromIndex(grid,i,j);
                if(c.isEmpty()){
                    circle.setOpacity(0.0);
                }else {
                    circle.setOpacity(1);
                    circle.setFill(c.getColor().getPaint());
                }
            }
        }
    }
}