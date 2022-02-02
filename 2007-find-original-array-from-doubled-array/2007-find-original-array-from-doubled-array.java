class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] res = new int[changed.length / 2];
        HashMap<Double, Integer> numMap = new HashMap();
        
        for(int i = 0; i < changed.length; i++){
            numMap.put(changed[i] * 1.0, numMap.getOrDefault(changed[i] * 1.0, 0) + 1);
        }
        Arrays.sort(changed);
        
        int idx = 0;
        for(int i = changed.length - 1; i >= 0; i--){
            if(numMap.getOrDefault(changed[i] * 1.0, 0) != 0){
                numMap.put(changed[i] * 1.0, numMap.get(changed[i] * 1.0) - 1);
                if(numMap.getOrDefault(changed[i] / 2.0, 0) == 0)
                    return new int[]{};
                else{
                    res[idx++] = changed[i] / 2;
                    numMap.put(changed[i] / 2.0, numMap.get(changed[i] / 2.0) - 1);
                }
            }
        }
        
        return res;
    }
}