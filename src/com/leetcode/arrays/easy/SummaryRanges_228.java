package src.com.leetcode.arrays.easy;


/*228. Summary Ranges
        You are given a sorted unique integer array nums.

        A range [a,b] is the set of all integers from a to b (inclusive).

        Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

        Each range [a,b] in the list should be output as:

        "a->b" if a != b
        "a" if a == b


        Example 1:

        Input: nums = [0,1,2,4,5,7]
        Output: ["0->2","4->5","7"]
        Explanation: The ranges are:
        [0,2] --> "0->2"
        [4,5] --> "4->5"
        [7,7] --> "7"
        Example 2:

        Input: nums = [0,2,3,4,6,8,9]
        Output: ["0","2->4","6","8->9"]
        Explanation: The ranges are:
        [0,0] --> "0"
        [2,4] --> "2->4"
        [6,6] --> "6"
        [8,9] --> "8->9"


        Constraints:

        0 <= nums.length <= 20
        -231 <= nums[i] <= 231 - 1
        All the values of nums are unique.
        nums is sorted in ascending order.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges_228 {
    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums));
    }

    //1. Time Complexity = O(n) 2.Space Complexity = O(n)
    private static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                s = nums[i] + "";
            } else {
                if (nums[i] - nums[i - 1] == 1) {
                    if (s.contains("->" + nums[i - 1])) {
                        s = s.replace("->" + nums[i - 1], "");
                    }
                    s = s + "->" + nums[i];
                } else {
                    list.add(s);
                    s = nums[i] + "";
                }
            }
        }
        if (!s.isEmpty()) {
            list.add(s);
        }

        return list;
    }
}
