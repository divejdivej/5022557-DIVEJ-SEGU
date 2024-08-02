package LibraryManagementSystem;
public class LibraryManagementSystem {
    static class Book {
        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }
    }

    private Book[] books;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
    }

    public void addBook(int bookId, String title, String author) {
        Book book = new Book(bookId, title, author);
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return;
            }
        }
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book != null && book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (books[mid] != null && books[mid].title.equals(title)) {
                return books[mid];
            } else if (books[mid] != null && books[mid].title.compareTo(title) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(5);

        lms.addBook(1, "Book 1", "Author 1");
        lms.addBook(2, "Book 2", "Author 2");
        lms.addBook(3, "Book 3", "Author 3");

        Book book = lms.linearSearchByTitle("Book 2");
        if (book != null) {
            System.out.println("Book found: " + book.title);
        } else {
            System.out.println("Book not found.");
        }

        book = lms.binarySearchByTitle("Book 2");
        if (book != null) {
            System.out.println("Book found: " + book.title);
        } else {
            System.out.println("Book not found.");
        }
    }
}
