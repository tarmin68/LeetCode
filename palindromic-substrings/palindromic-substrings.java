class Solution {
    public int countSubstrings(String s) {
        boolean[][] isPalind = new boolean[s.length()][s.length()];
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            isPalind[i][i] = true;
            count++;
        }
        
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                isPalind[i][i + 1] = true;
                count++;
            }
        }
        
        for(int i = 2; i < s.length(); i++){
            for(int j = 0; j + i < s.length(); j++){
                if(s.charAt(j) == s.charAt(j + i) && isPalind[j + 1][j + i - 1]){
                    isPalind[j][j + i] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}