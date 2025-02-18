import java.util.*;
abstract class WarehouseItem {
    private String name;
    private double price;
    
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String toString() {
        return name + ", Price: " + price;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public List<T> getItems() {
        return items;
    }
}

class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("Laptop", 1000));
        
        Storage<Groceries> groceries = new Storage<>();
        groceries.addItem(new Groceries("Apple", 2));
        
        Storage<Furniture> furniture = new Storage<>();
        furniture.addItem(new Furniture("Chair", 50));
        
        WarehouseUtility.displayItems(electronics.getItems());
        WarehouseUtility.displayItems(groceries.getItems());
        WarehouseUtility.displayItems(furniture.getItems());
    }
}
