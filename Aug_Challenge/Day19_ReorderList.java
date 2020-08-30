https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3430/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        {
            return;
        }
        Stack<ListNode> st = new Stack();
        int count =0;
        ListNode curr = head;
        while(curr != null)
        {
            st.push(curr);
            curr = curr.next;
            count++;
        }
        curr = head; // initialize to head
        for(int i=0;i<(count-1)/2;++i)
        {
            ListNode top = st.pop();
           
            top.next = curr.next;
            curr.next = top;
            curr = top.next;
           
        }
        if(count %2  ==0)
            curr.next.next = null;
        else
            curr.next =null;
        return;
    }
}