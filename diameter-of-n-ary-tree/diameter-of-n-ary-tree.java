/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        return getMaxDiameter(root);
    }
    
    public int getMaxDiameter(Node root){
        if(root == null)
            return 0;
        
        int maxPath1 = 0;
        int maxPath2 = 0;
        
        for(Node child : root.children){
            int maxPath = getMaxPath(child);
            if(maxPath > maxPath1){
                maxPath2 = maxPath1;
                maxPath1 = maxPath;
            }
            else if(maxPath > maxPath2){
                maxPath2 = maxPath;
            }
        }
        
        int maxPath3 = Integer.MIN_VALUE;
        for(Node child : root.children){
            maxPath3 = Math.max(maxPath3, getMaxDiameter(child));
        }
        
        return Math.max(maxPath1 + maxPath2 , maxPath3);
    }
    
    public int getMaxPath(Node root){
        if(root.children.size() == 0)
            return 1;
        
        int max = Integer.MIN_VALUE;
        for(Node child : root.children){
            max = Math.max(max, getMaxPath(child));
        }
        
        return max + 1;
    }
}