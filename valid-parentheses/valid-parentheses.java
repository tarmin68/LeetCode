class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> charMap = new HashMap();
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');
        Stack<Character> charStack = new Stack();
        
        for(int i = 0; i < s.length(); i++){
            if(charMap.keySet().contains(s.charAt(i))){
                charStack.push(s.charAt(i));
            }
            else{
                if(charStack.isEmpty())
                    return false;
                else{
                    if(charMap.get(charStack.pop()) != s.charAt(i))
                        return false;
                }
            }
        }
        
        return charStack.isEmpty();
    }
}