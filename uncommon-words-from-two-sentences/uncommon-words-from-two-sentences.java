class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        
        String[] AWords = A.split(" ");
        String[] BWords = B.split(" ");
        
        for(int i = 0 ; i < AWords.length; i++){
            if(!AWords[i].equals("")){
                int prevCount = wordCounts.getOrDefault(AWords[i], 0);
                wordCounts.put(AWords[i], prevCount + 1);
            }
        }
        
        for(int i = 0 ; i < BWords.length; i++){
            if(!BWords[i].equals("")){
                int prevCount = wordCounts.getOrDefault(BWords[i], 0);
                wordCounts.put(BWords[i], prevCount + 1);
            }
        }
        
        ArrayList<String> uncommons = new ArrayList<>();
        for(String word: wordCounts.keySet()){
            if(wordCounts.get(word) == 1){
                uncommons.add(word);
            }
        }
        
        return uncommons.toArray(new String[uncommons.size()]);
    }
}