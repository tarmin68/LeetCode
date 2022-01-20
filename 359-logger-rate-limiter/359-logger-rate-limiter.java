class Logger {
    HashMap<String, Integer> nextTime;
    
    public Logger() {
        nextTime = new HashMap();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(nextTime.get(message) != null){
            int time = nextTime.get(message);
            if(timestamp >= time){
                nextTime.put(message, timestamp + 10);
                return true;
            }
            else
                return false;
        }
        else{
            nextTime.put(message, timestamp + 10);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */