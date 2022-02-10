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
class 2095 {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode startNode = head, slow = head, fast = head, prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = slow.next;
        return startNode;
    }
    
    public ListNode deleteMiddleWithHalfCounter(ListNode head) {
        if (head == null || head.next == null)
            return null;
        
        ListNode startNode = head, ptrNode = head;
        ListNode previousMidNode = head,  midNode = head;
        
        int i = 0, j = 0;
        while (ptrNode != null) {
            ptrNode = ptrNode.next;
            i++;
            if (j != i / 2) {
                j = i / 2;
                previousMidNode = midNode;
                midNode = midNode.next;
            }
        }

        previousMidNode.next = midNode.next;
        return startNode;
    }
}
