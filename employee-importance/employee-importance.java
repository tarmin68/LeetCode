/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0 || employees.get(0) == null) return 0;
        
        HashMap<Integer, Employee> myMap = new HashMap<>();
        for(Employee e : employees){
            myMap.put(e.id, e);
        }
        
        int res = 0;
        Queue<Employee> q = new LinkedList<>();
        q.add(myMap.get(id));
        while(!q.isEmpty()){
            Employee curr = q.poll();
            res += curr.importance;
            for(int eId : curr.subordinates){
                q.add(myMap.get(eId));
            }
        }
        
        return res;
    }
}