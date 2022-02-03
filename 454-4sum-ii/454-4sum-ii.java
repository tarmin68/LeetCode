class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> sum1Count = new HashMap();
        HashMap<Integer, Integer> sum2Count = new HashMap();
        
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int sum = nums1[i] + nums2[j];
                sum1Count.put(sum, sum1Count.getOrDefault(sum, 0) + 1);
            }
        }
        
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                int sum = nums3[i] + nums4[j];
                sum2Count.put(sum, sum2Count.getOrDefault(sum, 0) + 1);
            }
        }
        
        int res = 0;
        
        for(int sum : sum1Count.keySet()){
            if(sum2Count.get(0 - sum) != null){
                res += sum1Count.get(sum) * sum2Count.get(0 - sum);
            }
        }
        
        return res;
    }
}