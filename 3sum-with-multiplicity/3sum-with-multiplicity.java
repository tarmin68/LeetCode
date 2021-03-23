class Solution {
    long mod = 1000000007;
    public int threeSumMulti(int[] arr, int target) {
       ArrayList<Integer>[] myMap = new ArrayList[101];
        
        for(int i = 0; i < arr.length; i++){
            if(myMap[arr[i]] == null)
                myMap[arr[i]] = new ArrayList<Integer>();
            myMap[arr[i]].add(i);
        }
        
        long res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length - 1; j++){
                if(0 <= target - arr[i] - arr[j] && target - arr[i] - arr[j] <= 100 && myMap[target - arr[i] - arr[j]] != null){
                    ArrayList<Integer> cand = myMap[target - arr[i] - arr[j]];
                    int k = findIndex(cand, 0, cand.size() - 1, j);
                    if(k != -1){
                        res += cand.size() - k;
                    }
                }
            }
        }
        
        res = res % mod;
        return (int) res;
    }
    
    public int findIndex(ArrayList<Integer> values, int lo, int hi, int target){
        if(lo > hi) return -1;
        if(lo == hi && values.get(lo) > target) return lo;
        if(lo == hi && values.get(lo) <= target) return -1;
        
        int mid = (lo + hi)/2;
        if(values.get(mid) <= target)
            return findIndex(values, mid + 1, hi, target);
        else
            return findIndex(values, lo, mid, target);
    }
}