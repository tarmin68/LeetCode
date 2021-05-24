class Solution {
    public String toLowerCase(String s) {
        StringBuilder res = new StringBuilder();
        int diff = 'A' - 'a';
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                res.append((char)(s.charAt(i) - diff));
            }
            else{
                res.append(s.charAt(i));
            }
        }
        
        return res.toString();
    }
}