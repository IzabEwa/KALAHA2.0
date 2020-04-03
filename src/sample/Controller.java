package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controller extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {


        Pane pane = new Pane();
        Board board = new Board();
        pane.getChildren().add(board);

        Label kalaha = new Label("KALAHA");
        kalaha.setLayoutX(110);
        kalaha.setLayoutY(35);
        kalaha.setFont(new Font("Verdana", 36));
        kalaha.setTextFill(Color.LIGHTGRAY);
        pane.getChildren().add(kalaha);

        Label turn = new Label();
        turn.textProperty().bind(Bindings.concat("Player turn: ").concat(Kalaha.pTurn.asString()));
        turn.setLayoutX(125);
        turn.setLayoutY(125);
        turn.setFont(new Font("Verdana", 14));
        turn.setTextFill(Color.LIGHTGRAY);
        pane.getChildren().add(turn);

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kalaha");
        primaryStage.show();

        System.out.println(System.getProperty("javafx.runtime.version"));
        pane.setStyle("-fx-background-color:   darkcyan");
    }



}
