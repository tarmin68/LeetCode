class Solution {
    List<List<String>> res = new ArrayList();
    
    public List<List<String>> wordSquares(String[] words) {
        Trie t = new Trie();
        for(int i = 0; i < words.length; i++){
            t.addWord(words[i]);
        }
        int size = words[0].length();
        backTrack(t, "", 0, size, new ArrayList<String>());
        return res;
    }
    
    public void backTrack(Trie t, String prefix, int idx, int size, List<String> words){
        if(idx == size){
            res.add(new ArrayList<String>(words));
        }
        else{
            prefix = getPrefix(words);
            ArrayList<String> nextWords = t.getWords(prefix);
            if(nextWords != null){
                for(int i = 0; i < nextWords.size(); i++){
                    words.add(nextWords.get(i));
                    backTrack(t, prefix, idx + 1, size, words);
                    words.remove(words.size() - 1);
                }
            }
        }
    }
    
    public String getPrefix(List<String> words){
        int size = words.size();
        
        String prefix = "";
        for(int i = 0; i < size; i++){
            prefix += words.get(i).charAt(size);
        }
        
        return prefix;
    }
}

public class Trie{
    Trie[] nextChar;
    ArrayList<String> words;
    
    public Trie(){
        nextChar = new Trie[26];
        words = new ArrayList<String>();
    }
    
    public void addWord(String newWord){
        Trie curr = this;
        for(int i = 0; i < newWord.length(); i++){
            if(curr.nextChar[newWord.charAt(i) - 'a'] == null){
                curr.nextChar[newWord.charAt(i) - 'a'] = new Trie();
            }
            curr.words.add(newWord);
            curr = curr.nextChar[newWord.charAt(i) - 'a'];
        }
    }
    
    public ArrayList<String> getWords(String prefix){
        Trie curr = this;
        for(int i = 0; i < prefix.length(); i++){
            if(curr.nextChar[prefix.charAt(i) - 'a'] == null){
                return null;
            }
            curr = curr.nextChar[prefix.charAt(i) - 'a'];
        }
        return curr.words;
    }
}