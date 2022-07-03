package src.com.leetcode.arrays.easy;

/*66. Plus One
        You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

        Increment the large integer by one and return the resulting array of digits.



        Example 1:

        Input: digits = [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.
        Incrementing by one gives 123 + 1 = 124.
        Thus, the result should be [1,2,4].
        Example 2:

        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
        Incrementing by one gives 4321 + 1 = 4322.
        Thus, the result should be [4,3,2,2].
        Example 3:

        Input: digits = [9]
        Output: [1,0]
        Explanation: The array represents the integer 9.
        Incrementing by one gives 9 + 1 = 10.
        Thus, the result should be [1,0].


        Constraints:

        1 <= digits.length <= 100
        0 <= digits[i] <= 9
        digits does not contain any leading 0's.*/

import java.util.Arrays;

public class PlusOne_66 {
    public static void main(String[] args) {
        int nums[] = {9};
        final int[] res = plusOne(nums);
        System.out.println(Arrays.toString(res));
    }

    // 1. Time Complexity = O(n) 2. Space Complexity = O(n)
    public static int[] plusOne(int[] digits) {
        int res[] = new int[digits.length];
        if (digits[digits.length - 1] == 9) {
            int extraValue = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                int temp = -1;
                if (i == digits.length - 1) {
                    temp = digits[i] + 1;
                } else {
                    temp = digits[i] + extraValue;
                    extraValue = 0;
                }
                if (temp == 10) {
                    digits[i] = 0;
                    extraValue = 1;
                } else {
                    digits[i] = temp;
                }
            }
            if (extraValue != 0) {
                res = new int[digits.length + 1];
                res[0] = 1;
                for (int j = 0; j < res.length; j++) {
                    if (j == 0) {
                        res[j] = 1;
                    } else {
                        res[j] = digits[j - 1];
                    }
                }
            } else {
                return digits;
            }
        } else {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        return res;
    }
}
