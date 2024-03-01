package service;

import infrastructure.Middleware;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SpecialSymboleMiddleware extends Middleware {
    private final String character;

    public SpecialSymboleMiddleware(String character){
        this.character = character;
    }


    @Override
    public boolean check(String password, VBox box) {
        var text = new Text();
        var sumNum = 0;

        if (password.contains(character)) {
            text.setText("Пароль содержит специальный символ " + character);
            text.setFill(Color.GREEN);
            box.getChildren().add(text);
            return checkNext(password, box);
        }

        text.setText("Пароль должен содержать специальный символ " + character);
        text.setFill(Color.RED);
        box.getChildren().add(text);

        return false;
    }
}
