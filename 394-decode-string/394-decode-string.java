class Solution {
    int idx = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        while(idx < s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int repeat = 0;
                while(Character.isDigit(s.charAt(idx))){
                    repeat *= 10;
                    repeat += s.charAt(idx++) - '0';
                }
                idx++;
                String word = decodeString(s);
                for(int i = 0; i < repeat; i++){
                    sb.append(word);
                }
            }
            else if(s.charAt(idx) == ']'){
                return sb.toString();
            }
            else{
                sb.append(s.charAt(idx));
            }
            idx++;
        }
        
        return sb.toString();
    }
}