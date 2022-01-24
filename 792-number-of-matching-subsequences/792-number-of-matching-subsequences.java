class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, TreeSet<Integer>> charMap = new HashMap();
        
        for(int i = 0; i < s.length(); i++){
            charMap.putIfAbsent(s.charAt(i), new TreeSet<Integer>());
            charMap.get(s.charAt(i)).add(i);
        }
        
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(isSubseq(charMap, words[i]))
                count++;
        }
        return count;
    }
    
    public boolean isSubseq(HashMap<Character, TreeSet<Integer>> charMap, String word){
        int nextIdx = -1;
        
        for(int i = 0; i < word.length(); i++){
            if(charMap.get(word.charAt(i)) == null)
                return false;
            if(charMap.get(word.charAt(i)).ceiling(nextIdx) == null)
                return false;
            nextIdx = charMap.get(word.charAt(i)).ceiling(nextIdx) + 1;
        }
        
        return true;
    }
}