package sample;

import java.util.Scanner;

public class Cashier {
    private Menu menu;

    //Constructor taking menu as input
    public Cashier(Menu m){
        menu = m;
    }

    //Method printListOfCommands -- asks customer what he wants, prints menu, and instructs user how to end his order
    private void printListOfCommands(){
        System.out.println("What would you like to order?");
        menu.printMenu();
        System.out.println("Press 8 when you are finished");
    }

    //Method readNextCommand -- reads the next integer input by the user and returns it
    private Integer readNextCommand(){
        Scanner scan = new Scanner(System.in);
        int orderNumber = scan.nextInt();
        return orderNumber;
    }

    //Method askForQuantity -- which asks user for quantity of order and then returns that quantity
    private Integer askForQuantity(){
        System.out.println("How many do you want?");
        Scanner scan = new Scanner(System.in);
        int orderQuantity = scan.nextInt();
        return orderQuantity;
    }

    //Method takeOrder -- using all the above methods, it will take the order of the customer
    //taking the menu number and quantity, until the user presses 8 to signal the end of his/her order
    public void takeOrder(){
        System.out.println("Welcome to Jason's Food Truck Extravaganza! Where the Food is Fresh and the Love is Genuine");
        printListOfCommands();
        Order specificOrder = new Order();
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while(i < 1){
            int nextOrder = readNextCommand();
            if(nextOrder != 8) {
                specificOrder.add(menu.getItem(nextOrder), askForQuantity());
                System.out.println("Would you like to order anything else? If so:");
                printListOfCommands();
            }
            else
                i = 2;
        }
        System.out.println(specificOrder.orderToString());
    }
}
