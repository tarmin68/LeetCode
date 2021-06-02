class Solution {
    Boolean[][][] isChecked;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        
        isChecked = new Boolean[s3.length()][s3.length()][s3.length()];
        
        return checkInterleave(s1, s2, s3, 0, 0, 0);
    }
    
    public boolean checkInterleave(String s1, String s2, String s3, int idx1, int  idx2, int idx3){
        if(idx3 == s3.length())
            return true;
        
        if(isChecked[idx1][idx2][idx3] != null)
            return isChecked[idx1][idx2][idx3];
        
        boolean check1 = false;
        if(idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)){
            check1 =  checkInterleave(s1, s2, s3, idx1 + 1, idx2, idx3 + 1);
        }
        boolean check2 = false;
        if(idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)){
            check2 =  checkInterleave(s1, s2, s3, idx1, idx2 + 1, idx3 + 1);
        }
        
        isChecked[idx1][idx2][idx3] = check1 || check2;
        return check1 || check2;
    }
}