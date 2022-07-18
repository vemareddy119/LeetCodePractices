package src.com.leetcode.arrays.easy;

import java.util.*;

/*350. Intersection of Two Arrays II
        Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]
        Example 2:

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]
        Explanation: [9,4] is also accepted.


        Constraints:

        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000


        Follow up:

        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?*/

public class IntersectionOfTwoArraysII_350 {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    // 1. Time Complexity = O(n^2) 2. Space Complexity = O(n)
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
//        for (int i = 0; i < nums1.length; i++) {
//            if (hashMap1.containsKey(nums1[i])) {
//                hashMap1.put(nums1[i], hashMap1.get(nums1[i]) + 1);
//            } else {
//                hashMap1.put(nums1[i], 1);
//            }
//        }
//        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
//        for (int j = 0; j < nums2.length; j++) {
//            if (hashMap2.containsKey(nums2[j])) {
//                hashMap2.put(nums2[j], hashMap2.get(nums2[j]) + 1);
//            } else {
//                hashMap2.put(nums2[j], 1);
//            }
//        }
//        List<Integer> integers = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
//            if (hashMap2.containsKey(entry.getKey()) && entry.getValue() == hashMap2.get(entry.getKey())) {
//                for (int k = 0; k < entry.getValue(); k++) {
//                    integers.add(entry.getKey());
//                }
//            } else {
//                if (hashMap2.containsKey(entry.getKey()) && entry.getValue() < hashMap2.get(entry.getKey())) {
//                    for (int k = 0; k < entry.getValue(); k++) {
//                        integers.add(entry.getKey());
//                    }
//                }
//                if (hashMap2.containsKey(entry.getKey()) && entry.getValue() > hashMap2.get(entry.getKey())) {
//                    for (int k = 0; k < hashMap2.get(entry.getKey()); k++) {
//                        integers.add(entry.getKey());
//                    }
//                }
//            }
//        }
//        int[] res = new int[integers.size()];
//        for (int l = 0; l < integers.size(); l++) {
//            res[l] = integers.get(l);
//        }
//        return res;
//    }

    // 1. Time Complexity = O(n) 2. Space Complexity = O(1)
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            count[nums1[i]]++;
        }
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (count[nums2[i]] > 0) {
                result[index++] = nums2[i];
                count[nums2[i]]--;
            }
        }
        return Arrays.copyOf(result, index);
    }



}
