package src.com.leetcode.arrays.easy;


import jdk.nashorn.internal.ir.SetSplitState;

import java.util.Set;

public class ConvertSortedArrayToBT {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = new ConvertSortedArrayToBT().sortedArrayToBST(nums, 0, nums.length - 1);
        System.out.println(treeNode);
    }


    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end || num.length == 0)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
