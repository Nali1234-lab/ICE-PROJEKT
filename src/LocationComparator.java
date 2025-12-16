import java.util.Comparator;

public class LocationComparator implements Comparator<PickListLine> {

    public int compare(PickListLine l1, PickListLine l2){
        return CharSequence.compare(l1.getLocation(), l2.getLocation());
    }
}
