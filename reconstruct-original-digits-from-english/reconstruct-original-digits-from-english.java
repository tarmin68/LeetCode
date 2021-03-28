class Solution {
    int[] charCount = new int[26];
    
    public String originalDigits(String s) {
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }
        
        String[] digitsString = new String[]{"zero", "one", "two", "three", "four", "five", "six",
                                             "seven", "eight", "nine"};
        char[] digitImptChar = new char[]{'z','o','w','h', 'f', 'v', 'x', 's', 'g', 'i'};
        int[] digitsOrder = new int[]{0, 2, 6, 8, 7, 5, 4, 3, 1, 9};
        
        int[] digitsCount = new int[10];
        for(int i = 0; i < digitsOrder.length; i++){
            int digit = digitsOrder[i];
            digitsCount[digit] = getCount(digitsString[digit], digitImptChar[digit]);
        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < digitsCount[i] ; j++){
                res.append("" + i);
            }
        }
        
        return res.toString();
    }
    
    public int getCount(String num, char imptChar){
        int imptCount = charCount[imptChar - 'a'];
        
        for(int i = 0; i < num.length(); i++){
            charCount[num.charAt(i) - 'a'] -= imptCount;
        }
        
        return imptCount;
    }
}