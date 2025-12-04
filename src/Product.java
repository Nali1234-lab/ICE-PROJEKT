public abstract class Product {
    // instans variabel
    protected String name;
    protected int dbNo;
    protected String location;

    Product(int dbNo, String name, String location) {  // constructor
        this.dbNo = dbNo;
        this.name = name;
        this.location = location;
    }

    Product(String name, int dbNo) {
        this.name = name;
        this.dbNo = dbNo;
    }
}
