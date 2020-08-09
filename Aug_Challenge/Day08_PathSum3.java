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
    //Method 1
    /*
    int PathSumUtil(TreeNode root,int sum) // this is for including the current root
    {
        if(null == root)
            return 0;
        int res =0;
        if(root.val == sum)
        {
            res++;
        }
        return res + PathSumUtil(root.left,sum-root.val) +  PathSumUtil(root.right,sum-root.val);
    }
    public int pathSum(TreeNode root, int sum) {
        if(null == root)
            return 0; // we have two steps in this either 1. include root 2. do not include root
        return pathSum(root.left,sum) + pathSum(root.right,sum) + PathSumUtil(root,sum);
    }
    */
    // Method 2
    int PathSumUtil(TreeNode root,int sum,List<Integer> arr) // we keep a track of all the nodes visited till leaf
    {
        if(null == root)
            return 0;
        int ret = 0;
        arr.add(root.val);
        
        ret += PathSumUtil(root.left,sum,arr);
        ret += PathSumUtil(root.right,sum,arr);
        
        int temp_sum =0;
        for(int i=arr.size()-1;i>=0;--i)
        {
            temp_sum += arr.get(i);
            if(temp_sum == sum)
                ret++;
        }
        
        arr.remove(arr.size()-1); // removing the last element i.e the current node
        return ret;
    }
    public int pathSum(TreeNode root, int sum) {
        if(null == root)
            return 0; // we have two steps in this either 1. include root 2. do not include root
        List<Integer> arr = new ArrayList();
        return PathSumUtil(root,sum,arr);
    }
}