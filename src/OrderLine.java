public class OrderLine {
    private int dbNo;
    private String name;
    private int quantity;

    public OrderLine(int dbNo, String name, int quantity) {
        this.dbNo = dbNo;
        this.name = name;
        this.quantity = quantity;
    }

    public int getDbNo() {
        return dbNo;
    }

    public void setDbNo(int dbNo) {
        this.dbNo = dbNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "dbNo=" + dbNo +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
