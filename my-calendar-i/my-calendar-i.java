class MyCalendar {
    ArrayList<Event> allEvents;
    
    public MyCalendar() {
        allEvents = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        for(Event e: allEvents){
            if(start < e.end && end > e.start)
                return false;
        }
        allEvents.add(new Event(start, end));
        return true;
    }
    
    public class Event{
        int start;
        int end;
        
        public Event(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */