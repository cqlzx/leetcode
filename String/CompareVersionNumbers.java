package string;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		String v1 = "1.0.1";
		String v2 = "1";
		System.out.println(compareVersion(v1, v2));
	}
	
	//Using the max length which is better
	public static int compareVersion(String version1, String version2) {
		String[] level1 = version1.split("\\.");
		String[] level2 = version2.split("\\.");
		
		int maxLen = Math.max(level1.length, level2.length);
		for (int i = 0; i < maxLen; i++) {
			int v1 = i < level1.length ? Integer.parseInt(level1[i]) : 0;
			int v2 = i < level2.length ? Integer.parseInt(level2[i]) : 0;
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}
		
		return 0;
	}
	
	
	public static int compareVersion2(String version1, String version2) {		
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		
		int minLen = Math.min(v1.length, v2.length);
		int pos;
		for (pos = 0; pos < minLen; pos++) {
			if (Integer.valueOf(v1[pos]) > Integer.valueOf(v2[pos])) {
				return 1;
			} else if (Integer.valueOf(v1[pos]) < Integer.valueOf(v2[pos])) {
				return -1;
			}
		}
		
		int maxLen = Math.max(v1.length, v2.length);
		if (v1.length == maxLen && v2.length == maxLen) {
			return 0;
		}
		
		if (v1.length == maxLen) {
			for (; pos < maxLen; pos++) {
				if (Integer.valueOf(v1[pos]) > 0) return 1;
			}
		} else {
			for (; pos < maxLen; pos++) {
				if (Integer.valueOf(v2[pos]) > 0) return -1;
			}
		}
		
		return 0;
	}
}
