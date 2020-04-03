package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Kalaha {

    public static Player turn = Player.ONE;
    public static ObjectProperty<Player> pTurn = new SimpleObjectProperty<>(Player.ONE);

    public Kalaha(){

    }

    public static void handleClick(Pit clicked){
        if(clicked.owner == turn && clicked.pearls.get() != 0)
            distribute(clicked);
        else return;
    }

    public static void distribute(Pit toDistribute){
        int pearls = toDistribute.pearls.get();

        Pit next = toDistribute.next;
        toDistribute.setPearls(0);

        while (pearls != 0) {
            if (next.house) {
                if (next.owner == turn) {
                    next.setPearls(next.pearls.get() + 1);
                    pearls--;
                    next = next.next;
                    continue;
                } else{
                    next = next.next;
                    continue;
                }
            }

            pearls--;
            next.setPearls(next.pearls.get() + 1);
            next = next.next;
        }

        flipTurn();
    }

    public static void flipTurn(){
        if(turn == Player.ONE)
            turn = Player.TWO;
        else
            turn = Player.ONE;

        pTurn.setValue(turn);
    }
}
