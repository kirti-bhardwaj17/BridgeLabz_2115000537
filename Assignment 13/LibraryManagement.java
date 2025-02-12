class LibraryManagement {
    Node head, tail;

    class Node {
        String bookTitle;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        Node next, prev;

        Node(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = this.prev = null;
        }
    }

    public void addFirst(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(String bookTitle, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position == 1) {
            addFirst(bookTitle, author, genre, bookId, isAvailable);
            return;
        }
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        Node currNode = head;
        for (int i = 1; i < position - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }
        if (currNode == null) {
            return;
        }
        newNode.next = currNode.next;
        newNode.prev = currNode;
        if (currNode.next != null) {
            currNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
        currNode.next = newNode;
    }

    public void removeBook(int bookId) {
        if (head == null) {
            return;
        }
        if (head.bookId == bookId) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }
        Node currNode = head;
        while (currNode != null && currNode.bookId != bookId) {
            currNode = currNode.next;
        }
        if (currNode == null) {
            return;
        }
        if (currNode.next != null) {
            currNode.next.prev = currNode.prev;
        } else {
            tail = currNode.prev;
        }
        if (currNode.prev != null) {
            currNode.prev.next = currNode.next;
        }
    }

    public void searchByTitle(String bookTitle) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book Found: " + currNode.bookTitle + " by " + currNode.author + " (ID: " + currNode.bookId + ", Genre: " + currNode.genre + ", Available: " + currNode.isAvailable + ")");
                return;
            }
            currNode = currNode.next;
        }
    }

    public void searchByAuthor(String author) {
        Node currNode = head;
        boolean found = false;
        while (currNode != null) {
            if (currNode.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: " + currNode.bookTitle + " (ID: " + currNode.bookId + ", Genre: " + currNode.genre + ", Available: " + currNode.isAvailable + ")");
                found = true;
            }
            currNode = currNode.next;
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    public void updateAvailability(int bookId, boolean newStatus) {
        Node currNode = head;
        while (currNode != null) {
            if (currNode.bookId == bookId) {
                currNode.isAvailable = newStatus;
                return;
            }
            currNode = currNode.next;
        }
    }

    public void displayForward() {
        Node currNode = head;
        while (currNode != null) {
            System.out.println(currNode.bookTitle + " (ID: " + currNode.bookId + ", Genre: " + currNode.genre + ", Available: " + currNode.isAvailable + ")");
            currNode = currNode.next;
        }
    }

    public void displayReverse() {
        Node currNode = tail;
        while (currNode != null) {
            System.out.println(currNode.bookTitle + " (ID: " + currNode.bookId + ", Genre: " + currNode.genre + ", Available: " + currNode.isAvailable + ")");
            currNode = currNode.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        Node currNode = head;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagement lm = new LibraryManagement();
        lm.addFirst("1984", "George Orwell", "Dystopian", 101, true);
        lm.addLast("To Kill a Mockingbird", "Harper Lee", "Classic", 102, true);
        lm.addAtPosition("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 103, false, 2);
        lm.displayForward();
        System.out.println("Total Books: " + lm.countBooks());
        lm.displayReverse();
        lm.updateAvailability(103, true);
        lm.removeBook(101);
        lm.displayForward();
        lm.searchByAuthor("Harper Lee");
    }
}
