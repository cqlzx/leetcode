package array;

public class ValidAnagram {

	//Solution 1
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] table = new int[26];
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < sa.length; i++) {
            table[sa[i] - 'a']++;
        }
        
        for (int i = 0; i < ta.length; i++) {
            table[ta[i] - 'a']--;
        }
        
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) return false;
        }
        
        return true;
    }
}
