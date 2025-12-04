public class OrderLine extends Product{
    private String product;
    private int quanity;


    public OrderLine(int dbNo, String name, String product, int quanity) {
        super(name, dbNo);
        this.product = product;
        this.quanity = quanity;
    }

    // getter methode
    public String getProduct() {
        return product;
    }
    // setter methode
    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuanity() {
        return quanity;
    }
    // setter methode
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
}
