public class OrderLine extends Product{

    private int quanity;

    public OrderLine(int dbNo, String name, int quanity) {
        super(name, dbNo);

        this.quanity = quanity;
    }





    public int getQuanity() {
        return quanity;
    }
    // setter methode
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
}
