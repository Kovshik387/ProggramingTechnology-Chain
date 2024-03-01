package com.example.proggramingtechnologychain;

import infrastructure.Middleware;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import model.Password;
import service.DigitMiddleWare;
import service.LenghtMiddleWare;
import service.SpecialSymboleMiddleware;
import service.SumNumberMiddleWare;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public VBox vBoxField;
    public Button checkButton;
    public TextField fieldText;
    public VBox checkPasswordBox;

    private int sumNumbers;
    private final List<String> specialSymbol = List.of("#","@","$","%","^");
    private int numSymbol;
    private int minLength;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Init();
    }

    private void Init(){
        fieldText.clear();
        sumNumbers = new Random().nextInt(0,19);
        numSymbol = new Random().nextInt(0,specialSymbol.size());
        minLength = new Random().nextInt(4,6);
    }

    public void checkButtonAction(KeyEvent event) {
        Password password = new Password(checkPasswordBox, fieldText.getText());

        checkPasswordBox.getChildren().clear();

        Middleware middleware = Middleware.link(
                new LenghtMiddleWare(minLength,20),
                new DigitMiddleWare(2),
                new SumNumberMiddleWare(sumNumbers),
                new SpecialSymboleMiddleware(specialSymbol.get(numSymbol))
        );
        password.setMiddleWare(middleware);
    }

    public void resetPasswordButton(ActionEvent event) {
        Init(); vBoxField.getChildren().clear();
    }
}