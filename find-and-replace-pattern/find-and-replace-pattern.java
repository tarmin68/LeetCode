class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList();
        for(int i = 0; i < words.length; i++){
            if(match(words[i], pattern))
                res.add(words[i]);
        }
        
        return res;
    }
    
    public boolean match(String word, String pattern){
        if(word.length() != pattern.length())
            return false;
        
        HashMap<Character, Character> charMap = new HashMap();
        HashMap<Character, Character> reverseMap = new HashMap();
        
        for(int i = 0; i < word.length(); i++){
            if(charMap.get(pattern.charAt(i)) == null && reverseMap.get(word.charAt(i)) == null){
                charMap.put(pattern.charAt(i), word.charAt(i));
                reverseMap.put(word.charAt(i), pattern.charAt(i));
            }
            else if(charMap.get(pattern.charAt(i)) == null || reverseMap.get(word.charAt(i)) == null){
                return false;
            }
            else{
                if(charMap.get(pattern.charAt(i)) != word.charAt(i) || 
                   reverseMap.get(word.charAt(i)) != pattern.charAt(i)){
                    return false;
                }
            }
        }
        
        return true;
    }
}