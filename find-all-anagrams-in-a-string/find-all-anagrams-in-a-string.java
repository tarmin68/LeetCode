class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pChars = new int[26];
        int[] sChars = new int[26];
        List<Integer> res = new ArrayList();
        
        if(s.length() < p.length())
            return res;
        
        for(int i = 0; i < p.length(); i++){
            pChars[p.charAt(i) - 'a']++;
            sChars[s.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(pChars, sChars))
            res.add(0);
        
        for(int i = 0; i < s.length() - p.length(); i++){
            sChars[s.charAt(i) - 'a']--;
            sChars[s.charAt(i + p.length()) - 'a']++;
            if(Arrays.equals(pChars, sChars))
                res.add(i + 1);
        }
        
        return res;
    }
}