class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> subStrings = new HashSet<>();
        
        for(int i = 0; i <= s.length() - k; i++){
            subStrings.add(s.substring(i, i + k));
        }
        
        int totalSubs = (int) Math.pow(2, k);
        return subStrings.size() == totalSubs;
    }
}