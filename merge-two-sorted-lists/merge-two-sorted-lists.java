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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode curr = prev;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
                prev = prev.next;
            }
            else{
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
                prev = prev.next;
            }
        }
        if(l1 != null)
            prev.next = l1;
        else
            prev.next = l2;
        
        return curr.next;
    }
}