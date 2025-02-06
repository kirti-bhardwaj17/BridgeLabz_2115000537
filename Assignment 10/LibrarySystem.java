import java.util.*;
 class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

   
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
}
    public void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}
 class Library {
    private String name;
    private ArrayList<Book> books; 

    
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayLibraryInfo() {
        System.out.println("Library: " + name);
        System.out.println("Books in the library:");
        for (Book book : books) {
            book.displayBookInfo();
        }
    }
}


public class LibrarySystem {
    public static void main(String[] args) {
       
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

       
        Library library1 = new Library("Central Library");
        Library library2 = new Library("City Library");

        
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);

   
        library1.displayLibraryInfo();
        library2.displayLibraryInfo();

        System.out.println("\nIndependent Book Information:");
        book1.displayBookInfo();
        book2.displayBookInfo();
        book3.displayBookInfo();
    }
}
