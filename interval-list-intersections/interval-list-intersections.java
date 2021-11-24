class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<Pair<Integer, Integer>> resList = new ArrayList();
        
        for(int i = 0; i < firstList.length; i++){
            for(int j = 0; j < secondList.length; j++){
                if((firstList[i][0] <= secondList[j][0] && firstList[i][1] >= secondList[j][0]) ||
                   (firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1])){
                        int a = Math.max(firstList[i][0], secondList[j][0]);
                        int b = Math.min(firstList[i][1], secondList[j][1]);
                        resList.add(new Pair(a, b));
                }
            }
        }
        
        int[][] result = new int[resList.size()][2];
        for(int i = 0; i < resList.size(); i++){
            result[i][0] = resList.get(i).getKey();
            result[i][1] = resList.get(i).getValue();
        }
        
        return result;
    }
}