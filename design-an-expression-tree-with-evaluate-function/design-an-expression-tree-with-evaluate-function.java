/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
}

class MyNode extends Node{
    Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    String token;
    MyNode left;
    MyNode right;
    
    public MyNode(String token){
        this.token = token;
    }
    public int evaluate(){
        if(!operators.contains(this.token)){
            return Integer.valueOf(this.token);
        }
        else{
            int left = this.left.evaluate();
            int right = this.right.evaluate();
            
            switch(token){
                case "+":
                    return left + right;
                case "-":
                    return left - right;
                case "*":
                    return left * right;
                case "/":
                    return left / right;
                default:
                    return 0;
            }
        }
    }
};


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    
    Node buildTree(String[] postfix) {
        Stack<MyNode> tokens = new Stack();
        
        for(int i = 0; i < postfix.length; i++){
            if(operators.contains(postfix[i])){
                MyNode right = tokens.pop();
                MyNode left = tokens.pop();
                MyNode root = new MyNode(postfix[i]);
                root.left = left;
                root.right = right;
                tokens.push(root);
            }
            else{
                tokens.push(new MyNode(postfix[i]));
            }
        }
        
        return tokens.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */