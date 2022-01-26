class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> numMap = new HashMap();
        int[] maxLength = new int[arr.length];
        
        int max = 1;
        for(int i = arr.length - 1; i >= 0; i--){
            maxLength[i] = 1;
            if(numMap.get(arr[i] + difference) != null)
                maxLength[i] += maxLength[numMap.get(arr[i] + difference)];
            max = Math.max(max, maxLength[i]);
            numMap.put(arr[i], i);
        }
        
        return max;
    }
}