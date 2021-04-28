class Solution {
    TrieNode root = new TrieNode();
    Set<Integer> isChecked = new HashSet();
    public boolean wordBreak(String s, List<String> wordDict) {
        buildTrie(wordDict);
        
        return checkWord(s, 0);
    }
    
    public boolean checkWord(String s, int start){
        if(isChecked.contains(start))
            return false;
        
        if(start == s.length())
            return true;
        
        TrieNode currNode = root;
        for(int i = start; i < s.length(); i++){
            if(currNode.children[s.charAt(i) - 'a'] == null){
                isChecked.add(start);
                return false;
            }
            else{
                currNode = currNode.children[s.charAt(i) - 'a'];
                if(currNode.isWord && checkWord(s, i + 1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void buildTrie(List<String> wordDict){
        for(int i = 0; i < wordDict.size(); i++){
            TrieNode currNode = root;
            String currWord = wordDict.get(i);
            for(int j = 0; j < currWord.length(); j++){
                if(currNode.children[currWord.charAt(j) - 'a'] == null){
                    currNode.children[currWord.charAt(j) - 'a'] = new TrieNode();
                }
                currNode = currNode.children[currWord.charAt(j) - 'a'];
            }
            currNode.isWord = true;
        }
    }
    
    public class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
}