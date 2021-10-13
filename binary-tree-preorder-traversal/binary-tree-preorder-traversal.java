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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> s = new Stack();
        s.push(root);
        
        TreeNode currNode = new TreeNode();
        while(!s.isEmpty()){
            currNode = s.pop();
            if(currNode != null){
                res.add(currNode.val);
                s.push(currNode.right);
                s.push(currNode.left);
            }
        }
        return res;
    }
}