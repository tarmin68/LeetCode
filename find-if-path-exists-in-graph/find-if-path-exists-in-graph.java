class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        HashMap<Integer, ArrayList<Integer>> neighbors = new HashMap();
        
        for(int i = 0; i < n; i++){
            neighbors.put(i, new ArrayList<Integer>());
            neighbors.get(i).add(i);
        }
        
        for(int i = 0; i < edges.length; i++){
            neighbors.get(edges[i][0]).add(edges[i][1]);
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque();
        q.offer(start);
        while(!q.isEmpty()){
            int currNode = q.poll();
            visited[currNode] = true;
            if(neighbors.get(currNode) != null){ 
                for(Integer neighbor : neighbors.get(currNode)){
                    if(neighbor == end)
                        return true;
                    if(!visited[neighbor])
                        q.offer(neighbor);
                }
            }
        }
        
        return false;
    }
}