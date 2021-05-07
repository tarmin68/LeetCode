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
    public void flatten(TreeNode root) {
        Stack<TreeNode> myStack = new Stack();
        TreeNode currNode = root;
        while(currNode != null && (currNode.left != null || currNode.right != null || !myStack.isEmpty())){
            if(currNode.left == null && currNode.right == null){
                currNode.right = myStack.pop();
            }
            else if(currNode.left != null && currNode.right != null){
                myStack.push(currNode.right);
                currNode.right = currNode.left;
                currNode.left = null;
            }
            else if(currNode.right == null){
                currNode.right = currNode.left;
                currNode.left = null;
            }
            currNode = currNode.right; 
        }
    }
}