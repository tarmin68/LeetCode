class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> idxMap = new HashMap();
        int start = -1;
        int maxSub = 0;
        
        for(int i = 0; i < s.length(); i++){
            int prev = idxMap.getOrDefault(s.charAt(i), -1);
            start = Math.max(start, prev);
            maxSub = Math.max(maxSub, i - start);
            idxMap.put(s.charAt(i), i);
        }
        
        return maxSub;
    }
}