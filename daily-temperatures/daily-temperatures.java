class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        HashMap<Integer, Integer> tempDay = new HashMap();
        
        for(int i = T.length - 1; i >= 0; i--){
            tempDay.put(T[i], i);
            int min = T.length;
            for(int j = T[i] + 1; j <= 100; j++){
                if(tempDay.get(j) != null){
                    min = Math.min(min, tempDay.get(j));
                }
            }
            if(min != T.length)
                ans[i] = min - i;
        }
        
        return ans;
    }
}