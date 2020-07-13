package sample;

import java.io.File;
import java.io.FileNotFoundException;

public class MenuTest {
    public static void main(String args[]) throws FileNotFoundException {
        Menu menuItemArray = new Menu("file.txt");
        Order orderOne = new Order();
        Cashier cashierOne = new Cashier(menuItemArray);
        //Testing Menu Class
        System.out.println("Testing The printMenu method");
        menuItemArray.printMenu();
        System.out.println("Testing The size method: " +  menuItemArray.size());
        System.out.println("Testing The getItem method: " +  menuItemArray.getItem(2));

        //Testing Order Class
        orderOne.add(menuItemArray.getItem(3),1);
        orderOne.add(menuItemArray.getItem(4),2);
        System.out.println("Testing The getSubTotal method: " + String.format("%,1.2f",orderOne.getSubTotal()));
        System.out.println("Testing The getTaxes method: " + orderOne.getTaxes());
        System.out.println("Testing The getTotal method: " + orderOne.getTotal());
        System.out.println("Testing The orderToString method: " + "\n" + orderOne.orderToString());

//        //Testing Cashier Class
//        cashierOne.takeOrder();
//
//        //Testing Restaraunt Class
//        Restaraunt jasonsRestaraunt = new Restaraunt();
//        jasonsRestaraunt.main();
    }
}
