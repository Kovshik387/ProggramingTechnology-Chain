package service;

import infrastructure.Middleware;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class DigitMiddleWare extends Middleware {
    private final int countNum;

    public DigitMiddleWare(int countNum){
        this.countNum = countNum;
    }

    @Override
    public boolean check(String password, VBox box) {
        var text = new Text();
        if (checkDigit(password)){
            text.setText("В пароле должно содержится " + countNum + " цифр");
            text.setFill(Color.GREEN);

            box.getChildren().add(text);

            return checkNext(password,box);
        }
        text.setText("В пароле должно содержаться " + countNum + " цифр");
        text.setFill(Color.RED);
        box.getChildren().add(text);
        return false;
    }

    private boolean checkDigit(String password){
        int count = 0;
        for (int i = 0; i < password.length();i++){
            if (Character.isDigit(password.charAt(i))) count++;

            if (count == this.countNum)
                return true;
        }
        return false;
    }
}
