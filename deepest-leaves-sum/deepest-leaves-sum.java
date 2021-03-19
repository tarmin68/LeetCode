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
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int sum = 0;
        while(!q.isEmpty()){
            sum = 0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode currNode = q.poll();
                sum += currNode.val;
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
            }
        }
        
        return sum;
    }
}