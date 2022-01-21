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
    HashMap<String, TreeNode> allTrees;
    Set<TreeNode> res;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        allTrees = new HashMap();
        res = new HashSet();
        
        checkDuplicate(root, true);
        return new ArrayList<TreeNode>(res);
    }
    
    public String checkDuplicate(TreeNode root, boolean isRight){
        if(root == null && isRight)
            return "r";
        
        if(root == null && !isRight)
            return "l";
        
        String left = checkDuplicate(root.left, false);
        String right = checkDuplicate(root.right, true);
        StringBuilder curr = new StringBuilder();
        curr.append(left);
        curr.append("," + root.val + ",");
        curr.append(right);
        
        if(allTrees.get(curr.toString()) != null)
            res.add(allTrees.get(curr.toString()));
        else
            allTrees.put(curr.toString(), root);
        
        return curr.toString();
    }
}