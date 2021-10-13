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
    public TreeNode bstFromPreorder(int[] preorder) {
        return getSubTree(preorder, 0, preorder.length - 1);
    }
    
    public TreeNode getSubTree(int[] preorder, int rootIdx, int end){
        TreeNode root = new TreeNode(preorder[rootIdx]);
        int leftIdx = rootIdx;
        
        while(leftIdx < end && preorder[leftIdx + 1] < preorder[rootIdx]){
            leftIdx++;
        }
        
        if(leftIdx != rootIdx){
            root.left = getSubTree(preorder, rootIdx + 1, leftIdx);
        }
        if(leftIdx < end){
            root.right = getSubTree(preorder, leftIdx + 1, end);
        }
        
        return root;
    }
}