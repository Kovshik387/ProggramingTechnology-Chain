package service;

import infrastructure.Middleware;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SumNumberMiddleWare extends Middleware {
    private final int sum;
    public SumNumberMiddleWare(int sum){
        this.sum = sum;
    }
    @Override
    public boolean check(String password, VBox box) {
        var text = new Text();

        var sumNum = 0;

        for (int i = 0; i < password.length();i++){
            if (Character.isDigit(password.charAt(i))){
                sumNum += Character.getNumericValue(password.charAt(i));
                if (sumNum == sum){

                }
            }
        }


        return checkNext(password,box);
    }
}
