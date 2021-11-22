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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        
        if(root.val != subRoot.val)
            return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
        else{
            return (isSame(root.right, subRoot.right) && isSame(root.left, subRoot.left)) ||
                    isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
        }
    }
    
    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        
        if(root.val != subRoot.val)
            return false;
        else
            return isSame(root.right, subRoot.right) && isSame(root.left, subRoot.left);
    }
}