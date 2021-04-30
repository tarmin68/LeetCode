class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> res = new ArrayList();
        for(int i = 0; i < candidates.length; i++){
            List<List<Integer>> nextRes = allComb(candidates, i, target);
            for(int j = 0; j < nextRes.size(); j++){
                // nextRes.get(j).add(candidates[i]);
                res.add(nextRes.get(j));
            }
        }
        
        return res;
    }
    
    public List<List<Integer>> allComb(int[] candidates, int idx, int target){
        if(candidates[idx] > target){
            return new ArrayList();
        }
        
        List<List<Integer>> res = new ArrayList();
        if(candidates[idx] == target){
            List<Integer> next = new ArrayList(); 
            next.add(candidates[idx]);
            res.add(next);
            return res;
        }
        
        for(int i = idx; i < candidates.length; i++){
            List<List<Integer>> nextRes = allComb(candidates, i, target - candidates[idx]);
            for(int j = 0; j < nextRes.size(); j++){
                nextRes.get(j).add(candidates[idx]);
                res.add(nextRes.get(j));
            }
        }
        
        return res;
    }
}