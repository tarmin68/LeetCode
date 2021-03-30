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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        checkFlip(root, voyage, 0, res);
        if(res.contains(-1)){
            return List.of(-1);
        }
        
        return res;
    }
    
    public int checkFlip(TreeNode root, int[] voyage, int index, List<Integer> res){
        if(root == null || index == voyage.length)
            return index - 1;
        if(root.val != voyage[index]){
            res.add(-1);
            return -1;
        }
        if(root.left == null && root.right == null)
            return index;
        if(root.left != null && root.left.val != voyage[index + 1]){
            flip(root);
            res.add(root.val);
        }
        // if(root.left == null && root.right.val != voyage[index + 1]){
        //     flip(root);
        //     res.add(root.val);
        // }
        index = checkFlip(root.left, voyage, index + 1, res);
        index = checkFlip(root.right, voyage, index + 1, res);
        
        return index;
    }
    
    public void flip(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    
}