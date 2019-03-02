import java.util.Comparator;

public class DocumentComparatorByDuration implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        return o1.getPrintduration()-o2.getPrintduration();
    }
}
