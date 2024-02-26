

public class Day_6_ProductOfArrayExceptItself {

    // using prefix and postfix
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        //initialize
        prefix[0] = 1;
        postfix[n-1] = 1;

        for(int i=1; i<n; i++) { 
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        for(int i=n-2; i>=0; i--) {
            postfix[i] = nums[i+1] * postfix[i+1];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            ans[i] = prefix[i] * postfix[i];
        }

        return ans;
    }
    /*
     * TC = O(N)
     * 
     * SC = O(N)
     */
    

    /******************* Constant solution **************************/
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left =1, right = 1;

        // prefix
        for(int i=0; i<n; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        //postfix and multiplication
        for (int i=n-1; i>=0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }

    /*
     * TC = O(N)
     * 
     * SC = O(1) 
     *      Since ans[] doesn't count as extra space
     */

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};

        int ans[] = productExceptSelf2(nums);

        for(int e : ans) {
            System.out.print(e + " ");
        }
    }
}