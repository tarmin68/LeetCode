class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        
        for(int i = 0; i < s.length(); i++){
            int ps = 0;
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == '('){
                    ps++;
                }
                else{
                    ps--;
                }
                if(ps == 0){
                    max = Math.max(max, j - i + 1);
                }
                if(ps < 0)
                    break;
            }
        }
        
        return max;
    }
}