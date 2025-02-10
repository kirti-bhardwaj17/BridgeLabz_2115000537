import java.util.*;
abstract class Product{
	private int productId;
	private String name;
	private double price;
	public Product(int productId , String name , double price){
	this.productId = productId;
	this.name = name;
	this.price = price;
	}
	public int getProductId(){
	return productId;
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
	public abstract double calculateDiscount();
}
interface Taxable{
	double calculateTax();
	String getTaxDetails();
	}
class Electronics extends Product implements Taxable{
	private double sellingPrice;
	public Electronics(int productId , String name,double price,double sellingPrice){
	super(productId , name , price);
	this.sellingPrice = sellingPrice;
	}
	public double calculateDiscount(){
	 return getPrice()*0.10;
	}
	public double calculateTax(){
	return getPrice()*0.18;
	}
	public String getTaxDetails(){
	return "GST 18% applied on Electronics";
	}
	}
class Clothing extends Product implements Taxable{
	public Clothing(int productId, String name, double price){
	super(productId, name , price);
}
	public double calculateDiscount(){
	return getPrice()*0.15;
	}
	public double calculateTax(){
	return getPrice()*0.05;
	}
	public String getTaxDetails(){
	return "5% tax is applied on clothing";
	}
}
class Groceries extends Product{
	public Groceries(int productId, String name, double price){
	super(productId, name , price);
	}
	public double calculateDiscount(){
	return getPrice()*0.05;
	}
}
public class EcommerceSystem {
	public static void main(String[] args){
	List<Product> productList = new ArrayList<>();
	productList.add(new Electronics(101,"Laptop",50000,48000));
	productList.add(new Clothing(201,"T-Shirt",1000));
	productList.add(new Groceries(301,"Rice Bag",500));
	for(Product product: productList){
	double discount = product.calculateDiscount();
	double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax():0;
double finalPrice = product.getPrice() + tax - discount;

            
            System.out.println("\nProduct: " + product.getName());
            System.out.println("Original Price: ₹" + product.getPrice());
            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);

         
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
        }
    }
}

