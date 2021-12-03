class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList();
        Queue<List<Integer>> q = new LinkedList();
        q.add(Arrays.asList(0));
        
        while(!q.isEmpty()){
            List<Integer> currPath = q.remove();
            int lastNode = currPath.get(currPath.size() - 1);
            if(lastNode == graph.length - 1)
                res.add(currPath);
            else{
                for(int neighbor : graph[lastNode]){
                    if(!currPath.contains(neighbor)){
                        List<Integer> newPath = new ArrayList(currPath);
                        newPath.add(neighbor);
                        q.add(newPath);
                    }
                }
            }
        }
        
        return res;
    }
}