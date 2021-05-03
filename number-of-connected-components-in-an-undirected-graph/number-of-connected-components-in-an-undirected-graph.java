class Solution {
    HashMap<Integer, ArrayList<Integer>> allEdges;
    boolean[] visited;
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        allEdges = new HashMap();
        
        for(int i = 0; i < edges.length; i++){
            allEdges.putIfAbsent(edges[i][0], new ArrayList<Integer>());
            allEdges.get(edges[i][0]).add(edges[i][1]);
            allEdges.putIfAbsent(edges[i][1], new ArrayList<Integer>());
            allEdges.get(edges[i][1]).add(edges[i][0]);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                visit(i);
            }
        }
        
        return count;
    }
    
    public void visit(int idx){
        Queue<Integer> q = new LinkedList();
        q.add(idx);
        visited[idx] = true;
        
        while(!q.isEmpty()){
            int currIdx = q.poll();
            ArrayList<Integer> neighbors = allEdges.get(currIdx);
            if(neighbors != null){
                for(int i = 0; i < neighbors.size(); i++){
                    if(!visited[neighbors.get(i)]){
                        q.add(neighbors.get(i));
                        visited[neighbors.get(i)] = true;
                    }
                }
            }
        }
    }
}