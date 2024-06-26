package infrastructure;

import javafx.scene.layout.VBox;

public abstract class Middleware {
    private Middleware next;
    public static Middleware link(Middleware first, Middleware... chain) {
        Middleware head = first;
        for (Middleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(String password, VBox box);

    protected boolean checkNext(String password, VBox box) {
        if (next == null) {
            return true;
        }
        return next.check(password,box);
    }
}
