class Solution {
    int itinerarySize;
    List<String> res = new ArrayList();
    HashMap<String, ArrayList<String>> ticketMap = new HashMap();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        itinerarySize = tickets.size() + 1;
        
        for(int i = 0; i < tickets.size(); i++){
            ticketMap.putIfAbsent(tickets.get(i).get(0), new ArrayList<String>());
            ticketMap.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        
        for(String from : ticketMap.keySet()){
            Collections.sort(ticketMap.get(from));
        }
        
        getPath(tickets, "JFK" , new ArrayList<String>());
        return res;
    }
    
    public void getPath(List<List<String>> tickets, String from, List<String> path){
        if(res.size() != 0)
            return;
        
        path.add(from);
        if(path.size() == itinerarySize){
            // if(res.size() == 0 || isSmaller(path, res))
            //     res = new ArrayList<String>(path);
            res = path;
            return;
        }
        
        if(ticketMap.get(from) != null){
            for(String to : ticketMap.get(from)){
                if(tickets.contains(Arrays.asList(from, to))){
                    tickets.remove(Arrays.asList(from, to));
                    getPath(tickets, to, new ArrayList<String>(path));
                    tickets.add(Arrays.asList(from, to));
                }
            }
        }
    }
                          
    public boolean isSmaller(List<String> path1, List<String> path2){
        for(int i = 0; i < path1.size(); i++){
            if(path1.get(i).compareTo(path2.get(i)) < 0)
                return true;
            else if(path1.get(i).compareTo(path2.get(i)) > 0)
                return false;
        }
        
        return false;
    }
}