import UTIL.FileIO;

import java.util.ArrayList;

public class Order {  // name shall change to Orders
    private String date;
    private long orderNo;
    private long customerNo;
    public ArrayList<String> ordreLines; // changed from int quanityOrdered to Arraylist ordreLines
    public ArrayList<String> orderListArraylist = new ArrayList<>();
    public ArrayList<String> orderlineWithDate = new ArrayList<>();
    public ArrayList<String> orderlineSortByDate = new ArrayList<>();
    public ArrayList<String> orderlinesForDate = new ArrayList<>();

    public ArrayList<String> orderlineSplitType = new ArrayList<>();
    FileIO fio = new FileIO();

   // public String testDato = "12/05/2025 ";

    public Order() {

    }

    // constructor
    public Order(long customerNo, String date, long orderNo, ArrayList<String> ordreLines) {
        this.customerNo = customerNo;
        this.date = date;
        this.orderNo = orderNo;
        this.ordreLines = ordreLines;
    }

    public void runOrdreMethod(String datoInput) {
        orderListPart1();
        orderListPart2(datoInput);
        orderListPart3();
        orderListPart4();
    }


    /* OrdreList()
     metode som kalder på aflæsning af fil og laver et arraylist med de ønskede data
    */

    // Found out there are more steps in that so have split up in 4 parts


    // Part 1 read the order file and make an Arraylist for that and after that make a split so we just take the needed part.
    // the new split version adds to a new arraylist.

    public ArrayList<String> orderListPart1() {  // this method read the dokument of ordre an take the date an the orderlines and put to a new arraylist.
        fio.readData("data/Order", orderListArraylist); // reading only the data and put it on a arraylist.
        // stil need to sort the String, and we want only the last part of the String to make a new Arraylist with

        for (String line : orderListArraylist) {
            String[] partOfLine = line.split(";"); // this tell the string to split up between ; and make et to a String
            if (partOfLine.length == 4) {
                String getDate = partOfLine[1]; // take dato from orderListArraylist
                String getOdreline = partOfLine[3]; // take the odreline
                orderlineWithDate.add(getDate + getOdreline); // put them into a new arraylist
            }
        }
        return orderlineWithDate;
    }

    // this part split and the arraylist from part 1 and make the date been avaibel to search for.
    // it also takes the wanted line for the wanted date into a new arraylist
    public ArrayList<String> orderListPart2(String datoInput) {
        for (String line : orderlineWithDate) {
            String[] partOfLine = line.split("#");
            String dato = partOfLine[0];
            String ordrelines = partOfLine[1];
            if (dato.equals(datoInput)) {
                orderlineSortByDate.add(ordrelines);
            }
        }
        return orderlineSortByDate;
    }

    // this part split up the ordreline if there are more than just one
    // so we get a new list again with ordrelines there not are on the same line.
    public ArrayList<String> orderListPart3() {
        for (String line : orderlineSortByDate) {
            String[] partOfLine = line.split("&");
            for (String ordreline : partOfLine) {
                orderlinesForDate.add(ordreline.trim()); // use trim means we not need to set index nr. it hard to say if people order 1 og 10 things
            }
        }
        return orderlinesForDate;
    }

    // the last make the arraylist for the split with types so we will now have an arraylist with (int, string, int)
    public ArrayList<OrderLine> orderListPart4() {
        ArrayList<OrderLine> orderlines = new ArrayList<>();

        for (String line : orderlinesForDate) {

            String[] partofLine = line.split("¨");

            int dbNo = Integer.parseInt(partofLine[0]);
            String name = partofLine[1];
            int quanityOrdered = Integer.parseInt(partofLine[2]);

            OrderLine orderLine = new OrderLine(dbNo, name, quanityOrdered);

            orderlines.add(orderLine);
        }
        return orderlines;
    }
}
     /* (checkProduct). // metode rykket til OderPicker
    en metode som samligner vores db.no. med vores produkt-list.
    returner product-fulde-information + quantity+dato.
    // if (produktArraylist countains(dbNo)
    //
    (totalSimilarProducts).
    (klad på checkProduct).
     en metode som lægger ens produkter sammen.
     laver vores pluklist.
    */
