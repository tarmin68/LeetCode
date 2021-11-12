class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = new ArrayList<Integer>();
        prevRow.add(triangle.get(0).get(0));
        
        for(int i = 1; i < triangle.size(); i++){
            List<Integer> currRow = new ArrayList<Integer>();
            for(int j = 0; j < i + 1; j++){
                int min = Integer.MAX_VALUE;
                if(j > 0)
                    min = Math.min(min, prevRow.get(j - 1) + triangle.get(i).get(j));
                if(j < i)
                    min = Math.min(min, prevRow.get(j) + triangle.get(i).get(j));
                currRow.add(min);
            }
            prevRow = currRow;
        }
        
        return Collections.min(prevRow);
    }
}