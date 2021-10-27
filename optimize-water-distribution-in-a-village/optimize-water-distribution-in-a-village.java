class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        ArrayList<int[]> edges = new ArrayList();
        
        for(int i = 0; i < n; i++){
            edges.add(new int[] {0, i + 1, wells[i]});
        }
        
        for(int i = 0; i < pipes.length; i++){
            edges.add(pipes[i]);
        }
        
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        
        UnionFind uf = new UnionFind(n + 1);
        int cost = 0;
        for(int[] edge : edges){
            if(uf.union(edge[0], edge[1])){
                cost += edge[2];
            }
        }
        
        return cost;
    }
}

class UnionFind{
    int size;
    int[] parents;
    int[] ranks;
    
    public UnionFind(int n){
        size = n;
        parents = new int[size];
        ranks = new int[size];
        
        for(int i = 0; i < size; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }
    
    public int find(int x){
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }
    
    public boolean union(int x, int y){
        int parentX = find(x);
        int parentY = find(y);
        
        if(parentX != parentY){
            if(ranks[parentX] > ranks[parentY]){
                parents[parentY] = parentX;
            }
            else if(ranks[parentY] > ranks[parentX]){
                parents[parentX] = parentY;
            }
            else{
                parents[parentY] = parentX;
                ranks[parentX]++;
            }
            return true;
        }
        return false;
    }
}