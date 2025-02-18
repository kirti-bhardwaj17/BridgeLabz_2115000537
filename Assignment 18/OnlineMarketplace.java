import java.util.ArrayList;
import java.util.List;

abstract class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public abstract void displayDetails();
}

enum BookCategory {
    FICTION, NON_FICTION, SCIENCE, HISTORY;
}

enum ClothingCategory {
    MENS_WEAR, WOMENS_WEAR, KIDS_WEAR;
}

enum GadgetCategory {
    MOBILE, LAPTOP, ACCESSORY;
}

class Book extends Product<BookCategory> {
    public Book(String name, double price, BookCategory category) {
        super(name, price, category);
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getName() + ", Price: " + getPrice() + ", Category: " + getCategory());
    }
}

class Clothing extends Product<ClothingCategory> {
    public Clothing(String name, double price, ClothingCategory category) {
        super(name, price, category);
    }

    @Override
    public void displayDetails() {
        System.out.println("Clothing: " + getName() + ", Price: " + getPrice() + ", Category: " + getCategory());
    }
}

class Gadget extends Product<GadgetCategory> {
    public Gadget(String name, double price, GadgetCategory category) {
        super(name, price, category);
    }

    @Override
    public void displayDetails() {
        System.out.println("Gadget: " + getName() + ", Price: " + getPrice() + ", Category: " + getCategory());
    }
}

class MarketplaceCatalog {
    private List<Product<?>> products = new ArrayList<>();

    public void addProduct(Product<?> product) {
        products.add(product);
    }

    public void displayCatalog() {
        for (Product<?> product : products) {
            product.displayDetails();
        }
    }

    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
        System.out.println("Discount applied! New price of " + product.getName() + ": " + product.getPrice());
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        MarketplaceCatalog catalog = new MarketplaceCatalog();

        Book book1 = new Book("The Alchemist", 500, BookCategory.FICTION);
        Clothing clothing1 = new Clothing("T-Shirt", 700, ClothingCategory.MENS_WEAR);
        Gadget gadget1 = new Gadget("Smartphone", 15000, GadgetCategory.MOBILE);

        catalog.addProduct(book1);
        catalog.addProduct(clothing1);
        catalog.addProduct(gadget1);

        System.out.println("\n--- Product Catalog ---");
        catalog.displayCatalog();

        MarketplaceCatalog.applyDiscount(book1, 10);
        MarketplaceCatalog.applyDiscount(clothing1, 15);
        MarketplaceCatalog.applyDiscount(gadget1, 5);

        System.out.println("\n--- Updated Catalog After Discount ---");
        catalog.displayCatalog();
    }
}
