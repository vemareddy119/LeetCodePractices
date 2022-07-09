package src.com.leetcode.arrays.easy;
/*169. Majority Element
        Given an array nums of size n, return the majority element.

        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



        Example 1:

        Input: nums = [3,2,3]
        Output: 3
        Example 2:

        Input: nums = [2,2,1,1,1,2,2]
        Output: 2


        Constraints:

        n == nums.length
        1 <= n <= 5 * 104
        -109 <= nums[i] <= 109


        Follow-up: Could you solve the problem in linear time and in O(1) space?*/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    //1>Time Complexity = O(n) 2. Space Complexity = O(n)
//    public static int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                map.put(nums[i], map.get(nums[i]).intValue() + 1);
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//
//        int mjorityElement = 0;
//        int majorityValue = 0;
//        for (Map.Entry<Integer, Integer> map1 : map.entrySet()) {
//            if (map1.getValue() > mjorityElement) {
//                mjorityElement = map1.getValue();
//                majorityValue = map1.getKey();
//            }
//        }
//
//        return majorityValue;
//    }


    public static int majorityElement(int[] nums) {

        int count = 0, ans = 0;
        for(int num: nums) {
            if(count == 0) {
                ans = num;
            }
            if(num == ans) {
                count++;
            } else {
                count--;
            }
        }

        return ans;
    }
}
