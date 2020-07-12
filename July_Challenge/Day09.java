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
    public int widthOfBinaryTree(TreeNode root) {
        if(null == root)
            return 0;
        Queue<TreeNode> visited = new LinkedList<>();
        visited.add(root);
        int leftest =1;
        int rightest =1;
        int maxwidth =0;
        while(!visited.isEmpty())
        {
            int size = visited.size();
            for(int i=0;i<size;++i)
            {
                TreeNode top = visited.poll();
                
                if(i == 0)
                {
                    leftest = top.val;
                }
                
                if(i == size-1)
                {
                    rightest = top.val;
                }
                
                if(top.left != null)
                {
                    top.left.val =  2*top.val;
                    visited.add(top.left);
                }
                if(top.right != null)
                {
                    top.right.val =  2*top.val +1;
                    visited.add(top.right);
                    
                }
            }     
            maxwidth = Math.max(maxwidth,rightest-leftest+1);
        }
        return maxwidth;
    }
}