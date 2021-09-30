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
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode prev = preHead;
        
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }
            else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        
        return preHead.next;
    }
}