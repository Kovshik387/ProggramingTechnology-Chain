package model;

import infrastructure.Middleware;
import javafx.scene.layout.VBox;

public class Password {
    private Middleware middleware;
    private final VBox box;
    private final String password;
    public Password(VBox box, String password){
        this.box = box; this.password = password;
    }

    public boolean setMiddleWare(Middleware middleware){
        return middleware.check(this.password, this.box);
    }

}
