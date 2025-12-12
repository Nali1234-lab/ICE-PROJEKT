import java.util.Comparator;

public class LocationComparator implements Comparator<TableItem> {

    public int compare(TableItem l1, TableItem l2){
        return CharSequence.compare(l1.getLocation(), l2.getLocation());
    }
}
