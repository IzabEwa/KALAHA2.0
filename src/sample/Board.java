package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Board extends HBox {

    public Board(){
        super();
        setup();
    }

    public Pit head = null;
    public Pit tail = null;

    public Pit createNode(int pearls, Player owner, boolean house){
        Pit newPit = new Pit(pearls, owner, house);

        if(head == null){
            head = newPit;
            tail = newPit;
            newPit.next = head;
        }else{
            tail.next = newPit;
            tail = newPit;
            tail.next = head;
        }

        return newPit;
    }

    public void setup(){

        GridPane gp = new GridPane();
        gp.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> Kalaha.handleClick(getClosestPit(event.getX(), event.getY())));

        GridPane houseONE = setupHouse(Player.ONE);

        for (int i = 0; i <= 6; i++)
            gp.add(createNode(4, Player.ONE, false), i, 1);

        GridPane houseTWO = setupHouse(Player.TWO);

        for (int i = 6; 0 <= i; i--)
            gp.add(createNode(4, Player.TWO, false), i, 0);

        gp.setHgap(20);
        gp.setVgap(75);
        gp.setPadding(new Insets(0, 10, 0, 10));

        getChildren().addAll(houseONE, gp, houseTWO);
    }

    public GridPane setupHouse(Player player){
        GridPane center = new GridPane();
        center.add(createNode(0, player, true), 0, 0);
        center.setAlignment(Pos.CENTER_LEFT);

        return center;
    }

    public Pit getClosestPit(double x, double y){
        Pit closest = null;
        double delta = Integer.MAX_VALUE;

        Pit toCheck = head;
        do{
            double pitX = toCheck.getLayoutX();
            double pitY = toCheck.getLayoutY();

            double diffX = Math.abs(x - pitX);
            double diffY = Math.abs(y - pitY);
            double diffTotal = diffX + diffY;

            if(diffTotal <= delta){
                delta = diffTotal;
                closest = toCheck;
            }

            toCheck = toCheck.next;
        }while(toCheck.next != head);

        return closest;
    }
}
