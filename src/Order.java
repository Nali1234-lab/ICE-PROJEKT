import java.util.ArrayList;

public class Order {
    private String date;
    private long orderNo;
    private long customerNo;
    private ArrayList<String> ordreLines; // changed from int quanityOrdered to Arraylist ordreLines


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
