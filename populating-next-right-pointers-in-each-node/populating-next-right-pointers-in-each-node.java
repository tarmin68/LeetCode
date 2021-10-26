/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node currNode = q.remove();
            for(int i = 1; i < size; i++){
                Node next = q.remove();
                currNode.next = next;
                if(currNode.left != null)
                    q.add(currNode.left);
                if(currNode.right != null)
                    q.add(currNode.right);
                currNode = next;
            }
            if(currNode.left != null)
                    q.add(currNode.left);
            if(currNode.right != null)
                q.add(currNode.right);
        }
        
        return root;
    }
}