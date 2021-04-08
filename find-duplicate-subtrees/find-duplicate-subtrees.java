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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, TreeNode> allTrees = new HashMap();
        Set<TreeNode> res = new HashSet();
        getTree(root, allTrees, res);
        return new ArrayList(res);
    }
    
    public String getTree(TreeNode root, HashMap<String, TreeNode> allTrees, Set<TreeNode> res){
        if(root == null){
            return "";
        }
        
        StringBuilder subtree = new StringBuilder();
        subtree.append("l" + getTree(root.left, allTrees, res));
        subtree.append(root.val);
        subtree.append("r" + getTree(root.right, allTrees, res));
        
        if(allTrees.get(subtree.toString()) != null){
            res.add(allTrees.get(subtree.toString()));
        }
        else{
            allTrees.put(subtree.toString(), root);
        }
        
        return subtree.toString();
    }
}