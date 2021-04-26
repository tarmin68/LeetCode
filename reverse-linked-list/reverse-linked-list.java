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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode prev = null;
        ListNode currNode = head;
        ListNode next = head.next;
        while(currNode.next != null){
            currNode.next = prev;
            prev = currNode;
            currNode = next;
            next = currNode.next;
        }
        
        currNode.next = prev;
        return currNode;
    }
}