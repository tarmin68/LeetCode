class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevMin = new ArrayList();
        prevMin.add(triangle.get(0).get(0));
        
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> currMin = new ArrayList();
            for(int j = 0; j < triangle.get(i).size(); j++){
                int currNum = triangle.get(i).get(j);
                int min =  Integer.MAX_VALUE;
                if(j > 0){
                    min = Math.min(min, currNum + prevMin.get(j - 1));
                }
                if(j < prevMin.size()){
                    min = Math.min(min, currNum + prevMin.get(j));
                }
                currMin.add(min);
            }
            prevMin = currMin;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < prevMin.size(); i++){
            ans = Math.min(ans, prevMin.get(i));
        }
        
        return ans;
    }
}