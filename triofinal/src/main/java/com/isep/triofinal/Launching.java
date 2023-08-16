package com.isep.triofinal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Launching extends Controller {
    private Operation operation;
    @FXML
    private Button button;
    @Override
    public void init(Operation operation) {
        this.operation = operation;
        this.button.setOnAction(event -> {
            try {
                this.operation.newPlayer();
                this.operation.getGame().sceneSwitch("trio.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}