import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class PickListApp extends Application {
    private Order order = new Order();
    private TextField dateInput = new TextField();
    private TableView<TableItem> tableView = new TableView<>();
    private Product product = new Product();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Warehouse PickList");

        // 1. Input field
        Label dateLabel = new Label("Enter date (fx.: 12/05/2025):"); // text over the field
        dateInput.setPrefWidth(150); // the field to input.

        // 2. Button
        Button showButton = new Button("Show PickList");
        showButton.setOnAction(e -> showPickList());

        // 3. Setup table
        setupTable();

        // 4. Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                dateLabel,
                dateInput,
                showButton,
                new Separator(),
                tableView
        );

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void setupTable() {
        // Create 4 columns
        TableColumn<TableItem, String> locationCol = new TableColumn<>("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationCol.setPrefWidth(100);

        TableColumn<TableItem, String> dbCol = new TableColumn<>("DB Number");
        dbCol.setCellValueFactory(new PropertyValueFactory<>("dbNumber"));
        dbCol.setPrefWidth(100);

        TableColumn<TableItem, String> descCol = new TableColumn<>("Description");
        descCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descCol.setPrefWidth(200);

        TableColumn<TableItem, String> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        qtyCol.setPrefWidth(80);

        // Add columns to table
        tableView.getColumns().addAll(locationCol, dbCol, descCol, qtyCol);
        tableView.setPrefHeight(350);
    }

    private void showPickList() {
        String date = dateInput.getText().trim();

        if (date.isEmpty()) {
            showAlert("Please enter a date!"); // pop up window to the user tell what is wrong
            return;
        }

        try {
            // 1. Get data from Order class
            order.testDato = date + " ";
            order.runOrdreMethod(date);

            //ArrayList<OrderLine> rawData = order.orderListPart4();

            // 2. Convert to TableItem objects
            ObservableList<TableItem> tableData = FXCollections.observableArrayList();

           /* for (OrderLine rawItem : rawData) {
                TableItem item = createTableItem(rawItem);
                tableData.add(item);
            }
*/
            OrderPicker orderPicker = new OrderPicker(product,order);
            ArrayList<TableItem> tableItems = orderPicker.getOrderlinesWithLocation();

            for (TableItem tableItem : tableItems) {
                tableData.add(tableItem);
            }

            // 3. Show in table
            tableView.setItems(tableData);

        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
        }
    }

    private TableItem createTableItem(String rawItem) {
        // Example rawItem: "748999Stiksav1"

        // Parse DB number (first 6 characters)
        String dbNumber = rawItem.substring(0, 6);

        // The rest is description + quantity
        String rest = rawItem.substring(6);

        // Find quantity (last number(s))
        String quantity = "";
        String description = "";

        // Go backwards to find all numbers at the end
        for (int i = rest.length() - 1; i >= 0; i--) {
            char c = rest.charAt(i);
            if (Character.isDigit(c)) {
                quantity = c + quantity;
            } else {
                description = rest.substring(0, i + 1);
                break;
            }
        }

        // For now, use "?" as placeholder
        String location = "?";

        // Create and return a TableItem object

        return new TableItem(location, Integer.parseInt(dbNumber), description, Integer.parseInt(quantity));
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }
}