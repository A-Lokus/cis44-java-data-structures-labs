import java.util.LinkedList;

class PrintJob{
    private String docName;
    private int pageCount;

    public PrintJob(String docName, int pageCount){
        this.docName = docName;
        this.pageCount = pageCount;
    }

    public String getDocName() {
        return docName;
    }
    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString(){
        return "PrintJob[Document: "+docName+", Pages: "+pageCount+"]";
    }
}

public class Printer {
    private Queue<PrintJob> printerQueue;

    public Printer(){
        printerQueue = new LinkedQueue<PrintJob>();
    }

    public void addJob(PrintJob job){
        printerQueue.enqueue(job);
    }
    public void processNextJob(){
        if(printerQueue.isEmpty()){System.out.println("No jobs to process.");}
        else{
            System.out.println("Processing: " + printerQueue.dequeue());
        }
    }

    public static void main(String[] args){
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}
