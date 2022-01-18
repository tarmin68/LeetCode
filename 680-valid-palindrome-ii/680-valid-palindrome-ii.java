class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1,true);
    }
    
    public boolean isPalindrome(String s, int i, int j, boolean canDel){
        if(j <= i)
            return true;
        
        if(s.charAt(i) == s.charAt(j))
            return isPalindrome(s, i + 1, j - 1, canDel);
        else{
            if(canDel){
                return isPalindrome(s, i + 1, j, false) || isPalindrome(s, i, j - 1, false);
            }
            else
                return false;
        }
    }
}