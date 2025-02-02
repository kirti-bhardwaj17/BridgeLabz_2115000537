class Boook {
    public String ISBN;
    protected String title;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Boook {
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }

    public static void main(String[] args) {
        EBook ebook = new EBook();
        ebook.ISBN = "123-456-789";
        ebook.title = "Java Programming";
        ebook.setAuthor("John Doe");
        ebook.displayDetails();
        System.out.println("Author: " + ebook.getAuthor());
    }
}
