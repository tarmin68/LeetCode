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
    TreeMap<Integer, ArrayList<Integer>> colMap;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        colMap = new TreeMap();
        
        List<List<Integer>> res = new ArrayList();
        if(root == null)
            return res;
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair<TreeNode, Integer> currNode = q.remove();
            colMap.putIfAbsent(currNode.getValue(), new ArrayList<Integer>());
            colMap.get(currNode.getValue()).add(currNode.getKey().val);
            
            if(currNode.getKey().left != null)
                q.add(new Pair(currNode.getKey().left, currNode.getValue() - 1));
            
            if(currNode.getKey().right != null)
                q.add(new Pair(currNode.getKey().right, currNode.getValue() + 1));
        }
        
        for(Integer colNum : colMap.keySet()){
            res.add(colMap.get(colNum));
        }
        
        return res;
    }
    
}