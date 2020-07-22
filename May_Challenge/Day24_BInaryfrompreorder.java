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
    public TreeNode bstFromPreorderUtil(int[] preorder,int start,int end) {
        if(start >= end)
            return null;
        if(end == start +1)
            {
                return new TreeNode(preorder[start],null,null);
            }
        int rootdata = preorder[start];
        int i;
            for(i= start;i<end;++i)
            {
                if(preorder[i] > rootdata)
                {
                    //System.out.println("found greatest elemeent ar "+i);
                    break;
                }
            }
            TreeNode root;
            root = new TreeNode(rootdata,bstFromPreorderUtil(preorder,start+1,i),bstFromPreorderUtil(preorder,i,end));
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        if(null == preorder || 0 == preorder.length)
            return null;
        int len = preorder.length;
        return bstFromPreorderUtil(preorder,0,len);
            
    }
}