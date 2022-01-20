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
    List<List<Integer>> res;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList();
        
        if(root == null)
            return res;
        
        res.add(new ArrayList());
        goDeep(root);
        
        return res;
    }
    
    public int goDeep(TreeNode root){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null){
            res.get(0).add(root.val);
            return 0;
        }
        
        int leftDepth = goDeep(root.left);
        int rightDepth = goDeep(root.right);
        int currDepth = Math.max(leftDepth, rightDepth) + 1;
        if(currDepth == res.size())
            res.add(new ArrayList());
        
        res.get(currDepth).add(root.val);
        return currDepth;
    }
}