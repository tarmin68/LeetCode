/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        
        for(int x = 1; x <= 1000; x++){
            int y = findY(x, 1, 1000, z, customfunction);
            if(y != -1){
                List<Integer> currRes = new ArrayList<>();
                currRes.add(x);
                currRes.add(y);
                res.add(currRes);
            }
        }
        
        return res;
    }
    
    public int findY(int x, int low, int hi, int z, CustomFunction customfunction){
        if(hi < low) return -1;
        int middle = (low + hi) / 2;
        
        if(customfunction.f(x, middle) == z){
            return middle;
        }
        else if(customfunction.f(x, middle) < z){
            return findY(x, middle + 1, hi, z, customfunction);
        }
        else{
            return findY(x, low, middle - 1, z, customfunction);
        }
    }
}