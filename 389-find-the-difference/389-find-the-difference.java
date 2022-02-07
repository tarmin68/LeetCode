class Solution {
    public char findTheDifference(String s, String t) {
        int[] charFreq1 = getFreq(s);
        int[] charFreq2 = getFreq(t);
        
        for(int i = 0; i < 26; i++){
            if(charFreq1[i] != charFreq2[i])
                return (char)('a' + i);
        }
        
        return 'a';
    }
    
    public int[] getFreq(String s){
        int[] charFreq = new int[26];
        
        for(int i = 0; i < s.length(); i++){
            charFreq[s.charAt(i) - 'a']++;
        }
        
        return charFreq;
    }
}