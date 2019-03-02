import java.util.Comparator;

public class DocumentComparatorByType implements Comparator<Document> {


    @Override
    public int compare(Document o1, Document o2) {
        return o1.getDocumentType().getValue()-o2.getDocumentType().getValue();
    }
}


