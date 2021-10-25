class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> charIndex = new HashMap();
        
        int start = -1;
        for(int i = 0; i < s.length(); i++){
            start = Math.max(charIndex.getOrDefault(s.charAt(i), -1), start);
            max = Math.max(max, i - start);
            charIndex.put(s.charAt(i), i);
        }
        
        return max;
    }
}