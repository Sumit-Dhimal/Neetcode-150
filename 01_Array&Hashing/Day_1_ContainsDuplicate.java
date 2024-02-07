/**
 * Day_1_ContainsDuplicate
 */
import java.util.*;

public class Day_1_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<Integer>();

        for(int i=0; i<nums.length; i++) {
            if(!uniqueSet.contains(nums[i])) {
                uniqueSet.add(nums[i]);
            } else {
               return true;
            }
        }
        return false;
    }
}

/*
 * Time complexity : O(N)
 *          Since we are running a loop that runs n times
 * 
 * Space complexity : O(N) 
 *          Since we are using an exernal set
 */