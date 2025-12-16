public class PickListLine { // change name to Picklist
    private String location;
    private int dbNo; // change name to dbNo
    private String name; // change to name
    private int quantity;

    // Constructor
    public PickListLine(String location, int dbNo, String name, int quantity) {
        this.location = location;
        this.dbNo = dbNo;
        this.name = name;
        this.quantity = quantity;
    }
    public PickListLine(){

    }

    // Getter metoder - JavaFX tabellen skal bruge disse!
    public String getLocation() {
        return location;
    }

    public int getDbNo() {
        return dbNo;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Optional: En metode til at vise data som tekst
    @Override
    public String toString() {
        return location + " | " + dbNo + " | " + name + " | " + quantity;
    }
}