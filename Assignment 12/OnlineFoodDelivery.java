import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discount;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discount;
    }

    @Override
    public void applyDiscount() {
        discount = getPrice() * 0.10 * getQuantity();
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied to " + getItemName();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge;
    private double discount;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.extraCharge = 20;
        this.discount = 0;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + extraCharge) * getQuantity() - discount;
    }

    @Override
    public void applyDiscount() {
        discount = (getPrice() + extraCharge) * 0.05 * getQuantity();
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied to " + getItemName() + " with ₹" + extraCharge + " extra charge.";
    }
}

public class OnlineFoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 350, 1));

        for (FoodItem item : order) {
            System.out.println(item.getItemDetails());
            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                discountItem.applyDiscount();
                System.out.println(discountItem.getDiscountDetails());
            }
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
