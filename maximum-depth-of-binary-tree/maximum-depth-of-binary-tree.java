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
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        getMaxDepth(root, 0);
        return maxDepth;
    }
    
    public void getMaxDepth(TreeNode root, int depth){
        if(root == null){
            maxDepth = Math.max(maxDepth, depth);
        }
        else{
            getMaxDepth(root.left, depth + 1);
            getMaxDepth(root.right, depth + 1);
        }
    }
}