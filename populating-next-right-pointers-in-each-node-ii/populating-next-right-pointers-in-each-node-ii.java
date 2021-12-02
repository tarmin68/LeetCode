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
        
        Node head = root;
        Node nextHead = null;
        while(head != null){
            if(nextHead == null && head.left != null)
                nextHead = head.left;
            if(nextHead == null && head.right != null)
                nextHead = head.right;
            
            if(head.left != null){
                if(head.right != null)
                    head.left.next = head.right;
                else{
                    Node next = head.next;
                    while(next != null && next.left == null && next.right == null)
                        next = next.next;
                    if(next != null){
                        if(next.left != null)
                            head.left.next = next.left;
                        else
                            head.left.next = next.right;
                    }
                }
            }
            if(head.right != null){
                Node next = head.next;
                while(next != null && next.left == null && next.right == null)
                    next = next.next;
                if(next != null){
                    if(next.left != null)
                        head.right.next = next.left;
                    else
                        head.right.next = next.right;
                }
            }
            
            if(head.next != null)
                head = head.next;
            else{
                head = nextHead;
                nextHead = null;
            }
        }
        
        return root;
    }
}