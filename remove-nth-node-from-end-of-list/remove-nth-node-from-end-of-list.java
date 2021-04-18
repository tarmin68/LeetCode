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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode prev = new ListNode();
        prev.next = head;
        
        int count = 0;
        while(count < n && first != null){
            first = first.next;
            count++;
        }
        
        while(first != null){
            second = second.next;
            prev = prev.next;
            first = first.next;
        }
        
        if(prev.next == head){
            return head.next;
        }
        
        prev.next = second.next;
        return head;
    }
}