import java.util.ArrayList;
import java.util.HashMap;

public class Day_5_TopKFrequentElement {
    public static int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();

      // step-1 Find the occurance/frequency using HashMap
      for(int num : nums) {
        if(map.containsKey(num)) {
          map.put(num, map.get(num)+1);
        } else {
          map.put(num, 1);
        }
      }

      // Step-2 Use bucket array of size (N+1) to arrange according to occurance/frequency
      ArrayList<Integer> [] bucket = new ArrayList[nums.length+1]; // Array of ArrayList
      for(int key : map.keySet()) {
        int freq = map.get(key);
        if(bucket[freq] == null) {
          bucket[freq] = new ArrayList<>();
        }
        bucket[freq].add(key);
      }

      // Step-3 create a result array of size k to store top k elements and run loops backwards
      int[] res = new int[k];
      int idx = 0; // index for res
      for(int i=bucket.length-1; i>0; i--) {
        if(bucket[i] != null) {
          for(int val : bucket[i]) {
            res[idx++] = val;

            if(idx == k) return res;
          }
        }
      }
      return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        
        int[] result = topKFrequent(nums, 2);
        for(int i : result) {
          System.out.print(i + " ");
        }
    }
}

/*
 * TC = O(N)
 * 
 * SC = O(N)
 */
