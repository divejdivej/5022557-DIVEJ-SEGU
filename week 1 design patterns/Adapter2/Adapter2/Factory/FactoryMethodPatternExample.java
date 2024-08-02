public class FactoryMethodPatternExample {
    interface Document {
        void display();
    }

    static class WordDocument implements Document {
        @Override
        public void display() {
            System.out.println("Displaying a Word document.");
        }
    }

    static class PdfDocument implements Document {
        @Override
        public void display() {
            System.out.println("Displaying a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        @Override
        public void display() {
            System.out.println("Displaying an Excel document.");
        }
    }

    abstract static class DocumentFactory {
        abstract Document createDocument();
    }

    static class WordDocumentFactory extends DocumentFactory {
        @Override
        Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.display();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.display();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.display();
    }
}