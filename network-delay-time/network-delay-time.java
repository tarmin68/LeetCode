class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] allNodes = new Node[n + 1];
        
        for(int i = 0; i < times.length; i++){
            if(allNodes[times[i][0]] == null)
                allNodes[times[i][0]] = new Node();
            int source = times[i][0];
            if(allNodes[times[i][1]] == null)
                allNodes[times[i][1]] = new Node();
            int target = times[i][1];
            int time = times[i][2];
            allNodes[source].neighbors.put(target, time);
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        allNodes[k].time = 0;
        q.add(allNodes[k]);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            for(Integer neighbor : currNode.neighbors.keySet()){
                if(allNodes[neighbor].time == -1){
                    allNodes[neighbor].time = currNode.time + currNode.neighbors.get(neighbor);
                    q.add(allNodes[neighbor]);
                }
                else if(currNode.time + currNode.neighbors.get(neighbor) < allNodes[neighbor].time){
                    allNodes[neighbor].time = currNode.time + currNode.neighbors.get(neighbor);
                    q.add(allNodes[neighbor]);
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i < n + 1; i++){
            if(allNodes[i] == null || allNodes[i].time == -1) return -1;
            max = Math.max(max, allNodes[i].time);
        }
        
        return max;
    }
    
    public class Node implements Comparable<Node>{
        HashMap<Integer, Integer> neighbors;
        int time = -1;
        
        public Node(){
            neighbors = new HashMap();
        }
        
        @Override
        public int compareTo(Node n){
            return Integer.compare(this.time, n.time);
        }
    }
}