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
    public TreeNode deleteNode(TreeNode root, int key) {
        return getTree(root, key);
    }
    
    public TreeNode getTree(TreeNode root, int key){
        if(root == null)
            return root;
        
        if(root.val != key){
            if(root.val > key)
                root.left = getTree(root.left, key);
            else
                root.right = getTree(root.right, key);
            return root;
        }
        else{
            if(root.right == null)
                return root.left;
            if(root.left == null)
                return root.right;
            
            TreeNode curr = root.left;
            while(curr.right != null)
                curr = curr.right;
            curr.right = root.right;
            return root.left;
        }
    }
}