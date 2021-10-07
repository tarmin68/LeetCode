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
    Set<Integer> allNum = new HashSet();
    
    public boolean isValidBST(TreeNode root) {
        allNum.add(root.val);
        return isValid(root.left, root.val, Integer.MIN_VALUE)
            && isValid(root.right, Integer.MAX_VALUE, root.val);
    }
    
    public boolean isValid(TreeNode root, int max, int min){
        if(root == null)
            return true;
        if(allNum.contains(root.val))
            return false;
        
        if(root.val > max || root.val < min)
            return false;
        
        allNum.add(root.val);
        
        return isValid(root.left, Math.min(max, root.val), min) &&
            isValid(root.right, max, Math.max(min, root.val));
    }
}