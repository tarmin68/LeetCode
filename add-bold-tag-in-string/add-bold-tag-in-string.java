class Solution {
    public String addBoldTag(String s, String[] dict) {
        StringBuilder res = new StringBuilder();
        TrieNode root = buildTrie(dict);
        
        int start = 0;
        int end = -1;
        
        while(start < s.length()){
            for(int idx = start; idx < s.length() && idx <= end + 1; idx++){
                int currIdx = idx;
                TrieNode currNode = root;
                while(currIdx < s.length()){
                    if(currNode.nextChar[s.charAt(currIdx)] != null){
                        currNode = currNode.nextChar[s.charAt(currIdx)];
                        if(currNode.isWord){
                            end = Math.max(end, currIdx);
                        }
                        currIdx++;
                    }
                    else{
                        break;
                    }
                }
            }
            
            if(end >= start){
                res.append("<b>");
                res.append(s.substring(start, end + 1));
                res.append("</b>");
                start = end + 1;
            }
            else{
                res.append(s.charAt(start));
                start++;
                end++;
            }
        }
        
        return res.toString();
    }
    
    public TrieNode buildTrie(String[] dict){
        TrieNode root = new TrieNode();
        
        for(int i = 0; i < dict.length; i++){
            TrieNode currNode = root;
            String currWord = dict[i];
            for(int j = 0; j < currWord.length(); j++){
                if(currNode.nextChar[currWord.charAt(j)] == null){
                    currNode.nextChar[currWord.charAt(j)] = new TrieNode();
                }
                currNode = currNode.nextChar[currWord.charAt(j)] ;
            }
            currNode.isWord = true;
        }
        
        return root;
    }
    
    public class TrieNode{
        TrieNode[] nextChar;
        boolean isWord;
        
        public TrieNode(){
            this.nextChar = new TrieNode[256];
        }
    }
}