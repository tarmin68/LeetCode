/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currNode = root;
        while(currNode.val != p.val && currNode.val != q.val){
            if(currNode.val < p.val && currNode.val > q.val)
                return currNode;
            if(currNode.val < q.val && currNode.val > p.val)
                return currNode;
            if(p.val < currNode.val && q.val < currNode.val)
                currNode = currNode.left;
            else
                currNode = currNode.right;
        }
        return currNode;
    }
}