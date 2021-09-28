class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomChar = new int[26];
        int[] magChar = new int[26];
        
        for(int i = 0; i < ransomNote.length(); i++){
            ransomChar[ransomNote.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < magazine.length(); i++){
            magChar[magazine.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(magChar[i] < ransomChar[i])
                return false;
        }
        
        return true;
    }
}