class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        for(int j = 0; j < s.length() - 1; j++){
            boolean isValid = true;
            int k = j + 1;
            while(k < s.length()){
                for(int i = 0; i <= j; i++){
                    if(k + i >= s.length()){
                        isValid = false;
                        break;
                    }
                    if(s.charAt(i) != s.charAt(k + i)){
                        isValid = false;
                        break;
                    } 
                }
                k += (j + 1);
            }
            
            if(isValid) return true;
        }
        
        return false;
    }
}