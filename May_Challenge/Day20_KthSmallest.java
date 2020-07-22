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
// since it is a BST , inorder traversal would give us the sorted list
class Solution {
    void findksmallest(TreeNode root,int[] res,int k)
    {
        if(null == root)
            return;
        findksmallest(root.left,res,k);
        if(++res[0] == k)
        {
            res[1] = root.val;
            return;
        }
        findksmallest(root.right,res,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2]; // res[0] = element position(counter for the elements visited) , res[1] = value
        
        findksmallest(root,res,k);
        return res[1];
    }
}