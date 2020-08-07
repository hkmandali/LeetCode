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
    int sumUtil(TreeNode root,int sumtillnow)
    {
        if(root == null)
            return sumtillnow;
        
        if(root.left != null && root.right != null)
        {
            return sumUtil(root.left,sumtillnow*10 + root.val) + sumUtil(root.right,sumtillnow*10 + root.val);
        }
        else if(root.left != null)
        {
            return sumUtil(root.left,sumtillnow*10 + root.val) ;
        }
        else if(root.right != null)
        {
            return sumUtil(root.right,sumtillnow*10 + root.val) ;
        }
        return sumtillnow*10 + root.val;
        
        /*
        if(root.left == null && root.right == null)
        {
            return sumtillnow*10 + root.val;
        }
        return sumUtil(root.left,sumtillnow*10 + root.val) + sumUtil(root.right,sumtillnow*10 + root.val);
        */
    }
    public int sumNumbers(TreeNode root) {
        return sumUtil(root,0);
    }
}