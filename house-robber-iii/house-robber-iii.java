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
    HashMap<TreeNode, Integer> maxIncluded = new HashMap();
    HashMap<TreeNode, Integer> maxNotIncluded = new HashMap();
    
    public int rob(TreeNode root) {
        return Math.max(getMax(root, true), getMax(root, false));
    }
    
    public int getMax(TreeNode root, boolean included){
        if(root == null)
            return 0;
        
        if(included && maxIncluded.get(root) != null)
            return maxIncluded.get(root);
        if(!included && maxNotIncluded.get(root) != null)
            return maxNotIncluded.get(root);
        
        if(included){
            int leftMax = getMax(root.left, false);
            int rightMax = getMax(root.right, false);
            int res = leftMax + rightMax + root.val;
            maxIncluded.put(root, res);
            return res;
        }
        else{
            int leftMax = Math.max(getMax(root.left, true), getMax(root.left, false));
            int rightMax = Math.max(getMax(root.right, true), getMax(root.right, false));
            int res = leftMax + rightMax;
            maxNotIncluded.put(root, res);
            return res;
        }
    }
}