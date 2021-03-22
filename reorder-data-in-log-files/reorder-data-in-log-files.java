class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Log[] allLogs = new Log[logs.length];
        for(int i = 0; i < logs.length; i++){
            allLogs[i] = new Log(i, logs[i]);
        }
        Arrays.sort(allLogs);
        
        String[] res = new String[logs.length];
        for(int i = 0; i < logs.length; i++){
            res[i] = allLogs[i].logString;
        }
        
        return res;
    }
    
    public class Log implements Comparable<Log>{
        int index;
        String logString;
        String id;
        String content;
        boolean isLetter;
        
        public Log(int index, String logString){
            this.index = index;
            this.logString = logString;
            String[] parts = logString.split(" ");
            id = parts[0];
            content = logString.substring(id.length() + 1);
            if(0 <= parts[1].charAt(0) - '0' && parts[1].charAt(0) - '0' <= 9){
                isLetter = false;
            }
            else{
                isLetter = true;
            }
        }
        
        @Override
        public int compareTo(Log l){
            if(isLetter && !l.isLetter)
                return -1;
            if(!isLetter && l.isLetter){
                return 1;
            }
            if(!isLetter && !l.isLetter){
                return Integer.compare(this.index, l.index);
            }
            
            if(this.content.compareTo(l.content) != 0){
                return this.content.compareTo(l.content);
            }
            else{
                return this.id.compareTo(l.id);
            }
            
        }
    }
}