class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head;
    Book tail;

    // Add book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) head = tail = newBook;
        else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at the beginning: " + title);
    }

    // Add book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) head = tail = newBook;
        else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at the end: " + title);
    }

    // Remove book by ID
    public void removeById(int bookId) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed with ID: " + bookId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found with ID: " + bookId);
    }

    // Search by Title or Author
    public void searchByTitleOrAuthor(String title, String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title) || temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - ID: " + temp.bookId + " - Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Update availability status
    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability updated for Book ID " + bookId + " to " + (newStatus ? "Available" : "Unavailable"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found with ID: " + bookId);
    }

    // Display books in forward order
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - ID: " + temp.bookId + " - Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display books in reverse order
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " - " + temp.author + " - " + temp.genre + " - ID: " + temp.bookId + " - Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count total books in the library
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addAtEnd("Book1", "Author1", "Fiction", 101, true);
        library.addAtBeginning("Book2", "Author2", "Mystery", 102, false);
        library.addAtEnd("Book3", "Author3", "Science", 103, true);

        System.out.println("\nLibrary Collection (Forward Order):");
        library.displayForward();

        System.out.println("\nLibrary Collection (Reverse Order):");
        library.displayReverse();

        System.out.println("\nSearching for Book with Title 'Book2':");
        library.searchByTitleOrAuthor("Book2", "");

        library.updateAvailability(101, false);
        library.removeById(102);

        System.out.println("\nTotal Number of Books: " + library.countBooks());

        System.out.println("\nUpdated Library Collection:");
        library.displayForward();
    }
}
