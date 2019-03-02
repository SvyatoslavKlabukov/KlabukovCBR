import java.util.UUID;

public class Document  {
    private DocumentType documentType;
    private Format format;
    private int printduration;
    private String id;
    private String contents;

    public Document(DocumentType documentType, Format format, int printduration, String contents) {
        this.documentType = documentType;
        this.format = format;
        this.printduration = printduration;
        id = UUID.randomUUID().toString();
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public int getPrintduration() {
        return printduration;
    }

    public void setPrintduration(int printduration) {
        this.printduration = printduration;
    }
}
