package array;

public class BestTimeToBuyAndSellStock {

	//Solution 1
	public int maxProfit(int[] prices) {
		int max = 0, tmp = 0;
		for (int i = 1; i < prices.length; i++) {
			tmp += prices[i] - prices[i - 1];
			if (tmp < 0) tmp = 0;
			max = Math.max(tmp, max);
		}
		
		return max;
	}
	
	//Solution 2, same idea as maxSubArray
    public int maxProfit2(int[] prices) {
		int[] dif = new int[prices.length];
		for (int i = 1; i < dif.length; i++) {
			dif[i] = prices[i] - prices[i - 1];
		}
		
		int max = 0, tmp = 0;
		for (int i = 1; i < dif.length; i++) {
			tmp += dif[i];
			if (tmp < 0) tmp = 0;
			max = Math.max(tmp, max);
		}
		
		return max;
    }
}
