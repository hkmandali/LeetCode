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
    int finddepth(TreeNode root, int node,int secondnode,int level)
    {
        
        if(root != null)
        {
            if(root.val == node){
                return level;
            }
            if(root.left != null && root.right != null)
            {
                
                if((root.left.val == node && root.right.val == secondnode) || 
                  (root.right.val == node && root.left.val == secondnode))
                {
                    return 100;
                }
            }
            return Math.max(finddepth(root.left,node,secondnode,level+1),finddepth(root.right,node,secondnode,level+1));
        }
        return 0;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val ==x || root.val ==y)
            return false;
        int depth1 = finddepth(root,x,y,0);
        if(100 == depth1)
        {
            
            return false;
        }
        int depth2 = finddepth(root,y,x,0);
        if(depth1  == depth2)
            return true;
        return false;
    }
}