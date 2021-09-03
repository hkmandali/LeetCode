import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class Day02 {

 List<TreeNode> generateRecur(int start,int end)
 {
  List<TreeNode> ret = new ArrayList<>();
  if(start == end)
  {
   ret.add(new TreeNode(start));
   return ret;
  }
  else
  {
   if(start > end)
   {
    ret.add(null);
    return ret;
   }// below case if start < end , we need to loop for all elements
   for(int i=start;i<=end;++i) {
       List<TreeNode> leftsubtrees = generateRecur(start, i - 1);
       List<TreeNode> rightsubtrees = generateRecur(i + 1, end);
       for (TreeNode leftside : leftsubtrees) {
           for (TreeNode rightside : rightsubtrees) {
               TreeNode currroot = new TreeNode(i);
               currroot.left = leftside;
               currroot.right = rightside;
               ret.add(currroot);
           }
       }
   }
  }
  return ret;
 }

 public List<TreeNode> generateTrees(int n) {
  if(1 == n)
  {
   return new ArrayList<TreeNode>(Arrays.asList(new TreeNode(1)));
  }
  else
  {
   return generateRecur(1,n);
  }
 }
 public static void main(String[] args) {
  System.out.println(new Day02().generateTrees(1));
 }
}
