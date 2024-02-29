package service;

import infrastructure.Middleware;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class LenghtMiddleWare extends Middleware {
    private final int min;
    private final int max;

    public LenghtMiddleWare(int min, int max){
        this.min = min; this.max = max;
    }

    @Override
    public boolean check(String password, VBox box) {
        var text = new Text();
        if (!(password.length() <= max && password.length() >= min)){
            text.setText("Длина пароля должна быть от " + min + " до " + max);
            text.setFill(Color.RED);
            box.getChildren().add(text);
            return false;
        }
        text.setText("Длина пароля от " + min + " до " + max);
        text.setFill(Color.GREEN);
        box.getChildren().add(text);

        return checkNext(password,box);
    }
}
