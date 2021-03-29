class Solution {
    public int numTilePossibilities(String tiles) {
        int[] charCounts = new int[26];
        
        for(int i = 0; i < tiles.length(); i++){
            charCounts[tiles.charAt(i) - 'A']++;
        }
        
        int count = 0;
        Queue<String> q = new LinkedList<>();
        
        for(int i = 0; i < 26; i++){
            if(charCounts[i] > 0){
                q.add(Character.toString((char)('A' + i)));
                count++;
            }
        }
        
        while(!q.isEmpty()){
            String currString = q.poll();
            for(int i = 0; i < currString.length(); i++){
                charCounts[currString.charAt(i) - 'A']--;
            }
            for(int i = 0; i < 26; i++){
                if(charCounts[i] > 0){
                    q.add(currString + Character.toString((char)('A' + i)));
                    count++;
                }
            }
            for(int i = 0; i < currString.length(); i++){
                charCounts[currString.charAt(i) - 'A']++;
            }
        }
        
        return count;
    }
}