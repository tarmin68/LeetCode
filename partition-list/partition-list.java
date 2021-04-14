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
    public ListNode partition(ListNode head, int x) {
        ListNode largeHead = head;
        while(largeHead != null && largeHead.val < x){
            largeHead = largeHead.next;
        }
        
        ListNode smallHead = new ListNode();
        smallHead.next = largeHead;
        ListNode currSmall = smallHead;
        
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode currNode = head;
        while(currNode != null){
            if(currNode.val < x){
                prev.next = currNode.next;
                currSmall.next = new ListNode(currNode.val, largeHead);
                currSmall = currSmall.next;
                currNode = prev.next;
            }
            else{
                currNode = currNode.next;
                prev = prev.next;
            }
        }
        
        return smallHead.next;
    }
}