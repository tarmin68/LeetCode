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
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode currNode = new ListNode();
        currNode.next = head;
        ListNode secondNode = new ListNode();
        secondNode.next = head;
        
        while(count < k){
            count++;
            currNode = currNode.next;
        }
        ListNode tempNode = currNode;
        
        while(currNode != null){
            currNode = currNode.next;
            secondNode = secondNode.next;
        }
        
        int tempVal = tempNode.val;
        tempNode.val = secondNode.val;
        secondNode.val = tempVal;
        
        return head;
    }
}