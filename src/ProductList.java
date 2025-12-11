import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductList {

    public static Map<String, Product> productlist() {
        Map<String, Product> map = new HashMap<>();
        {
            try {
                File alleVareFil = new File("data/Products");
                Scanner scanner = new Scanner(alleVareFil);

                if (scanner.hasNextLine()) {
                    scanner.nextLine();

                }
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] partOfLine = line.split(";");
                    int dbNo = Integer.parseInt(partOfLine[0]);
                    String name = partOfLine[1];
                    String location = partOfLine[2];

                    Product product = new Product(dbNo, name, location);
                   // map.put() !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
            return map;
        }
    }
}
