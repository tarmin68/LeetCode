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
    public int pathSum(TreeNode root, int targetSum) {
        return getPathSum(root, targetSum);
    }
    
    public int getPathIncluding(TreeNode root, int targetSum){
        if(root == null)
            return 0;
        
        int leftPathSum = getPathIncluding(root.left, targetSum - root.val);
        int rightPathSum = getPathIncluding(root.right, targetSum - root.val);
        
        if(root.val == targetSum)
            return 1 + leftPathSum + rightPathSum;
        else
            return leftPathSum + rightPathSum;
    }
    
    public int getPathSum(TreeNode root, int targetSum){
        if(root == null)
            return 0;
        
        int pathSum = getPathIncluding(root, targetSum);
        pathSum += getPathSum(root.left, targetSum);
        pathSum += getPathSum(root.right, targetSum);
        
        return pathSum;
    }
}