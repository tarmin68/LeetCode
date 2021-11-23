class Solution {
    public int largestComponentSize(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        
        UnionFind uf = new UnionFind(maxNum + 1);
        
        HashMap<Integer, Integer> numFactorMap = new HashMap();
        
        for(int i = 0; i < nums.length; i++){
            ArrayList<Integer> factors = getPrimeFactors(nums[i]);
            numFactorMap.put(nums[i], factors.get(0));
            for(int j = 0; j < factors.size() - 1; j++){
                uf.union(factors.get(j), factors.get(j + 1));
            }
        }
        
        int maxSize = 0;
        HashMap<Integer, Integer> groupCount = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int groupId = uf.find(numFactorMap.get(nums[i]));
            int prevCount = groupCount.getOrDefault(groupId, 0);
            groupCount.put(groupId, prevCount + 1);
            maxSize = Math.max(maxSize, prevCount + 1);
        }
        
        return maxSize;
    }
    
    public ArrayList<Integer> getPrimeFactors(int num){
        ArrayList<Integer> factors = new ArrayList();
        int factor = 2;
        
        while(num >= factor * factor){
            if(num % factor == 0){
                factors.add(factor);
                num = num / factor;
            }
            else{
                factor++;
            }
        }
        
        factors.add(num);
        
        return factors;
    }
}

class UnionFind{
    int[] parents;
    int[] ranks;
    int length;
    
    public UnionFind(int length){
        this.length = length;
        parents = new int[length];
        ranks = new int[length];
        
        for(int i = 0; i < length; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }
    
    public int find(int x){
        if(x == parents[x])
            return x;
        return parents[x] = find(parents[x]);
    }
    
    public void union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX != parentY){
            if(ranks[parentX] < ranks[parentY]){
                parents[parentY] = parentX;
            }
            else if(ranks[parentY] < ranks[parentX]){
                parents[parentX] = parentY;
            }
            else{
                parents[parentY] = parentX;
                ranks[x]++;
            }
        }
    }
}