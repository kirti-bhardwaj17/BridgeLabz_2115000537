public class ProfitNLoss{
	public static void main(String args[]){
		double CostPrice = 129;
		double SellingPrice = 191;
		double profit = SellingPrice - CostPrice;
		double profitPercent = (profit/CostPrice)*100;
		System.out.println("The Cost Price is INR "+CostPrice+" and Selling Price is INR "+SellingPrice);
		System.out.println("The Profit is INR "+profit+" and the Profit Percentage is "+profitPercent);
}
}
