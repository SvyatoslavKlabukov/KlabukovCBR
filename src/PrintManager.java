import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintManager {
    private boolean isStarted = false;
    private boolean isExecuting = false;
    private Thread background;
    private ArrayList<Document> printQueue;
    private ArrayList<Document> printedDocuments;

    public boolean isStarted() {
        return isStarted;
    }

    public PrintManager() {
        printQueue = new ArrayList<Document>();
        printedDocuments = new ArrayList<Document>();
    }

    public ArrayList<Document> stop(){
        isStarted = false;
        ArrayList<Document> notPrinted = (ArrayList<Document>) printQueue.clone();
        printQueue.clear();
        return notPrinted;
    }

    public void addToPrint (Document document){
        printQueue.add(document);
    }

    public void cancelPrint (Document document){
        printQueue.remove(document);
    }

    public ArrayList<Document> getPrintedDocuments (SortType sortType){
        ArrayList <Document> sorted = printedDocuments;
        switch (sortType){
            case PRINTORDER:
                return printedDocuments;
            case DOCUMENTTYPE:
                Collections.sort(sorted, new DocumentComparatorByType());
                return sorted;
            case FORMAT:
                Collections.sort(sorted, new DocumentComparatorByFormat());
                return sorted;
            case PRINTDURATION:
                Collections.sort(sorted, new DocumentComparatorByDuration());
                return sorted;
        }

      return sorted;
    }

    public double getAveragePrintDuration (){
        double result = 0;
        for (Document document: printedDocuments) {
            result +=document.getPrintduration();
        }
        return result/printedDocuments.size();
    }

    public void start(ArrayList<Document> documents){
            isStarted = true;
            printQueue.addAll(documents);
            Runnable backgroundRunnable = new Runnable() {
                public void run() {
                    while (isStarted){
                        if (!isExecuting) printFirst();
                    }
                }
            };
            background = new Thread( backgroundRunnable);
            background.start();
    }

    private void printFirst(){

        if (printQueue.size()==0){
            isStarted=false;
            return;
        }
        Document firstdocument = printQueue.get(0);
        isExecuting = true;
        try {
            background.sleep(firstdocument.getPrintduration()*1000);
            System.out.println(firstdocument.getContents());
            printQueue.remove(firstdocument);
            printedDocuments.add(firstdocument);
            isExecuting = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
