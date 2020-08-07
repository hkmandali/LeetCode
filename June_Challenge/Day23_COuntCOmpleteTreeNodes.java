/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int left_height=0,right_height=0;
        TreeNode left = root,right=root;
        while(left != null)
        {
            left_height++;
            left = left.left;
        }
        while(right != null)
        {
            right_height++;
            right = right.right;
        }
        if(left_height == right_height)
        {
            return (int)Math.pow(2,left_height) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}