class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();
        
        for(int i = 0; i < equations.size(); i++){
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        
        double[] res = new double[queries.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = uf.evaluate(queries.get(i).get(0), queries.get(i).get(1));
        }
        
        return res;
    }
}

class UnionFind {
    HashMap<String, String> parents;
    HashMap<String, Double> parentWeight;
    HashMap<String, Integer> ranks;
    
    public UnionFind(){
        parents = new HashMap();
        parentWeight = new HashMap();
        ranks = new HashMap();
    }
    
    public String find(String s){
        if(parents.get(s) == null){
            parents.put(s, s);
            parentWeight.put(s, 1.0);
            ranks.put(s, 1);
            return s;
        }
        if(s.equals(parents.get(s)))
            return s;
        String newParent = find(parents.get(s));
        double newWeight = parentWeight.get(s) * parentWeight.get(parents.get(s));
        parents.put(s, newParent);
        parentWeight.put(s, newWeight);
        return newParent;
    }
    
    public void union(String s1, String s2, double weight){
        String parent1 = find(s1);
        String parent2 = find(s2);
        
        if(!parent1.equals(parent2)){
            if(ranks.get(parent1) > ranks.get(parent2)){
                parents.put(parent2, parent1);
                double newWeight = (weight * parentWeight.get(s1) / parentWeight.get(s2)); 
                parentWeight.put(parent2, newWeight);
            }
            else if(ranks.get(parent2) > ranks.get(parent1)){
                parents.put(parent1, parent2);
                double newWeight = (parentWeight.get(s2) / (weight * parentWeight.get(s1))); 
                parentWeight.put(parent1, newWeight);
            }
            else{
                parents.put(parent2, parent1);
                double newWeight = (weight * parentWeight.get(s1) / parentWeight.get(s2)); 
                parentWeight.put(parent2, newWeight);
                ranks.put(parent1, ranks.get(parent1) + 1);
            }
        }
    }
    
    public double evaluate(String s1, String s2){
        if(parents.get(s1) == null || parents.get(s2) == null)
            return -1;
        String parent1 = find(s1);
        String parent2 = find(s2);
        if(!parent1.equals(parent2))
            return -1;
        return parentWeight.get(s2) / parentWeight.get(s1);
    }
}