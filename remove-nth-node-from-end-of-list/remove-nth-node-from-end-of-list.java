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
        int count = 0;
        
        while(count < n){
            first = first.next;
            count++;
        }
        
        ListNode second = new ListNode();
        second.next = head;
        while(first != null){
            first = first.next;
            second = second.next;
        }
        
        if(second.next == head)
            return head.next;
        
        second.next = second.next.next;
        return head;
    }
}