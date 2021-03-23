class Solution {
    public String removeOuterParentheses(String S) {
        if(S.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < S.length(); i++){
            if(S.charAt(i) == '(')
                s.push(i);
            else{
                int prevId = s.pop();
                if(s.isEmpty()){
                    res.append(S.substring(prevId + 1, i));
                }
            }
        }
        
        return res.toString();
    }
}