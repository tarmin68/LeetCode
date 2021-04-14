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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null)
            return new ArrayList<TreeNode>();
        
        List<TreeNode> leftForest = delNodes(root.left, to_delete);
        List<TreeNode> rightForest = delNodes(root.right, to_delete);
        List<TreeNode> res = new ArrayList<TreeNode>();
        
        
        boolean to_be_deleted = false;
        for(int i = 0; i < to_delete.length; i++){
            if(root.left != null && to_delete[i] == root.left.val){
                root.left = null;
            }
            if(root.right != null && to_delete[i] == root.right.val){
                root.right = null;
            }
            if(to_delete[i] == root.val){
                to_be_deleted = true;
            }
        }
        
        if(!to_be_deleted && root.left != null){
            leftForest.remove(root.left);
        }
        if(!to_be_deleted && root.right != null){
            rightForest.remove(root.right);
        }
        
        res.addAll(leftForest);
        res.addAll(rightForest);
        
        if(!to_be_deleted){
            res.add(root);
        }
        
        return res;
    }
}