import UTIL.FileIO;

import java.util.ArrayList;

public class Order {
    private String date;
    private long orderNo;
    private long customerNo;
    private ArrayList<String> ordreLines; // changed from int quanityOrdered to Arraylist ordreLines
    private ArrayList<String> ordreListArraylist = new ArrayList<>();
    FileIO fio = new FileIO();

    // constructor
    public Order(long customerNo, String date, long orderNo, ArrayList<String> ordreLines) {
        this.customerNo = customerNo;
        this.date = date;
        this.orderNo = orderNo;
        this.ordreLines = ordreLines;
    }

    /* OrdreList()
     metode som kalder på aflæsning af fil og laver et arraylist med de ønskede data
    */
    private void ordreList() {
        fio.readData("data/Order", ordreListArraylist); // reading only the data and put it on a arraylist.

        // stil need to sort the String.
    }

     /* (checkProduct).
    en metode som samligner vores db.no. med vores produkt-list.
    returner product-fulde-information + quantity+dato.
    */


    /* (totalSimilarProducts).
    (klad på checkProduct).
     en metode som lægger ens produkter sammen.
     laver vores pluklist.
    */




}
