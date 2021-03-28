class Solution {
    public String largestTimeFromDigits(int[] arr) {
        ArrayList<Integer> mySet = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            mySet.add(arr[i]);
        }
        
        if(mySet.contains(2)){
            String res = buildTime(new ArrayList(mySet), 2);
            if(!res.equals(""))
                return res;
        }
        if(mySet.contains(1)){
            String res = buildTime(new ArrayList(mySet), 1);
            if(!res.equals(""))
                return res;
        }
        if(mySet.contains(0)){
            String res = buildTime(new ArrayList(mySet), 0);
            if(!res.equals(""))
                return res;
        }
        
        return "";
    }
    
    public String buildTime(ArrayList<Integer> mySet, int first){
        String res = "";
        if(first == 2){
            res = res + "2";
            mySet.remove(new Integer(2));
        }
        else if(first == 1){
            res = res + "1";
            mySet.remove(new Integer(1));
        }
        else{
            res = res + "0";
            mySet.remove(new Integer((0)));
        }
        
        if(res.equals("2")){
            int i = 3;
            while(i >= 0 && !mySet.contains(i)){
                i--;
            }
            if(i == -1)
                return "";
            else{
                res = res + "" + i;
                mySet.remove(new Integer(i));
            }
        }
        else{
            int i = 9;
            while(i >= 0 && !mySet.contains(i)){
                i--;
            }
            if(i == -1)
                return "";
            else{
                res = res + "" + i;
                mySet.remove(new Integer(i));
            }
        }
        
        res = res + ":";
        
        int i = 5;
        while(i >= 0 && !mySet.contains(i)){
            i--;
        }
        if(i == -1)
            return "";
        else{
            res = res + "" + i;
            mySet.remove(new Integer(i));
        }
        
        i = 9;
        while(i >= 0 && !mySet.contains(i)){
            i--;
        }
        if(i == -1)
            return "";
        else{
            res = res + "" + i;
            mySet.remove(new Integer(i));
        }
        
        return res;
    }
}