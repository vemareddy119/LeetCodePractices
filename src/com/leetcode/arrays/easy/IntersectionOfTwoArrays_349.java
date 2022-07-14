package src.com.leetcode.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays_349 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    // 1. TimeComplexity = O(n2) 2. Space Complexity = O(n)
    /*public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (!integers.contains(nums1[i])) {
                        integers.add(nums1[i]);
                    }
                    continue;
                }
            }
        }
        int res[] = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            res[i] = integers.get(i);
        }
        return res;
    }*/

    // 1. TimeComplexity = O(n) 2. Space Complexity = O(n)
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap1.containsKey(nums1[i])) hashMap1.put(nums1[i], hashMap1.get(nums1[i]) + 1);
            else hashMap1.put(nums1[i], 1);
        }

        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap2.containsKey(nums2[i])) hashMap2.put(nums2[i], hashMap2.get(nums2[i]) + 1);
            else hashMap2.put(nums2[i], 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int key : hashMap1.keySet()) {
            if (hashMap2.containsKey(key)) list.add(key);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


}
