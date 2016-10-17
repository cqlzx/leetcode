package ninthContest;

public class LongestRepeatingCharacterReplacement {
	public static void main(String args[]){
		String s = "AACCCBBCCABDDDD";
		int i = characterReplacement(s, 1);
		System.out.println(i);
	}
	
	public static int characterReplacement(String s, int k){
		int[] count = new int[26];
		int start = 0;
		int len = s.length();
		int maxCount = 0;
		int maxLen = 0;
		for(int end = 0; end < len; end++){
			int index = s.charAt(end) - 'A';
			count[index]++;
			maxCount = Math.max(count[index], maxCount);
			while(end - start - maxCount + 1 > k){
				index = s.charAt(start) - 'A';
				count[index]--;
				start++;
				maxCount = 0;
				for(int i = 0; i < 26; i++){
					maxCount = Math.max(maxCount, count[i]);
				}
			}
			maxLen = Math.max(maxLen, end - start + 1);
		}
		
		return maxLen;
	}
}
