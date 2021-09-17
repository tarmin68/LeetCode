class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) 
            return false;
        
        int[] freq1 = getFreq(s1);
        int[] freq2 = getFreq(s2.substring(0, s1.length()));
        
        for(int i = 0; i + s1.length() < s2.length(); i++){
            if(Arrays.equals(freq1, freq2))
                return true;
            freq2[s2.charAt(i) - 'a']--;
            freq2[s2.charAt(i + s1.length()) - 'a']++;
        }
        
        if(Arrays.equals(freq1, freq2))
                return true;
        
        return false;
    }
    
    public int[] getFreq(String word){
        int[] freq = new int[28];
        
        for(int i = 0; i < word.length(); i++){
            freq[word.charAt(i) - 'a']++;
        }
        
        return freq;
    }
}