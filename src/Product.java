import UTIL.FileIO;
import java.util.ArrayList;

public abstract class Product {
    // instans variabel
    protected String name;
    protected int dbNo;
    protected String location;
    FileIO fIO = new FileIO();
    protected ArrayList<String> produktArraylist = new ArrayList<>();


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
    //protected ArrayList<String> readProduktArray(){ // because the metode to make a array is in fileIO
    // we not need that just call and use the methode ind a new metode

    protected void readProduktArray(){
        fIO.readData("data/Products",produktArraylist);

        //return null; // indtil videre!!! // not need anymore.
    }

}
