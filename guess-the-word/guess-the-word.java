/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int[][] matchCounts = new int[wordlist.length][wordlist.length];
        boolean[] notValid = new boolean[wordlist.length];
        
        PriorityQueue<WordMatch> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < wordlist.length; i++){
            int currCount = 0;
            for(int j = 0; j < wordlist.length; j++){
                int match = getMatchCount(wordlist[i], wordlist[j]);
                currCount += match;
                matchCounts[i][j] = match;
            }
            pq.add(new WordMatch(i, currCount));
        }
        
        while(!pq.isEmpty()){
            int i = pq.poll().index;
            while(notValid[i])
                i = pq.poll().index;
            String guess = wordlist[i];
            int matchNum = master.guess(guess);
            if(matchNum == 6) return;
            for(int j = 0; j < wordlist.length; j++){
                if(matchCounts[i][j] != matchNum){
                    notValid[j] = true;
                }
            }
            i++;
        }
    }
    
    public int getMatchCount(String s1, String s2){
        int count = 0; 
        for(int i = 0; i < 6; i++){
            if(s1.charAt(i) == s2.charAt(i))
                count++;
        }
        return count;
    }
    
    public class WordMatch implements Comparable<WordMatch>{
        int index;
        int totalMatch;
        
        public WordMatch(int index, int totalMatch){
            this.index = index;
            this.totalMatch = totalMatch;
        }
        
        @Override
        public int compareTo(WordMatch m){
            return Integer.compare(totalMatch, m.totalMatch);
        }
    }
}