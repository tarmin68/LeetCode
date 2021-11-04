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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<Pair<TreeNode, String>> q = new LinkedList();
        
        if(root == null)
            return sum;
        
        q.add(new Pair(root, "r"));
        while(!q.isEmpty()){
            Pair<TreeNode, String> curr = q.remove();
            TreeNode currNode = curr.getKey();
            String currVal = curr.getValue();
            
            if(currNode.left == null && currNode.right == null && currVal.equals("l"))
                sum += currNode.val;
            else{
                if(currNode.left != null)
                    q.add(new Pair(currNode.left, "l"));
                if(currNode.right != null)
                    q.add(new Pair(currNode.right, "r"));
            }
        }
        return sum;
    }
}