class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet();
        int maxX = (int) Math.ceil(Math.log(bound) / Math.log(x));
        int maxY = (int) Math.ceil(Math.log(bound) / Math.log(y));
        
        if(x == 1)
            maxX = 1;
        if(y == 1)
            maxY = 1;
        
        int xPart = 1;
        for(int i = 0; i < maxX; i++){
            int yPart = 1;
            for(int j = 0; j < maxY; j++){
                if(xPart + yPart <= bound){
                    res.add(xPart + yPart);
                    yPart *= y;
                }
                else{
                    break;
                }
            }
            xPart *= x;
        }
        
        return new ArrayList<Integer>(res);
    }
}