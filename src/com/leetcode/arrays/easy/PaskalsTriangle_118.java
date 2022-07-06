package src.com.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.List;

/*118. Pascal's Triangle
        Given an integer numRows, return the first numRows of Pascal's triangle.

        In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


//     0                    1 (0)
//     1              1(0)       1 (1)
//     2           1 (0)      2(1)       1(2)
//     3      1(0)       3(1)       3(2)       1(3)
//     4  1(0)       4(1)       6(2)       4(3)       1(4)

        Example 1:

        Input: numRows = 5
        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1],[1,5,10,10,5,1]]
        Example 2:

        Input: numRows = 1
        Output: [[1]]


        Constraints:

        1 <= numRows <= 30*/

public class PaskalsTriangle_118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }


    // 1. TimeComplexity = O(n2) 2. SpaceComplexity = O(n)
    public static List<List<Integer>> generate(int numRows) {
        int i = 0;
        List<List<Integer>> listList = new ArrayList<>();
        while (i < numRows) {
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
        return listList;
    }
}
