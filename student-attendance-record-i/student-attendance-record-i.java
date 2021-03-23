class Solution {
    public boolean checkRecord(String s) {
        int absCount = 0;
        int lateCount = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'A'){
                absCount++;
                lateCount  = 0;
                if(absCount > 1) return false;
            }
            else if(s.charAt(i) == 'L'){
                lateCount++;
                if(lateCount > 2) return false;
            }
            else{
                lateCount = 0;
            }
        }
        
        return true;
    }
}