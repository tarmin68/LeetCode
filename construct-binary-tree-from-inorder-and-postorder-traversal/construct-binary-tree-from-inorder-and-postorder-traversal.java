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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return getTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode getTree(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR){
        if(inR < inL)
            return null;
        
        if(inL == inR)
            return new TreeNode(inorder[inL]);
        
        TreeNode root = new TreeNode(postorder[postR]);
        
        int rootIdx = inL;
        for(int i = inL; i <= inR; i++){
            if(inorder[i] == postorder[postR]){
                rootIdx = i;
                break;
            }
        }
        
        int leftCount = rootIdx - inL;
        int rightCount = inR - rootIdx;
        root.left = getTree(inorder, postorder, inL, rootIdx - 1, postL, postL + leftCount - 1);
        root.right = getTree(inorder, postorder, rootIdx + 1, inR, postR - rightCount, postR - 1);
        return root;
    }
}