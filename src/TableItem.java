public class TableItem {
    private String location;
    private String dbNumber;
    private String description;
    private String quantity;

    // Constructor
    public TableItem(String location, String dbNumber, String description, String quantity) {
        this.location = location;
        this.dbNumber = dbNumber;
        this.description = description;
        this.quantity = quantity;
    }

    // Getter metoder - JavaFX tabellen skal bruge disse!
    public String getLocation() {
        return location;
    }

    public String getDbNumber() {
        return dbNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    // Optional: En metode til at vise data som tekst
    @Override
    public String toString() {
        return location + " | " + dbNumber + " | " + description + " | " + quantity;
    }
}