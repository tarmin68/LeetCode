class Solution {
    HashMap<String, ArrayList<String>> contentMap = new HashMap();
    public List<List<String>> findDuplicate(String[] paths) {
        for(String path : paths){
            process(path);
        }
        
        List<List<String>> res = new ArrayList();
        for(String content: contentMap.keySet()){
            if(contentMap.get(content).size() > 1){
                res.add(contentMap.get(content));
            }
        }
        
        return res;
    }
    
    public void process(String path){
        String[] parts = path.split(" ");
        String dirPath = parts[0];
        
        for(int i = 1; i < parts.length; i++){
            int idx = parts[i].indexOf("(");
            String fileName = parts[i].substring(0, idx);
            String fileContent = parts[i].substring(idx + 1, parts[i].length() - 1);
            
            contentMap.putIfAbsent(fileContent, new ArrayList<String>());
            contentMap.get(fileContent).add(dirPath + "/" + fileName);
        }
    }
}