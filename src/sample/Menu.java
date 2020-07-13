package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<MenuItem> item;

    //Creating constructor which accepts arraylist of menuitem
    public Menu(ArrayList<MenuItem> i){
        item = i;
    }
    //Constructor taking a string
    public Menu(String filename) throws FileNotFoundException {
        Scanner textfile = new Scanner(new File(filename));
        item = new ArrayList<>(1);
        while(textfile.hasNext()){
            MenuItem singleitem = new MenuItem(textfile.next(),Float.parseFloat(textfile.next()));
            item.add(singleitem);
        }
    }

    //Method printMenu - prints the whole menu
    public void printMenu(){
        for(int i = 0; i < item.size();i++){
            System.out.println(i+1 + ") " + item.get(i).itemToString());
        }
    }

    //Method size - tells the user how many items on the menu
    public Integer size(){ return item.size(); }

    //Method getItem - returns the specific item on the list according to integer input
    public MenuItem getItem(int i){ return item.get(i); }


}
