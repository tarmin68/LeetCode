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
    ArrayList<Integer> values = new ArrayList();
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return values.get(k - 1);
    }
    
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        values.add(root.val);
        inOrder(root.right);
    }
}