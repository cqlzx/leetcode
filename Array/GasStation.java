package array;

public class GasStation {

	//Solution 1, time exceeds
	public int canComplete(int[] gas, int[] cost) {
		int[] dif = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			dif[i] = gas[i] - cost[i];
		}
		
		for (int i = 0; i < dif.length; i++) {
			int sum = 0, j = i;
			while (sum >= 0) {
				sum += dif[j];
				j = ++j % dif.length;
				if (j == i && sum >= 0) return i;
			}
		}
		
		return -1;
	}
	
	//Solution 2, One pass solution based on some theorem
	public int canComplete2(int[] gas, int[] cost) {
		int total = 0, tank = 0, start = 0;
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
			tank += gas[i] - cost[i];
			if (tank < 0) {
				tank = 0;
				start = i + 1;
			}
		}
		return total < 0 ? -1 : start;
	}
}
