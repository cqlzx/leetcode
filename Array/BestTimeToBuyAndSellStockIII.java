package array;

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int profit = maxProfit(prices);
		System.out.println(profit);
	}
	
	
	//The solution is awesome!
	public static int maxProfit(int[] prices) {
		int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		int sell1 = 0, sell2 = 0;
		for (int price : prices) {
			buy1 = Math.max(buy1, -price);
			sell1 = Math.max(sell1, buy1 + price);
			buy2 = Math.max(buy2, sell1 - price);
			sell2 = Math.max(sell2, buy2 + price);
		}
		
		return sell2;
	}
}
