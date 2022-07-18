package src.com.leetcode.arrays.easy;

/*414. Third Maximum Number
        Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.



        Example 1:

        Input: nums = [3,2,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2.
        The third distinct maximum is 1.
        Example 2:

        Input: nums = [1,2]
        Output: 2
        Explanation:
        The first distinct maximum is 2.
        The second distinct maximum is 1.
        The third distinct maximum does not exist, so the maximum (2) is returned instead.
        Example 3:

        Input: nums = [2,2,3,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2 (both 2's are counted together since they have the same value).
        The third distinct maximum is 1.


        Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


        Follow up: Can you find an O(n) solution?*/

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaximumNumber_414 {
    public static void main(String[] args) {
        int nums[] = {1, 2};
        System.out.println(thirdMax(nums));
    }

// 1. TimeComplexity = O(n) 2. Space Complexity = O(n)
    /*public static int thirdMax(int[] nums) {
        Set<Integer> integers = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            integers.add(nums[i]);
        }
        int i = 0;
        for (int number : integers) {
            if (integers.size() < 3 && integers.size() - 1 == i) {
                return number;
            } else {
                if (i == integers.size() - 3) {
                    return number;
                }
            }
            i++;
        }
        return -1;
    }*/
// 1. TimeComplexity = O(n) 2. Space Complexity = O(1)
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count += 1;
            }

            if (count == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }


}
