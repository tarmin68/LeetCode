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
        while(count < n){
            first = first.next;
            count++;
        }
        
        while(first != null){
            first = first.next;
            second = second.next;
            prev = prev.next;
        }
        
        if(prev.next == head)
            head = head.next;
        else
            prev.next = second.next;
        return head;
    }
}