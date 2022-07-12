package src.com.leetcode.arrays.easy;

/*03. Range Sum Query - Immutable
        Given an integer array nums, handle multiple queries of the following type:

        Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
        Implement the NumArray class:

        NumArray(int[] nums) Initializes the object with the integer array nums.
        int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


        Example 1:

        Input
        ["NumArray", "sumRange", "sumRange", "sumRange"]
        [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
        Output
        [null, 1, -1, -3]

        Explanation
        NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
        numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
        numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
        numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3


        Constraints:

        1 <= nums.length <= 104
        -105 <= nums[i] <= 105
        0 <= left <= right < nums.length
        At most 104 calls will be made to sumRange.*/

import java.util.Arrays;

public class RangeSumQuery_303 {
    int[] left;

    public static void main(String[] args) {
        int[][] nums = {{-2, 0, 3, -5, 2, -1}, {0, 2}, {2, 5}, {0, 5}};
        RangeSumQuery_303 rangeSumQuery_303 = null;
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                rangeSumQuery_303 = new RangeSumQuery_303(nums[i]);
                res[i] = 0;
            } else {
                int sumRange = rangeSumQuery_303.sumRange(nums[i][0], nums[i][1]);
                res[i] = sumRange;
            }
        }
        System.out.println(Arrays.toString(res));
    }
//Approach 1 -> 1. Time Complexity = O(n) 2. Space Complexity = O(n)

//    public RangeSumQuery_303(int[] nums) {
//        left = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int num = 0;
//        for (int i = left; i <= right; i++) {
//            num = num + this.left[i];
//        }
//        return num;
//    }


    // Approach 2 -> 1. Time Complexity = O(n) 2. Space Complexity = O(n)
    public RangeSumQuery_303(int[] nums) {
        int n = nums.length;
        left = new int[n];
        this.left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] += nums[i] + left[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return this.left[right];
        return this.left[right] - this.left[left - 1];
    }

}
