package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Pit extends TextField {
    SimpleIntegerProperty pearls;
    Pit next;
    Player owner;
    boolean house;

    public Pit(int spearls, Player owner, boolean house){
        this.pearls = new SimpleIntegerProperty(spearls);
        this.owner = owner;
        this.house = house;

        setPrefWidth(25);
        textProperty().bind(pearls.asString());
    }

    public void setPearls(int set){
        pearls.set(set);
    }
}
