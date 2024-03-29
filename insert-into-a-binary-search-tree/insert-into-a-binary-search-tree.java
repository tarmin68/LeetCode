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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        TreeNode curr = root;
        TreeNode prev = root;
        while(curr != null){
            while(curr != null && curr.val > val){
                prev = curr;
                curr = curr.left;
            }
            while(curr != null && curr.val < val){
                prev = curr;
                curr = curr.right;
            }
        }
        
        if(prev.val > val)
            prev.left = new TreeNode(val);
        else
            prev.right = new TreeNode(val);
        
        return root;
    }
}