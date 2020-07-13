package sample;

public class MenuItem {
    private String name;
    private float price;

    //Constructor taking arguments price and name
    public MenuItem(String n, float p){
        name = n;
        price = p;
    }

    //Get Methods
    public float getPrice() { return price;}
    public String getName() {return name;}

    //itemToString Method returning name and price
    public String itemToString(){
        String nameAndPrice = name + " " + String.format("%,1.2f",price);
        return nameAndPrice;
    }

}