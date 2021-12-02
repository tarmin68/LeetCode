class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        
        for(int i = 0; i < isConnected.length; i++){
            for(int j = i + 1; j < isConnected.length; j++){
                if(isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }
        
        return uf.getNumofP();
    }
    
    class UnionFind{
        int[] parents;
        int[] ranks;
        int size;
        int numOfP;
        
        public UnionFind(int size){
            this.size = size;
            parents = new int[size];
            ranks = new int[size];
            numOfP = size;
            
            for(int i = 0; i < size; i++){
                parents[i] = i;
                ranks[i] = 0;
            }
        }
        
        public int find(int x){
            if(x == parents[x])
                return x;
            return parents[x] = find(parents[x]);
        }
        
        public void union(int x, int y){
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
                numOfP--;
            }
        }
        
        public int getNumofP(){
            return numOfP;
        }
    }
}