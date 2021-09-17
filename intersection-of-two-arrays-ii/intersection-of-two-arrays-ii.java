class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = getFreq(nums1);
        int[] freq2 = getFreq(nums2);
        
        int count = 0;
        for(int i = 0; i < 1001; i++){
            freq1[i] = Math.min(freq1[i], freq2[i]);
            count += freq1[i];
        }
        
        int[] res = new int[count];
        int k = 0;
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < freq1[i]; j++){
                res[k++] = i;
            }
        }
        
        return res;
    }
    
    public int[] getFreq(int[] nums){
        int[] freq = new int[1001];
        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;
        }
        
        return freq;
    }
}