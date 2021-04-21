/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Deque<Node> myStack = new LinkedList();
        myStack.push(root);
        
        while(!myStack.isEmpty()){
            Node currNode = myStack.pop();
            res.add(currNode.val);
            for(int i = currNode.children.size() - 1; i >= 0; i--){
                myStack.push(currNode.children.get(i));
            }
        }
        
        return res;
    }
}