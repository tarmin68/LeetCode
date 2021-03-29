class Solution {
    HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<>();
    int[] res;
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        res = new int[n];
        for(int i = 0; i < paths.length; i++){
            myMap.putIfAbsent(paths[i][0] - 1, new ArrayList<Integer>());
            myMap.get(paths[i][0] - 1).add(paths[i][1] - 1);
            myMap.putIfAbsent(paths[i][1] - 1, new ArrayList<Integer>());
            myMap.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }
        
        helper(0);
        return res;
    }
    
    public boolean helper(int index){
        if(index == res.length)
            return true;
        
        for(int i = 1; i <= 4; i++){
            if(myMap.get(index) == null || isValid(index, i)){
                res[index] = i;
                if(helper(index + 1))
                    return true;
            }
        }
        
        res[index] = 0;
        return false;
    }
    
    public boolean isValid(int index, int type){
        ArrayList<Integer> neighbors = myMap.get(index);
        
        if(neighbors != null){
            for(int i = 0; i < neighbors.size(); i++){
                if(res[neighbors.get(i)] == type)
                    return false;
            }
        }
        
        return true;
    }
}