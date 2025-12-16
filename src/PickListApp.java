import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*; // UI controls (buttons, tables, etc.)
import javafx.scene.control.cell.PropertyValueFactory; // Links table columns to object properties
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PickListApp extends Application {
    private Order order = new Order();
    private TextField dateInput = new TextField();
    private TableView<PickListLine> tableView = new TableView<>(); // Displays picklist data
    private Product product = new Product();
    private OrderPicker orderPicker;
    private boolean hasShownPickList = false; // Flag: picklist already shown

    /*public static void main(String[] args) {
        launch(args);
    }*/

    @Override
    public void start(Stage stage) {
        stage.setTitle("Warehouse PickList");// Window title

        // Input field
        Label dateLabel = new Label("Enter date (mm/dd/yyyy):"); // text over the field
        dateInput.setPrefWidth(150); // Set field

        //  Button
        Button showButton = new Button("Show PickList");// Action button
        showButton.setOnAction(e -> showPickList());  // Button click handler

        // Setup table
        setupTable();

        //  Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll( // Add all UI elements
                dateLabel,
                dateInput,
                showButton,
                new Separator(),
                tableView
        );

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene); // Add scene to window
        stage.show(); // Display window
    }

    private void setupTable() {
        // Create 4 columns
        TableColumn<PickListLine, String> locationCol = new TableColumn<>("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        locationCol.setPrefWidth(100);

        TableColumn<PickListLine, String> dbCol = new TableColumn<>("DB Number");
        dbCol.setCellValueFactory(new PropertyValueFactory<>("dbNo"));
        dbCol.setPrefWidth(100);

        TableColumn<PickListLine, String> descCol = new TableColumn<>("Description");
        descCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        descCol.setPrefWidth(200);

        TableColumn<PickListLine, String> qtyCol = new TableColumn<>("Quantity");
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        qtyCol.setPrefWidth(80);

        // Add columns to table
        tableView.getColumns().addAll(locationCol, dbCol, descCol, qtyCol);
        tableView.setPrefHeight(335); // Set table height
    }

    private void showPickList() {

        String date = dateInput.getText().trim(); //user input

        if (date.isEmpty()) {
            showAlert("Please enter a date!"); // pop up window to the user tell what is wrong
            return;
        }

        if (hasShownPickList) {
            showAlert("PickList has already been shown!");
            return;
        }

        try {
            // empty tables first
            tableView.getItems().clear();
            // Get data from Order class

            order.runOrdreMethod(date);

            // Read product data
            product.readProduktArray();

            // Opret OrderPicker
            orderPicker = new OrderPicker(product, order);

            // Get data with locations
            orderPicker.getOrderlinesWithLocation();

            // Get the sorted list (this method calls totalSimilarProducts() and sorts)
            ArrayList<PickListLine> pickListLines = orderPicker.sortPickList();

            // Convert to TableItem objects
            ObservableList<PickListLine> tableData = FXCollections.observableArrayList();

            tableData.addAll(pickListLines);
            tableView.setItems(tableData);

            hasShownPickList = true;
            if (pickListLines.isEmpty()) {
                showAlert("No orders found for date: " + date);
            }

        } catch (Exception e) {
            showAlert("Error: " + e.getMessage());
        }
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(message);
        alert.showAndWait();
    }
}

/*1-

 this method was for testing javafx,before recive all code to use.
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


           /for (TableItem tableItem : tableItems) {
                tableData.add(tableItem);
            }

// 2- Show in table
//tableView.setItems(tableData);*/

      /* for (OrderLine rawItem : rawData) {
                TableItem item = createTableItem(rawItem);
                tableData.add(item);
            }
*/

//3- ArrayList<OrderLine> rawData = order.orderListPart4();

//4- order.testDato = date + " ";