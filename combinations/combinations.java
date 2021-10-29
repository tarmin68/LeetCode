class Solution {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> combine(int n, int k) {
        combineAll(1, n, k, new ArrayList());
        return res;
    }
    
    public void combineAll(int num, int n, int k, ArrayList<Integer> curr){
        if(curr.size() == k){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for(int i = num; i < n + 1; i++){
            curr.add(i);
            combineAll(i + 1, n, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
}