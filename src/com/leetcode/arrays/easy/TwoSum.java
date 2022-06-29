package src.com.leetcode.arrays.easy;

/* 1. Two Sum

        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.



        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]


        Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.


        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        final int[] resArray = new TwoSum().twoSum(nums, target);
        System.out.println(Arrays.toString(resArray));
    }

    // Solution 1
    // 1. Time Complexity = O(n^2)  2. Space Complexity = O(1)
    /*public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1};
    }*/


    // Solution 2
    // 1. Time Complexity = O(n)  2. Space Complexity = O(n)
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (!map.containsKey(nums[left]) && !map.containsKey(nums[right])) {
                map.put(target - nums[left], left);
                left++;
            }
            if (!map.containsKey(nums[right])) {
                map.put(target - nums[right], right);
                right--;
            }
            if (map.containsKey(nums[left])) {
                return new int[]{map.get(nums[left]), left};
            }
            if (map.containsKey(nums[right])) {
                return new int[]{map.get(nums[right]), right};
            }
        }
        return new int[]{-1};
    }

}
