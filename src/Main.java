import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String userInput;

        // methode call from PickList

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
    }
}
