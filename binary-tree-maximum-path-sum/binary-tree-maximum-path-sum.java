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
    HashMap<Pair<TreeNode, Boolean>, Integer> maxMap = new HashMap();
    
    public int maxPathSum(TreeNode root) {
        return getMaxSum(root, false);
    }
    
    public int getMaxSum(TreeNode root, boolean pIncluded){
        if(root == null)
            return (int) (1e8 * -1);
        
        if(maxMap.get(new Pair(root, pIncluded)) != null)
            return maxMap.get(new Pair(root, pIncluded));
        
        if(!pIncluded){
            int lMaxNotIncluded = getMaxSum(root.left, false);
            int rMaxNotIncluded = getMaxSum(root.right, false);
            int lMaxIncluded = getMaxSum(root.left, true);
            int rMaxIncluded = getMaxSum(root.right, true);
            int max = Math.max(lMaxNotIncluded, rMaxNotIncluded);
            max = Math.max(max, root.val);
            max = Math.max(max, lMaxIncluded + root.val);
            max = Math.max(max, rMaxIncluded + root.val);
            max = Math.max(max, lMaxIncluded + rMaxIncluded + root.val);
            
            maxMap.put(new Pair(root, pIncluded), max);
            return max;
        }
        else{
            int lMaxIncluded = getMaxSum(root.left, true);
            int rMaxIncluded = getMaxSum(root.right, true);
            int max = Math.max(lMaxIncluded + root.val, rMaxIncluded + root.val);
            max = Math.max(max, root.val);
            // max = Math.max(max, lMaxIncluded + rMaxIncluded + root.val);
            
            maxMap.put(new Pair(root, pIncluded), max);
            return max;
        }
    }
}