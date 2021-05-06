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
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    
    public ListNode sort(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = new ListNode();
        preSlow.next = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }
        
        preSlow.next = null;
        head = sort(head);
        slow = sort(slow);
        return merge(head, slow);
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode head = new ListNode();
        ListNode prev = head;
        
        while(head1 != null && head2 != null){
            head.next = new ListNode();
            head = head.next;
            if(head1.val <= head2.val){
                head.val = head1.val;
                head1 = head1.next;
            }
            else{
                head.val = head2.val;
                head2 = head2.next;
            }
        }
        
        while(head1 != null){
            head.next = new ListNode();
            head = head.next;
            head.val = head1.val;
            head1 = head1.next;
        }
        while(head2 != null){
            head.next = new ListNode();
            head = head.next;
            head.val = head2.val;
            head2 = head2.next;
        }
        
        return prev.next;
    }
}