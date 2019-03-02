import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Document doc1 = new Document(DocumentType.LETTER, Format.A5, 2, "Первый документ");
        Document doc2 = new Document(DocumentType.ESSEY, Format.A4, 1, "эссе");
        Document doc3 = new Document(DocumentType.PRESENTATION, Format.A3, 3, "Презентация");
        Document doc4 = new Document(DocumentType.PRESENTATION, Format.A3, 3, "Презентация2");

        PrintManager printManager = new PrintManager();
        ArrayList <Document> docs = new ArrayList<Document>();
        docs.add(doc3);
        docs.add(doc2);
        docs.add(doc1);
        printManager.start(docs);
        printManager.addToPrint(doc4);

        boolean isWorking = true;
        while (isWorking) {
            boolean isStarted = printManager.isStarted();
            System.out.println("");
            if (!isStarted){
                for (Document documents:printManager.getPrintedDocuments(SortType.PRINTORDER)) {
                    System.out.println(documents.getContents());
                }
            System.out.println("Среднее время " + printManager.getAveragePrintDuration());
            isWorking=false;
            }
        }
    }
}
