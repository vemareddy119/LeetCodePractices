package src.com.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;


/*119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

        Example 1:

        Input: rowIndex = 3
        Output: [1,3,3,1]
        Example 2:

        Input: rowIndex = 0
        Output: [1]
        Example 3:

        Input: rowIndex = 1
        Output: [1,1]


        Constraints:

        0 <= rowIndex <= 33


        Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?*/

public class PaskalsTriangle_11_119 {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
    // 1. TimeComplexity = O(n2) 2. SpaceComplexity = O(n)
    public static List<Integer> generate(int rowIndex) {
        int i = 0;
        List<List<Integer>> listList = new ArrayList<>();
        while (i <= rowIndex) {
            List<Integer> integers = new ArrayList<>();
            if (i == 0) {
                integers.add(1);
            } else {
                for (int k = 0; k <= i; k++) {
                    if (k == 0 || k == i) {
                        integers.add(k, 1);
                    } else {
                        integers.add(listList.get(i - 1).get(k - 1) + listList.get(i - 1).get(k));
                    }
                }
            }
            listList.add(integers);
            i++;
        }
        return listList.get(rowIndex);
    }
}
