public class TableItem { // change name to Picklist
    private String location;
    private int dbNumber; // change name to dbNo
    private String description; // change to name
    private int quantity;

    // Constructor
    public TableItem(String location, int dbNumber, String description, int quantity) {
        this.location = location;
        this.dbNumber = dbNumber;
        this.description = description;
        this.quantity = quantity;
    }
    public TableItem(){

    }

    // Getter metoder - JavaFX tabellen skal bruge disse!
    public String getLocation() {
        return location;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public String getDescription() {
        return description;
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
        return location + " | " + dbNumber + " | " + description + " | " + quantity;
    }
}