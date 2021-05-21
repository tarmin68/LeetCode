class Solution {
    public boolean isMatch(String s, String p) {
        return check(s, p, 0, 0);
    }
    
    public boolean check(String s, String p, int idx1, int idx2){
        if(idx1 == s.length() && idx2 == p.length())
            return true;
        
        if(idx2 == p.length())
            return false;
        
        if(idx1 == s.length()){
            while(idx2 + 1 < p.length() && p.charAt(idx2 + 1) == '*')
                idx2 = idx2 + 2;
            
            return idx2 >= p.length();
        }
        
        if(idx2 + 1 < p.length() && p.charAt(idx2 + 1) == '*'){
            if(s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.')
                return check(s, p, idx1 + 1, idx2) || check(s, p, idx1 + 1, idx2 + 2) || check(s, p, idx1, idx2 + 2);
            else
                return check(s, p, idx1, idx2 + 2);
        }
        
        if(s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.')
            return check(s, p, idx1 + 1, idx2 + 1);
        else
            return false;
    }
}