class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> myStack = new LinkedList();
        
        char currChar = s.charAt(0);
        int currCount = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == currChar){
                currCount++;
            }
            else{
                if(!myStack.isEmpty() && myStack.peek().getKey() == currChar){
                    Pair<Character, Integer> prevPair = myStack.pop();
                    currCount += prevPair.getValue();
                }
                if(currCount % k != 0){
                    myStack.push(new Pair(currChar, currCount % k));
                }
                currChar = s.charAt(i);
                currCount = 1;
            }
        }
        
        if(!myStack.isEmpty() && myStack.peek().getKey() == currChar){
            Pair<Character, Integer> prevPair = myStack.pop();
            currCount += prevPair.getValue();
        }
        if(currCount % k != 0){
            myStack.push(new Pair(currChar, currCount % k));
        }
        
        StringBuilder result = new StringBuilder();
        while(!myStack.isEmpty()){
            Pair<Character, Integer> currPair = myStack.pop();
            for(int i = 0; i < currPair.getValue(); i++){
                result.append(currPair.getKey());
            }
        }
        
        return result.reverse().toString();
    }
}