class Solution {
    public boolean canTransform(String start, String end) {
        ArrayList<Pair<Integer, Integer>> startRIdxs = new ArrayList();
        ArrayList<Pair<Integer, Integer>> endRIdxs = new ArrayList();
        ArrayList<Pair<Integer, Integer>> startLIdxs = new ArrayList();
        ArrayList<Pair<Integer, Integer>> endLIdxs = new ArrayList();
        
        int XCount = 0;
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) == 'R')
                startRIdxs.add(new Pair(i, XCount));
            else if(start.charAt(i) == 'L')
                startLIdxs.add(new Pair(i, XCount));
            else
                XCount++;
        }
        
        XCount = 0;
        for(int i = 0; i < end.length(); i++){
            if(end.charAt(i) == 'R')
                endRIdxs.add(new Pair(i, XCount));
            else if(end.charAt(i) == 'L')
                endLIdxs.add(new Pair(i, XCount));
            else
                XCount++;
        }
        
        if(startRIdxs.size() != endRIdxs.size())
            return false;
        for(int i = 0; i < startRIdxs.size(); i++){
            if(startRIdxs.get(i).getKey() > endRIdxs.get(i).getKey())
                return false;
            if(startRIdxs.get(i).getKey() + endRIdxs.get(i).getValue() != 
               startRIdxs.get(i).getValue() + endRIdxs.get(i).getKey())
                return false;
        }
        
        if(startLIdxs.size() != endLIdxs.size())
            return false;
        for(int i = 0; i < startLIdxs.size(); i++){
            if(startLIdxs.get(i).getKey() < endLIdxs.get(i).getKey())
                return false;
            if(startLIdxs.get(i).getKey() + endLIdxs.get(i).getValue() != 
               startLIdxs.get(i).getValue() + endLIdxs.get(i).getKey())
                return false;
        }
        
        return true;
    }
}