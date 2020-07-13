package sample;
import java.io.FileNotFoundException;
public class Restaraunt {

   //Method Main
    public void main() throws FileNotFoundException{
        Menu restarauntMenu = new Menu("file.txt");
        Cashier restarauntCashier = new Cashier(restarauntMenu);
        restarauntCashier.takeOrder();
    }
}
