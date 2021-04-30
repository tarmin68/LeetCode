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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode getTree(int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if(preR < preL)
            return null;
        
        if(preR == preL)
            return new TreeNode(preorder[preL]);
        
        TreeNode root = new TreeNode(preorder[preL]);
        int rootIdx = -1;
        for(int i = inL; i <= inR; i++){
            if(inorder[i] == root.val){
                rootIdx = i;
                break;
            }
        }
        
        int lPreR = preL + rootIdx - inL;
        root.left = getTree(preorder, inorder, preL + 1, lPreR, inL, rootIdx - 1);
        root.right = getTree(preorder, inorder, lPreR + 1, preR, rootIdx + 1, inR);
        
        return root;
    }
}