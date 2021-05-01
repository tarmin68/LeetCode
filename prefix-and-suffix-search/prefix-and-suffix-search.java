class WordFilter {
    HashMap<String, ArrayList<Integer>> allPrefixes;
    HashMap<String, Set<Integer>> allSuffixes;
    public WordFilter(String[] words) {
        allPrefixes = new HashMap();
        allSuffixes = new HashMap();
        
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                allPrefixes.putIfAbsent(words[i].substring(0, j + 1), new ArrayList<Integer>());
                allPrefixes.get(words[i].substring(0, j + 1)).add(i);
                
                allSuffixes.putIfAbsent(words[i].substring(words[i].length() - j - 1), new HashSet<Integer>());
                allSuffixes.get(words[i].substring(words[i].length() - j - 1)).add(i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        if(allPrefixes.get(prefix) == null || allSuffixes.get(suffix) == null)
            return -1;
        
        ArrayList<Integer> canPreWords = allPrefixes.get(prefix);
        Set<Integer> canSufWords = allSuffixes.get(suffix);
        
        for(int i = canPreWords.size() - 1; i >= 0; i--){
            if(canSufWords.contains(canPreWords.get(i)))
                return canPreWords.get(i);
        }
        
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */