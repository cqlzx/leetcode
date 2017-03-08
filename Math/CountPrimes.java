package math;

public class CountPrimes {

	public static void main(String[] args) {
		int res = countPrimes2(5);
		System.out.println(res);
	}
	
	//Solution 1, time exceeds
	public static int countPrimes(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i)) count++;
		}
		return count;
	}
	private static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	//Solution 2, not fast enough
    public static int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
    
    //Solution 3, a little optimization of Solution 2
	public static int countPrimes3(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (!notPrime[i]){ 
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) count++;
		}
		
		return count;
	}
}
