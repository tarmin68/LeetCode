class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new LinkedList();
        
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int num2 = s.pop();
                int num1 = s.pop();
                s.push(num1 + num2); 
            }
            else if(tokens[i].equals("-")){
                int num2 = s.pop();
                int num1 = s.pop();
                s.push(num1 - num2);
            }
            else if(tokens[i].equals("*")){
                int num2 = s.pop();
                int num1 = s.pop();
                s.push(num1 * num2);
            }
            else if(tokens[i].equals("/")){
                int num2 = s.pop();
                int num1 = s.pop();
                s.push(num1 / num2);
            }
            else{
                s.push(Integer.valueOf(tokens[i]));
            }
        }
        
        return s.pop();
    }
}