class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        if(edges.length != n - 1)
            return false;
        
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++){
            if(uf.isConnected(edges[i][0], edges[i][1]))
                return false;
            uf.union(edges[i][0], edges[i][1]);
        }
        
        return true;
    }
}

class UnionFind{
    int[] root;
    int[] rank;
    
    public UnionFind(int size){
        root = new int[size];
        rank = new int[size];
        
        for(int i = 0; i < size; i++){
            root[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int x){
        if(x == root[x])
            return x;
        return root[x] = find(root[x]);
    }
    
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX != rootY){
            if(rank[rootX] > rank[rootY]){
                root[rootY] = root[rootX];
            }
            else if(rank[rootY] > rank[rootX]){
                root[rootX] = root[rootY];
            }
            else{
                root[rootY] = root[rootX];
                rank[rootX]++;
            }
        }
    }
    
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}