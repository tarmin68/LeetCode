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
    int currVal = Integer.MIN_VALUE;
    int currCount = 1;
    int currMax = 1;
    ArrayList<Integer> res = new ArrayList();
    
    public int[] findMode(TreeNode root) {
        getMode(root);
        
        int[] answer = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    
    public void getMode(TreeNode root){
        if(root == null)
            return;
        
        getMode(root.left);
        if(root.val == currVal){
            currCount++;
        }
        else{
            currCount = 1;
            currVal = root.val;
        }
        if(currCount > currMax){
            res = new ArrayList();
            res.add(currVal);
            currMax = currCount;
        }
        else if(currCount == currMax){
            res.add(currVal);
        }
        getMode(root.right);
    }
}