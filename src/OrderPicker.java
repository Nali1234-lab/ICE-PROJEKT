import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.sort;

public class OrderPicker {

    private Product product;
    private Order order;
    public  ArrayList<TableItem> tableItems = new ArrayList<>(); // name shall change

    public HashMap<Integer,TableItem> totalQuantety = new HashMap<>(); // we want the hashmap to work with numbers so we use Integer.
    public LocationComparator locationComparator = new LocationComparator();
    public ArrayList<TableItem> finalPickList;

    public OrderPicker(Product product , Order order){
        this.product = product;
        this.order = order;
    }

    ArrayList<TableItem> getOrderlinesWithLocation(){
        ArrayList<Product> products = product.getProductArraylist();
        ArrayList<OrderLine> orderLines = order.orderListPart4();

        // ArrayList<TableItem> tableItems = new ArrayList<>(); movie this to global

        for(Product product: products)
        {
            for(OrderLine orderLine: orderLines){

            if(orderLine.getDbNo() == product.getDbNo()){
                TableItem tableItem = new TableItem(product.getLocation(), product.getDbNo(), product.getName(), orderLine.getQuantity());
                tableItems.add(tableItem);
            }
            }
        }

        return tableItems;
    }

    // metode der tager tableItems arraylisten og tjekker efter hvor dbNo gentager sig og samler linjerne til 1 og ligger quantity sammen.

    public ArrayList<TableItem> totalSimilarProducts(){

        for (TableItem line : tableItems){ // make a forloop so it run all lines in the arraylist
            int dbNo = line.getDbNumber(); // give a shorter name to use.

            if(totalQuantety.containsKey(dbNo)){ //
                TableItem dbNoMatch = totalQuantety.get(dbNo);
                dbNoMatch.setQuantity(dbNoMatch.getQuantity() + line.getQuantity());
            } else {
                totalQuantety.put(dbNo, new TableItem(line.getLocation(),dbNo,line.getDescription(),line.getQuantity()));
            }

        }
        return new ArrayList<>(totalQuantety.values());
    }

    // make a method there sort the arraylist by location orden.
    public ArrayList<TableItem> sortPickList(){
        finalPickList = totalSimilarProducts(); // we say the final Picklist is the same as the method from before so
                                                // it run that an give an arraylist it can sort.
        finalPickList.sort(locationComparator); // we use the LocationComporator class to sort the after the location.
       return finalPickList;    // and return a finally pickList.
    }

}
