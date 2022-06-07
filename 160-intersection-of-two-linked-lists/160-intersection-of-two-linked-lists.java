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
        
    }
}