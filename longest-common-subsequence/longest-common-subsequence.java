class Solution {
    int[][] maxLCS;
    public int longestCommonSubsequence(String text1, String text2) {
        maxLCS = new int[text1.length()][text2.length()];
        
        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(maxLCS[i], -1);
        }
        
        return getLCS(text1, text2, 0, 0);
    }
    
    public int getLCS(String s1, String s2, int idx1, int idx2){
        if(idx1 >= s1.length()) return 0;
        if(idx2 >= s2.length()) return 0;
        
        if(maxLCS[idx1][idx2] != -1) return maxLCS[idx1][idx2];
        
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            maxLCS[idx1][idx2] = 1 + getLCS(s1, s2, idx1 + 1, idx2 + 1);
        }
        else{
            int max1 = getLCS(s1, s2, idx1 + 1, idx2);
            int max2 = getLCS(s1, s2, idx1, idx2 + 1);
            maxLCS[idx1][idx2] = Math.max(max1, max2);
        }
        
        return maxLCS[idx1][idx2];
    }
}