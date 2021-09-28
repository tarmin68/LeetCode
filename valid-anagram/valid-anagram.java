class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sCharCount = getCharCounts(s);
        int[] tCharCount = getCharCounts(t);
        
        return Arrays.equals(sCharCount, tCharCount);
    }
    
    public int[] getCharCounts(String s){
        int[] charCount = new int[26];
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }
        
        return charCount;
    }
}