class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++){
            if(currNode.nextChar[word.charAt(i) - 'a'] == null)
                currNode.nextChar[word.charAt(i) - 'a'] = new TrieNode();
            currNode = currNode.nextChar[word.charAt(i) - 'a'];
        }
        currNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currNode = root;
        for(int i = 0; i < word.length(); i++){
            if(currNode.nextChar[word.charAt(i) - 'a'] == null)
                return false;
            currNode = currNode.nextChar[word.charAt(i) - 'a'];
        }
        return currNode.isWord == true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for(int i = 0; i < prefix.length(); i++){
            if(currNode.nextChar[prefix.charAt(i) - 'a'] == null)
                return false;
            currNode = currNode.nextChar[prefix.charAt(i) - 'a'];
        }
        return true;
    }
    
    public class TrieNode{
        TrieNode[] nextChar = new TrieNode[26];
        boolean isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */