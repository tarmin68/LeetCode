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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode prev = preHead;
        ListNode curr = head;
        
        while(curr != null){
            while(curr != null && curr.next != null && curr.val == curr.next.val){
                prev.next = curr.next;
                curr = curr.next;
            }
            
            prev = curr;
            curr = curr.next;
        }
        
        return preHead.next;
    }
}