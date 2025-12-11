import UTIL.FileIO;

import java.util.ArrayList;

public class Product {
    // instans variabel - the variabel are change to private instead of protected 11/12/2025 SF
    private String name;
    private int dbNo;
    private String location;
    FileIO fIO = new FileIO();
    private ArrayList<String> productReadToArraylist = new ArrayList<>();
    private ArrayList<Product> productArraylist = new ArrayList<>();

    public Product() { // this is so we can call the class from other class or from main.
    }

    public Product(int dbNo, String name, String location) {  // constructor
        this.dbNo = dbNo;
        this.name = name;
        this.location = location;
    }

    public Product(int dbNo, String name) { // use to oderline class
        this.dbNo = dbNo;
        this.name = name;
    }

    // we need getter 11/12/2025 SF

    public int getDbNo() {
        return dbNo;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProductArraylist() {
        return productArraylist;
    }

    public void setDbNo(int dbNo) {
        this.dbNo = dbNo;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductArraylist(ArrayList<Product> productArraylist) {
        this.productArraylist = productArraylist;
    }

    /*
    public String toString() {
        return "DB.nr: " + dbNo + ", product name: " + name + ", location: " + location + "\n";
    }

    // metode til at aflæse vores produkt i csv-filen. og laver en arrayList.
    //protected ArrayList<String> readProduktArray(){ // because the metode to make a array is in fileIO
    // we not need that just call and use the methode ind a new metode

    protected ArrayList<Product> readProduktArray() {  // change the method from void to arraylist 11/12/2025 SF
        fIO.readData("data/Products", productReadToArraylist);
        //return null; // indtil videre!!! // not need anymore.

        // we need to split the arraylist so it fit to the Product constructor 11/12/2025 SF
        for (String line : productReadToArraylist) {
            String[] partOfLine = line.split(";");
            int dbNo = Integer.parseInt(partOfLine[0]);
            String name = partOfLine[1];
            String location = partOfLine[2];
            productArraylist.add(new Product(dbNo, name, location));
        }
        return productArraylist;
    }
*/
}


