/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Integer> idMap = new HashMap();
    
    public int getImportance(List<Employee> employees, int id) {
        for(int i = 0; i < employees.size(); i++){
            idMap.put(employees.get(i).id, i);
        }
        
        return calcImportance(employees, id);
    }
    
    public int calcImportance(List<Employee> employees, int id){
        int importance = employees.get(idMap.get(id)).importance;
        
        for(int i = 0; i < employees.get(idMap.get(id)).subordinates.size(); i++){
            int nextId = employees.get(idMap.get(id)).subordinates.get(i);
            importance += calcImportance(employees, nextId);
        }
        
        return importance;
    }
}