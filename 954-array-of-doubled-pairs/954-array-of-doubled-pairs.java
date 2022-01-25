class Solution {
    public boolean canReorderDoubled(int[] arr) {
        ArrayList<Integer> nums = new ArrayList();
        HashMap<Integer, Integer> doubles = new HashMap();
        
        for(int i = 0; i < arr.length; i++){
            nums.add(arr[i]);
            doubles.put(arr[i], doubles.getOrDefault(arr[i], 0) + 1);
        }
        
        nums.sort((a,b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        
        for(int i = 0; i < nums.size(); i++){
            int count1 = doubles.get(nums.get(i));
            if(count1 > 0){
                if(doubles.get(nums.get(i) * 2) == null || doubles.get(nums.get(i) * 2) == 0)
                    return false;
                doubles.put(nums.get(i), doubles.get(nums.get(i)) - 1);
                doubles.put(nums.get(i) * 2, doubles.get(nums.get(i) * 2) - 1);
            }
        }
        
        return true;
    }
}