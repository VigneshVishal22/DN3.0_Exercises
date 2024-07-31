public class LibraryManagementSystem {
    private Book[] books;
    private int count;

    public LibraryManagementSystem(int size) {
        books = new Book[size];
        count = 0;
    }

    // Method to add a book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full!");
        }
    }

    // Linear Search Method to find a book by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary Search Method to find a book by title (Assuming the list is sorted by title)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = books[mid].getTitle().compareToIgnoreCase(title);

            if (compareResult == 0) {
                return books[mid];
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Method to sort books by title
    public void sortBooksByTitle() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getTitle().compareToIgnoreCase(books[j + 1].getTitle()) > 0) {
                    // Swap books[j] and books[j + 1]
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        LibraryManagementSystem lms = new LibraryManagementSystem(100);

        // Adding Books
        System.out.print("\nEnter number of books to add: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine();  

        for (int i = 0; i < numBooks; i++) {
            System.out.print("\nEnter book ID: ");
            int bookId = scanner.nextInt();
            scanner.nextLine();  

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            Book book = new Book(bookId, title, author);
            lms.addBook(book);
        }

        // Linear Search
        System.out.print("\nEnter book title to search (Linear Search): ");
        String searchTitleLinear = scanner.nextLine();
        Book foundBookLinear = lms.linearSearchByTitle(searchTitleLinear);
        System.out.println("\nLinear Search Result: " + (foundBookLinear != null ? foundBookLinear : "\nBook not found"));

        // Sort Books before Binary Search
        lms.sortBooksByTitle();

        // Binary Search
        System.out.print("\nEnter book title to search (Binary Search): ");
        String searchTitleBinary = scanner.nextLine();
        Book foundBookBinary = lms.binarySearchByTitle(searchTitleBinary);
        System.out.println("\nBinary Search Result: " + (foundBookBinary != null ? foundBookBinary : "\nBook not found"));
    }
}
