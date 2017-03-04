package array;

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 1; i < prices.length; i++) {
			int dif = prices[i] - prices[i - 1];
			if (dif > 0) total += dif;
		}
		return total;
	}
}
