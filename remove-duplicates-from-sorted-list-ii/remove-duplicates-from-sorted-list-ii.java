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
        
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                int val = curr.val;
                while(curr != null && curr.val == val)
                    curr = curr.next;
                prev.next = curr;
            }
            else{
                prev = prev.next;
                curr = curr.next;
            }
        }
        
        return preHead.next;
    }
}