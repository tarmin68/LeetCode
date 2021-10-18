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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair<TreeNode, TreeNode>> q = new LinkedList();
        q.add(new Pair(root, root));
        
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode parent = null;
            for(int i = 0; i < size; i++){
                Pair<TreeNode, TreeNode> curr = q.remove();
                if(curr.getKey().val == x || curr.getKey().val == y){
                    if(parent != null)
                        return parent.val != curr.getValue().val;
                    else
                        parent = curr.getValue();
                }
                if(curr.getKey().left != null)
                    q.add(new Pair(curr.getKey().left, curr.getKey()));
                if(curr.getKey().right != null)
                    q.add(new Pair(curr.getKey().right, curr.getKey()));
            }
        }
        
        return false;
    }
}