class Solution {
    public int firstUniqChar(String s) {
        int[][] charCount = new int[26][2];
        
        for(int i = 0; i < 26; i++){
            charCount[i][1] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a'][0]++;
            charCount[s.charAt(i) - 'a'][1] = Math.min(charCount[s.charAt(i) - 'a'][1], i);
        }
        
        int minIdx = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(charCount[i][0] == 1){
                minIdx = Math.min(minIdx, charCount[i][1]);
            }
        }
        
        if(minIdx == Integer.MAX_VALUE)
            return -1;
        else
            return minIdx;
    }
}