package com.example.proggramingtechnologychain;

import infrastructure.Middleware;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import model.Password;
import service.DigitMiddleWare;
import service.LenghtMiddleWare;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public VBox vBoxField;
    public Button checkButton;
    public TextField fieldText;
    public VBox checkPasswordBox;

    private Password password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void checkButtonAction(KeyEvent event) {
        password = new Password(checkPasswordBox,fieldText.getText());

        checkPasswordBox.getChildren().clear();

        Middleware middleware = Middleware.link(
                new LenghtMiddleWare(1,8),
                new DigitMiddleWare(2)
        );
        password.setMiddleWare(middleware);
    }
}