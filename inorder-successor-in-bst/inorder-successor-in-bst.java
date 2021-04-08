/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode successor;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return successor;
        
        if(root.val <= p.val){
            inorderSuccessor(root.right, p);
        }
        else{
            if(successor == null || root.val < successor.val){
                successor = root;
            }
            inorderSuccessor(root.left, p);
            inorderSuccessor(root.left, p);
        }
        
        return successor;
    }
}