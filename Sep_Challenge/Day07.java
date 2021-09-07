public class Day07 {
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        if(null == head || null == head.next)
        {
            return head;
        }
        ListNode prev= null,curr= head,next;
        while(curr != null)
        {
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr= next;
        }
        return prev;

    }
    public static void main(String[] args) {

    }
}
