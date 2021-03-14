class Solution {
    HashMap<Integer, Long> treeCount;
    Set<Integer> numSet;
    public int numFactoredBinaryTrees(int[] arr) {
        treeCount = new HashMap();
        numSet = new HashSet<>();
        
        for(int i = 0; i < arr.length; i++){
            numSet.add(arr[i]);
        }
        
        long count = 0;
        for(int i = 0; i < arr.length; i++){
            count = (count + getNum(arr[i])) % 1000000007;
        }
        
        return (int) count;
    }
    
    public long getNum(Integer num){
        if(treeCount.get(num) != null) return treeCount.get(num);
        
        long count = 0;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0 && numSet.contains(i) && numSet.contains(num / i)){
                long childCount1 = getNum(i);
                long childCount2 = getNum(num / i);
                if(i != num / i){
                    count = count + (((childCount1 * childCount2) %  1000000007) * 2) % 1000000007;
                }
                else{
                    count = count + ((childCount1 * childCount2) %  1000000007);
                }
            }
        }
        count++;
        
        treeCount.put(num, count % 1000000007);
        return count % 1000000007;
    }
}