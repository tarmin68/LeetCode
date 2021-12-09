class Solution {
    public int minCostConnectPoints(int[][] points) {
        UnionFind uf = new UnionFind(points.length);
        ArrayList<Edge> edges = new ArrayList();
        
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                Edge e = new Edge(i, j, points[i], points[j]);
                edges.add(e);
            }
        }
        
        Collections.sort(edges);
        
        boolean[] isConnected = new boolean[points.length];
        int count = 0;
        int minCost = 0;
        for(int i = 0; i < edges.size(); i++){
            Edge e = edges.get(i);
            if(!uf.isConnected(e.startIdx, e.endIdx)){
                count++;
                minCost += e.length;
                uf.join(e.startIdx, e.endIdx);
            }
            
            if(count == points.length - 1)
                break;
        }
        
        return minCost;
    }
    
    public class Edge implements Comparable<Edge>{
        int startIdx;
        int endIdx;
        int[] start;
        int[] end;
        int length;
        
        public Edge(int startIdx, int endIdx, int[] start, int[] end){
            this.startIdx = startIdx;
            this.endIdx = endIdx;
            this.start = start;
            this.end = end;
            this.length = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
        }
        
        @Override
        public int compareTo(Edge e){
         return Integer.compare(this.length, e.length);   
        }
    }
    
    public class UnionFind{
        int size;
        int[] parents;
        int[] ranks;
        
        public UnionFind(int size){
            this.size = size;
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
        
        public void join(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX != parentY){
                if(ranks[parentX] < ranks[parentY]){
                    parents[parentY] = parentX;
                }
                else if(ranks[parentX] > ranks[parentY]){
                    parents[parentX] = parentY;
                }
                else{
                    parents[parentY] = parentX;
                    ranks[parentX]++;
                }
            }
        }
        
        public boolean isConnected(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            return parentX == parentY;
        }
    }
}