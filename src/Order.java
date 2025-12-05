import java.util.ArrayList;

public class Order {
    private String dato;
    private long orderNo;
    private long customerNo;
    private ArrayList<String> ordreLines; // changed from int quanityOrdered to Arraylist ordreLines


    // constructor
    public Order(long customerNo, String dato, long orderNo, ArrayList<String> ordreLines) {
        this.customerNo = customerNo;
        this.dato = dato;
        this.orderNo = orderNo;
        this.ordreLines = ordreLines;
    }

    // OrdreList()
    // metode som kalder på aflæsning af fil og laver et arraylist med de ønskede data

}
