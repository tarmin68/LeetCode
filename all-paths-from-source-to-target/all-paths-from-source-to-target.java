class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList();
        int n = graph.length;
        
        Queue<ArrayList<Integer>> q = new LinkedList();
        q.add(new ArrayList<Integer>(Arrays.asList(0)));
        boolean[] visited = new boolean[n];
        
        while(!q.isEmpty()){
            ArrayList<Integer> currPath = q.remove();
            int lastNode = currPath.get(currPath.size() - 1);
            if(lastNode == n - 1)
                res.add(currPath);
            else{
                for(int neighbor : graph[lastNode]){
                    ArrayList<Integer> newPath = new ArrayList(currPath);
                    newPath.add(neighbor);
                    q.add(newPath);
                }
            }
        }
        
        return res;
    }
}