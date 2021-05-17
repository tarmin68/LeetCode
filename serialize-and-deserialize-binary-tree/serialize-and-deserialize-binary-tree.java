/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null)
                res.append("#,");
            else{
                res.append(currNode.val + ",");
                q.add(currNode.left);
                q.add(currNode.right);
            }
        }
        
        return res.deleteCharAt(res.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes[0].equals("#"))
            return null;
        
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        q.add(root);
        
        int i = 1;
        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(!nodes[i].equals("#")){
                currNode.left = new TreeNode(Integer.valueOf(nodes[i]));
                q.add(currNode.left);
            }
            i++;
            if(!nodes[i].equals("#")){
                currNode.right = new TreeNode(Integer.valueOf(nodes[i]));
                q.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));