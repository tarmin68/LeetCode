class Solution {
    int size;
    Node[] nodes;
    int[] dist;
    int[] counts;
    
    public int countRestrictedPaths(int n, int[][] edges) {
        size = n;
        
        nodes = new Node[n + 1];
        counts = new int[n + 1];
        Arrays.fill(counts, -1);
        
        for(int i = 0; i < edges.length; i++){
            if(nodes[edges[i][0]] == null) nodes[edges[i][0]] = new Node();
            if(nodes[edges[i][1]] == null) nodes[edges[i][1]] = new Node();
            
            nodes[edges[i][0]].neighbors.put(edges[i][1], edges[i][2]);
            nodes[edges[i][1]].neighbors.put(edges[i][0], edges[i][2]);
        }
        
        dist =  new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.add(new int[]{n, 0});
        while(!q.isEmpty()){
            int[] currNode = q.poll();
            for(Integer neighbor : nodes[currNode[0]].neighbors.keySet()){
                if(dist[currNode[0]] + nodes[neighbor].neighbors.get(currNode[0]) < dist[neighbor]){
                    dist[neighbor] = dist[currNode[0]] + nodes[neighbor].neighbors.get(currNode[0]);
                    q.add(new int[] {neighbor, dist[neighbor]});
                }
            }
        }
        
        return getCount(1);
    }
    
    public int getCount(int nodeNum){
        if(nodeNum == size) return 1;
        if(counts[nodeNum] != -1) return counts[nodeNum];
        
        int count = 0;
        for(Integer neighbor : nodes[nodeNum].neighbors.keySet()){
            if(dist[neighbor] < dist[nodeNum]){
                count = (count + getCount(neighbor)) % (1000000007);
            }
        }
        counts[nodeNum] = count;
        return count;
    }
    
    public class Node{
        HashMap<Integer, Integer> neighbors = new HashMap<>();
    }
}