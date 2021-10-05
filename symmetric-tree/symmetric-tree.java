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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode[] currLevel = new TreeNode[size];
            for(int i = 0; i < size; i++){
                currLevel[i] = q.remove();
                if(currLevel[i] != null){
                    q.add(currLevel[i].left);
                    q.add(currLevel[i].right);
                }
            }
            for(int i = 0; i < size / 2; i++){
                if(currLevel[i] == null && currLevel[size - 1 - i] == null)
                    continue;
                if(currLevel[i] == null || currLevel[size - 1 - i] == null)
                    return false;
                if(currLevel[i].val != currLevel[size - 1 - i].val)
                    return false;
            }
        }
        
        return true;
    }
}