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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return getRoot(head);
    }
    
    public TreeNode getRoot(ListNode head){
        if(head == null)
            return null;
           
        if(head.next == null)
            return new TreeNode(head.val);
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = new ListNode();
        preSlow.next = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }
        
        preSlow.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = getRoot(head);
        root.right = getRoot(slow.next);
        
        return root;
    }
}