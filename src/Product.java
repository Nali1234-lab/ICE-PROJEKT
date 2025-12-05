import UTIL.FileIO;
import java.util.ArrayList;

public abstract class Product {
    // instans variabel
    protected String name;
    protected int dbNo;
    protected String location;
    FileIO fIO = new FileIO();

    Product(int dbNo, String name, String location) {  // constructor
        this.dbNo = dbNo;
        this.name = name;
        this.location = location;
    }

    Product(String name, int dbNo) {
        this.name = name;
        this.dbNo = dbNo;
    }
    // metode til at aflæse vores produkt i csv-filen. og laver en arrayList.
    protected ArrayList<String> readProduktArray(){
        fIO.readData("data/Products");

        return null; // indtil videre!!!
    }

}
