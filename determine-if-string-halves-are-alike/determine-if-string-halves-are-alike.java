class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> mySet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int N = s.length();
        
        int count = 0;
        for(int i = 0; i < N / 2; i++){
            if(mySet.contains(s.charAt(i)))
                count++;
        }
        for(int i = N / 2; i < N; i++){
            if(mySet.contains(s.charAt(i)))
                count--;
        }
        
        return count == 0;
    }
}