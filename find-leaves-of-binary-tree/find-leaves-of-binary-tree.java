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
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        addToList(root);
        return res;
    }
    
    public int addToList(TreeNode root){
        if(root == null)
            return -1;
        
        int lListNum = addToList(root.left);
        int rListNum = addToList(root.right);
        
        int currListNum = Math.max(lListNum, rListNum) + 1;
        if(currListNum == res.size())
            res.add(new ArrayList<Integer>());
        
        res.get(currListNum).add(root.val);
        return currListNum;
    }
}