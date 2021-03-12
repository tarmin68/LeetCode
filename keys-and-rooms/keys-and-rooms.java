class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        isVisited[0] = true;
        
        while(!q.isEmpty()){
            int currRoom = q.poll();
            List<Integer> neighbors = rooms.get(currRoom);
            for(int neighbor: neighbors){
                if(!isVisited[neighbor]){
                    isVisited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        
        for(int i = 0; i < rooms.size(); i++){
            if(!isVisited[i]) return false;
        }
        
        return true;
    }
}