package src.com.leetcode.arrays.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
217. Contains Duplicate
        Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



        Example 1:

        Input: nums = [1,2,3,1]
        Output: true
        Example 2:

        Input: nums = [1,2,3,4]
        Output: false
        Example 3:

        Input: nums = [1,1,1,3,3,4,3,2,4,2]
        Output: true


        Constraints:

        1 <= nums.length <= 105
        -109 <= nums[i] <= 109 */
public class ContainDuplicates_217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    //1. TimeComplexity = O(n) 2. SpaceComplexity = O(1)
//    public static boolean containsDuplicate(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//                return true;
//            }else {
//                map.put(nums[i], i);
//            }
//        }
//        return false;
//    }

    //1.TimeComplexity = O(n) 2. SpaceComplexity = O(1)
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
