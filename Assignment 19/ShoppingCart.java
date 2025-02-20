import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> orderedItems = new LinkedHashMap<>();
    private Map<String, Double> sortedItems = new TreeMap<>(Comparator.comparingDouble(productPrices::get));

    public void addItem(String product, double price) {
        productPrices.put(product, price);
        orderedItems.put(product, price);
        sortedItems.put(product, price);
    }

    public void displayCart() {
        System.out.println("Items (Unordered): " + productPrices);
        System.out.println("Items (Insertion Order): " + orderedItems);
        System.out.println("Items (Sorted by Price): " + sortedItems);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.5);
        cart.addItem("Banana", 0.8);
        cart.addItem("Cherry", 2.0);
        cart.displayCart();
    }
}
