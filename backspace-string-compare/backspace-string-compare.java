class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sCount = 0;
        int tCount = 0;
        
        while(i >= 0 || j >= 0){
            while(i >= 0 && s.charAt(i) == '#'){
                sCount++;
                i--;
            }
            while(i >= 0 && s.charAt(i) != '#' && sCount > 0){
                sCount--;
                i--;
            }
            while(j >= 0 && t.charAt(j) == '#'){
                tCount++;
                j--;
            }
            while(j >= 0 && t.charAt(j) != '#' && tCount > 0){
                tCount--;
                j--;
            }
            if(i >= 0 && j >= 0 && s.charAt(i) != '#' && t.charAt(j) != '#'){
                if(s.charAt(i) == t.charAt(j)){
                    i--;
                    j--;
                }
                else
                    return false;
            }
            if(i < 0 && j >= 0 && t.charAt(j) != '#')
                return false;
            if(j < 0 && i >= 0 && s.charAt(i) != '#')
                return false;
        }
        
        return true;
    }
}