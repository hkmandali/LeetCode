https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3435/
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
    int leftleavesUtil(TreeNode root,int side) // 0 for left , 1 for right
    {
        if(null == root)
            return 0;
        if(null == root.left && null == root.right) // it is a leaf
        {
            if(0 == side) // considering only for left side
                return root.val;
        }
       
        return leftleavesUtil(root.left,0) + leftleavesUtil(root.right,1);         
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(null == root || (null == root.left && null == root.right))
            return 0;
       // int leftsum = leftleavesUtil(root.left,0);
        //int rightsum = leftleavesUtil(root.right,1);
        //int sum =  + ;
        //return leftsum + rightsum;
         return leftleavesUtil(root.left,0) + leftleavesUtil(root.right,1);        
    }
}