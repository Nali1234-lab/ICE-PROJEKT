import java.util.ArrayList;
import java.util.List;

public class OrderPicker {

    private Product product;
    private Order order;

    public OrderPicker(Product product , Order order)
{
        this.product = product;
        this.order = order;
    }

    ArrayList<TableItem> getOrderlinesWithLocation(){
        ArrayList<Product> products = product.getProductArraylist();
        ArrayList<OrderLine> orderLines = order.orderListPart4();

        ArrayList<TableItem> tableItems = new ArrayList<>();

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
}
