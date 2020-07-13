package sample;

import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class OrderForm extends Pane {
    //Creating the user interface components
    private List<Label> labels = new ArrayList<>();
    private List<TextField> quantityBoxes = new ArrayList<>();
    private Label subTotal;
    private TextField subTotalDisplay;
    private Label taxes;
    private TextField taxesDisplay;
    private Label total;
    private TextField totalDisplay;
    private Menu specificMenu;


    //Constructor taking menu as an argument
    public OrderForm(Menu m){
        for(int i =0; i < m.size(); i++){
            labels.add(new Label());
            labels.get(i).setText(m.getItem(i).itemToString());
            labels.get(i).relocate(10,30*i+10);
            labels.get(i).setPrefSize(100,20);
            quantityBoxes.add(new TextField());
            quantityBoxes.get(i).relocate(150,30*i + 10);
            quantityBoxes.get(i).setPrefSize(50,20);
            getChildren().add(labels.get(i));
            getChildren().add(quantityBoxes.get(i));
        }
        subTotal = new Label("SubTotal");
        subTotal.relocate(10,30*m.size()+10);
        subTotal.setPrefSize(100,20);
        subTotalDisplay = new TextField();
        subTotalDisplay.relocate(150,30*m.size()+10);
        subTotalDisplay.setPrefSize(50,20);
        subTotalDisplay.setEditable(false);

        taxes = new Label("Taxes");
        taxes.relocate(10,30*m.size()+40);
        taxes.setPrefSize(100,20);
        taxesDisplay = new TextField();
        taxesDisplay.relocate(150,30*m.size()+40);
        taxesDisplay.setPrefSize(50,20);
        taxesDisplay.setEditable(false);

        total = new Label("Total");
        total.relocate(10,30*m.size()+70);
        total.setPrefSize(100,20);
        totalDisplay = new TextField();
        totalDisplay.relocate(150,30*m.size()+70);
        totalDisplay.setPrefSize(50,20);
        totalDisplay.setEditable(false);

        getChildren().addAll(subTotal,subTotalDisplay,taxes,taxesDisplay,total,totalDisplay);
        specificMenu = m;
        update();
    }

    //Get Method for LabelsArray
    public List<Label> getLabelList(){return labels;}
    //Get Methods for Labels
    public Label getLabel(int i){return labels.get(i);}
    //Get Methods for TextFields (quantityBoxes)
    public TextField getQuantityBox(int i){return quantityBoxes.get(i);}

    //Method to check if value in the quantityBoxes are integers or strings
    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    //Update method that will update the current subtotal,taxes, and Total of the order
    public void update(){
        float subTotalPrice = 0;
        for(int i = 0; i<labels.size();i++){
            if(quantityBoxes.get(i).getText().length() > 0 && isStringInt(quantityBoxes.get(i).getText()))
                subTotalPrice = subTotalPrice + specificMenu.getItem(i).getPrice()*Integer.parseInt(quantityBoxes.get(i).getText());
        }
        subTotalDisplay.setText(String.format("%1.2f",subTotalPrice));
        taxesDisplay.setText(String.format("%1.2f",subTotalPrice*0.15f));
        totalDisplay.setText(String.format("%1.2f",subTotalPrice*0.15f + subTotalPrice));
    }


}
