/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(null == headA || null == headB)
            return null;
        /*
        HashSet<ListNode> hs = new HashSet<>();
        ListNode iter = headA;
        while(iter!= null)
        {
            hs.add(iter);
            iter = iter.next;
        }
        iter = headB;
        while(iter!= null)
        {
            if(hs.contains(iter))
            {
                return iter;
            }
            iter = iter.next;
        }
        return null;
        */
        // single pass, checked from discuss section
        // as the last nodes after the intersection in both the lists are the same, we can iterate both the lists i.e append list A to list B , similarly
        // list B to list A, once the values are equal, we can stop iterating 
        ListNode itrA = headA , itrB = headB;
        //System.out.println("value of A and B is "+itrA.val+"   "+itrB.val);
        while(itrA != itrB)
        {
            if(itrA == null)
                itrA = headB;
            else
                itrA = itrA.next;
            if(itrB == null)
                itrB = headA;
            else
                itrB = itrB.next;
            
            
        }
        return itrA;
    }
}