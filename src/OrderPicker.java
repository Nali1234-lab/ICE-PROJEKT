import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.sort;

public class OrderPicker {

    private Product product;
    private Order order;
    public  ArrayList<PickListLine> pickListLines = new ArrayList<>(); // name shall change

    public HashMap<Integer, PickListLine> totalQuantety = new HashMap<>(); // we want the hashmap to work with numbers so we use Integer.
    public LocationComparator locationComparator = new LocationComparator();
    public ArrayList<PickListLine> finalPickList;

    public OrderPicker(Product product , Order order){
        this.product = product;
        this.order = order;
    }

    public ArrayList<PickListLine> getOrderlinesWithLocation(){
        ArrayList<Product> products = product.getProductArraylist();
        ArrayList<OrderLine> orderLines = order.orderListPart4();

        // ArrayList<TableItem> tableItems = new ArrayList<>(); movie this to global

        for(Product product: products)
        {
            for(OrderLine orderLine: orderLines){

            if(orderLine.getDbNo() == product.getDbNo()){
                PickListLine pickListLine = new PickListLine(product.getLocation(), product.getDbNo(), product.getName(), orderLine.getQuantity());
                pickListLines.add(pickListLine);
            }
            }
        }

        return pickListLines;
    }

    // metode der tager tableItems arraylisten og tjekker efter hvor dbNo gentager sig og samler linjerne til 1 og ligger quantity sammen.

    public ArrayList<PickListLine> totalSimilarProducts(){

        for (PickListLine line : pickListLines){ // make a forloop so it run all lines in the arraylist
            int dbNo = line.getDbNo(); // give a shorter name to use.

            if(totalQuantety.containsKey(dbNo)){ //
                PickListLine dbNoMatch = totalQuantety.get(dbNo);
                dbNoMatch.setQuantity(dbNoMatch.getQuantity() + line.getQuantity());
            } else {
                totalQuantety.put(dbNo, new PickListLine(line.getLocation(),dbNo,line.getName(),line.getQuantity()));
            }

        }
        return new ArrayList<>(totalQuantety.values());
    }

    // make a method there sort the arraylist by location orden.
    public ArrayList<PickListLine> sortPickList(){
        finalPickList = totalSimilarProducts(); // we say the final Picklist is the same as the method from before so
                                                // it run that an give an arraylist it can sort.
        finalPickList.sort(locationComparator); // we use the LocationComporator class to sort the after the location.
       return finalPickList;    // and return a finally pickList.
    }

}
