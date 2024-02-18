import java.util.HashMap;

public class Day_3_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }

            map.put(num, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int ans[] = twoSum(nums, target);

        for(int i : ans) {
            System.out.print(i + " ");
        }
    }
}

/*
 * TC = O(N)
 * 
 * SC = O(N)
 */
