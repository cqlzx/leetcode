package array;

import java.util.*;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        int pre = start;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre + 1) {
                pre = nums[i];
                continue;
            }
            
            helper(start, pre, res);
            
            start = nums[i];
            pre = start;
        }
        
        helper(start, pre, res);
        
        return res;
    }
    
    private void helper(int start, int pre, List<String> res) {
        if (start == pre) {
            res.add(pre + "");
        } else {
            res.add(start + "->" + pre);
        }
    }
}
