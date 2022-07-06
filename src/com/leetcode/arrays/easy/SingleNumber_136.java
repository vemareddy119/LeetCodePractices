package src.com.leetcode.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber_136 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
//1.TimeComplexity=O(n) 2.SpaceComplexity=O(n)
   /* public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> resultMap : map.entrySet()) {
            if (resultMap.getValue() == 1)
                return resultMap.getKey();
        }
        return -1;
    }*/
//1.TimeComplexity=O(n) 2.SpaceComplexity=O(n)
    public static int singleNumber(int[] nums) {

        int x = 0;

        for (int i = 0; i < nums.length; i++) {

            x = x ^ nums[i];
        }

        return x;
    }
}
