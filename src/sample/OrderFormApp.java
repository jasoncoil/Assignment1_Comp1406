package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class OrderFormApp extends Application{
    private Menu newMenu;
    private OrderForm myPanel;

    public void start(Stage primaryStage) throws FileNotFoundException {
        newMenu = new Menu("file.txt");
        myPanel = new OrderForm(newMenu);
        primaryStage.setTitle("View Test");
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(myPanel, 285,380));
        primaryStage.show();



        //Key Press Action Event (TextField)
        for(int i =0;i<myPanel.getLabelList().size();i++){
            myPanel.getQuantityBox(i).setOnKeyReleased(new EventHandler<javafx.scene.input.KeyEvent>(){
                public void handle(KeyEvent ke){ handleTextFieldKeyPress(); } });
        }
    }

    //Handle the inserting integers into Textfield event
    private void handleTextFieldKeyPress(){
            myPanel.update();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
