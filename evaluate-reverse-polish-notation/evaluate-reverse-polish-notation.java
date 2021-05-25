class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new LinkedList(); 
        
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int num2 = Integer.valueOf(nums.pop());
                int num1 = Integer.valueOf(nums.pop());
                nums.push(num1 + num2);
            }
            else if(tokens[i].equals("-")){
                int num2 = Integer.valueOf(nums.pop());
                int num1 = Integer.valueOf(nums.pop());
                nums.push(num1 - num2);
            }
            else if(tokens[i].equals("*")){
                int num2 = Integer.valueOf(nums.pop());
                int num1 = Integer.valueOf(nums.pop());
                nums.push(num1 * num2);
            }
            else if(tokens[i].equals("/")){
                int num2 = Integer.valueOf(nums.pop());
                int num1 = Integer.valueOf(nums.pop());
                nums.push(num1 / num2);
            }
            else{
                nums.push(Integer.valueOf(tokens[i]));
            }
        }
        
        return nums.pop();
    }
}