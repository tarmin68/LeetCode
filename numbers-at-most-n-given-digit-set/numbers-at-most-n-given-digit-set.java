class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
       int[] digitInts = new int[digits.length];
        for(int i = 0; i < digits.length; i++){
            digitInts[i] = digits[i].charAt(0) - '0';
        }
        
        ArrayList<Integer> nDigits = getDigits(n);
        int count = 0;
        for(int i = 1; i < nDigits.size(); i++){
            count += (int) Math.pow(digits.length, i);
        }
        
        int k = nDigits.size() - 1;
        while(k >= 0){
            for(int i = 0; i < digits.length; i++){
                if(digitInts[i] < nDigits.get(k)){
                    count += (int) Math.pow(digits.length, k);
                }
                else if(digitInts[i] == nDigits.get(k) && k > 0){
                    k--;
                    i = -1;
                }
                else if(digitInts[i] == nDigits.get(k) && k == 0){
                    count++;
                }
            }
            k = -1;
        }
        
        return count;
    }
    
    public ArrayList<Integer> getDigits(int n){
        ArrayList<Integer> res = new ArrayList<>();
        
        while(n > 0){
            res.add(n % 10);
            n = n / 10;
        }
        
        return res;
    }
}