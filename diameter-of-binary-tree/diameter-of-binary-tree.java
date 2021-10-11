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
    int max = Integer.MIN_VALUE;
    
    public int diameterOfBinaryTree(TreeNode root) {
        getMax(root);
        return max;
    }
    
    public int getMax(TreeNode root){
        if(root == null) return 0;
        
        int lMax = 0;
        int rMax = 0;
        
        if(root.left != null){
            lMax = getMax(root.left) + 1;
        }
        if(root.right != null){
            rMax = getMax(root.right) + 1;
        }
        
        max = Math.max(max, lMax + rMax);
        return Math.max(lMax, rMax);
    }
}