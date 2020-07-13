package sample;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items;
    private ArrayList<Integer> quantities;

    //Zero input Constructor
    public Order(){
        items = new ArrayList<MenuItem>(0);
        quantities = new ArrayList<Integer>(0);
    }

    //Method Add - takes an order of input item and quantity
    public void add(MenuItem food,Integer quantity){
        int isOrderedAlready = 0; //0 = false, 1 = true
        int itemLocation = 0;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == food){
                isOrderedAlready = 1;
                itemLocation = i;
            }
        }
        if(isOrderedAlready == 0){
            items.add(food);
            quantities.add(quantity);
        }
        else {
            quantities.add(quantities.get(itemLocation) + quantity);
        }
    }

    //Method getSubTotal - returns the total cost of the order before taxes
    public float getSubTotal(){
        float totalSubCost = 0;
        for(int i =0; i < items.size();i++){
            totalSubCost = totalSubCost + quantities.get(i)*items.get(i).getPrice();
        }
        return totalSubCost;
    }
    //Method getTaxes - Returns the 15% of the subTotal value
    public String getTaxes(){
        return String.format("%1.2f",getSubTotal()*0.15f);
    }

    //Method getTotal - returns the total cost of the order including taxes
    public String getTotal(){ return String.format("%1.2f",Float.parseFloat(getTaxes()) + getSubTotal()); }

    //Method orderToString - returns the items ordered with the quantity, returns the subtotal, taxes, and total all in one list
    public String orderToString(){
        String receipt = new String();
        for(int i=0; i < items.size();i++)
            receipt = receipt + items.get(i).getName() + " " + items.get(i).getPrice() + " x " + quantities.get(i) + "\n";
        receipt = receipt + "Sub-Total: " + (getSubTotal()) + "\n";
        receipt = receipt + "Taxes: " + (getTaxes()) + "\n";
        receipt = receipt + "Total: " + (getTotal());
        return receipt;
    }
}
