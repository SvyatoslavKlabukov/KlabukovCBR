import java.util.Comparator;

public class DocumentComparatorByFormat implements Comparator<Document> {
    @Override
    public int compare(Document o1, Document o2) {
        return o1.getFormat().getValue()-o2.getFormat().getValue();
    }
}
