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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        getCount(root, Integer.MIN_VALUE);
        return count;
    }
    
    public void getCount(TreeNode root, int maxSoFar){
        if(root.val >= maxSoFar){
            count++;
            maxSoFar = root.val;
        }
        if(root.left != null)
            getCount(root.left, maxSoFar);
        if(root.right != null)
            getCount(root.right, maxSoFar);
    }
}