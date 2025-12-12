import UTIL.TextUI;

import java.time.format.TextStyle;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

       // call all class there will be use and method.
        TextUI tui = new TextUI();
        String userInput = tui.promptText();

        Order order = new Order();
        Product product = new Product();
        OrderPicker orderPicker = new OrderPicker(product,order);
        order.runOrdreMethod(userInput);
        product.readProduktArray();
        orderPicker.getOrderlinesWithLocation();


        for ( TableItem line : orderPicker.sortPickList()){
            System.out.println(line);
        }

    }

}


/*
  // methode call from PickList


 Test:
        Order order = new Order();
        for(String line : order.orderlineWithDate);
        System.out.println(order.orderListPart1());
        System.out.println("\n");

        for(String line1 : order.orderlineSortByDate);
        System.out.println(order.orderListPart2("12/05/2025"));
        System.out.println("\n");

        System.out.println(order.orderListPart3());
        System.out.println("\n");

        for(String line1 : order.orderlineSplitType);
        System.out.println(order.orderListPart4());


        Product product = new Product();
        for (Product line : product.getProductArraylist());
       System.out.println(product.readProduktArray());

        System.out.println("\n test");

       OrderPicker orderPicker = new OrderPicker(product,order);
        ArrayList<TableItem> tableItems = orderPicker.getOrderlinesWithLocation();

        for ( TableItem tableItem : tableItems){
            System.out.println(tableItem);
        }

        //System.out.println("test2");
        //System.out.println(orderPicker.totalSimilarProducts());


        System.out.println("\n endelig test \n");
        System.out.println(orderPicker.sortPickList());
*/