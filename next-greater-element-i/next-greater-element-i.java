class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreators = new HashMap();
        
        for(int i = 0; i < nums2.length; i++){
            nextGreators.put(nums2[i], -1);
            for(int j = i + 1; j < nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    nextGreators.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = nextGreators.get(nums1[i]);
        }
        
        return res;
    }
}