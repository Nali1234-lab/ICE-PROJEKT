public class TableItem {
    private String location;
    private int dbNumber;
    private String description;
    private int quantity;

    // Constructor
    public TableItem(String location, int dbNumber, String description, int quantity) {
        this.location = location;
        this.dbNumber = dbNumber;
        this.description = description;
        this.quantity = quantity;
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

    // Optional: En metode til at vise data som tekst
    @Override
    public String toString() {
        return location + " | " + dbNumber + " | " + description + " | " + quantity;
    }
}