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
    ArrayList<Integer> sortedNums = new ArrayList();
    public boolean findTarget(TreeNode root, int k) {
        inOrderTraversal(root);
        int i = 0;
        int j = sortedNums.size() - 1;
        while(i < j){
            int num1 = sortedNums.get(i); 
            int num2 = sortedNums.get(j); 
            if(num1 + num2 == k)
                return true;
            if(num1 + num2 > k)
                j--;
            else
                i++;
        }
        return false;
    }
    
    public void inOrderTraversal(TreeNode root){
        if(root == null)
            return;
        inOrderTraversal(root.left);
        sortedNums.add(root.val);
        inOrderTraversal(root.right);
    }
}