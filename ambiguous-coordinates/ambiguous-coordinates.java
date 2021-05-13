class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> res = new ArrayList();
        
        for(int i = 1; i < s.length(); i++){
            List<String> allNum1 = allPossible(s.substring(0, i));
            List<String> allNum2 = allPossible(s.substring(i));
            
            for(int j = 0; j < allNum1.size(); j++){
                for(int k = 0; k < allNum2.size(); k++){
                    res.add("(" + allNum1.get(j) + ", " + allNum2.get(k) + ")");
                }
            }
        }
        
        return res;
    }
    
    public List<String> allPossible(String num){
        Set<String> allNums = new HashSet();
        for(int i = 0; i < num.length(); i++){
            String newNum = num.substring(0, i + 1) + "." + num.substring(i + 1);
            double dNum = Double.valueOf(newNum);
            if(dNum % 1 == 0){
                newNum = "" + (int) dNum;
                if(newNum.length() == num.length()){
                    allNums.add(newNum);
                }
            }
            else{
                DecimalFormat df = new DecimalFormat("#.##########");
                newNum = df.format(dNum);
                if(newNum.length() == num.length() + 1){
                    allNums.add(newNum);
                }
            }
        }
        
        return new ArrayList<String>(allNums);
    }
}