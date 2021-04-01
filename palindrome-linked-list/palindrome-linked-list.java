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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow = reverse(slow);
        
        ListNode left = head;
        while(left != null && slow != null){
            if(left.val != slow.val) return false;
            left = left.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prevPrev = null;
        ListNode prev = head;
        ListNode next;
        
        while(prev != null){
            next = prev.next;
            prev.next = prevPrev;
            prevPrev = prev;
            prev = next;
        }
        
        return prevPrev;
    }
}