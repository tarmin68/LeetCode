class Solution {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int maxLength = 0;
        
        TreeNode root = new TreeNode("", -1, null);
        TreeNode currNode = root;
        for(int i = 0; i < parts.length; i++){
            String[] subParts = parts[i].split("\t");
            int currLevel = subParts.length - 1;
            while(currNode.level + 1 != currLevel){
                currNode = currNode.parent;
            }
            String currPath = currNode.path + subParts[currLevel] + "/";
            System.out.println(currPath);
            if(subParts[currLevel].contains(".")){
                maxLength = Math.max(maxLength, currPath.length() - 1);
            }
            TreeNode newNode = new TreeNode(currPath, currLevel, currNode);
            currNode = newNode;
        }
        return maxLength;
    }
    
    public class TreeNode{
        String path;
        int level;
        TreeNode parent;
        
        TreeNode(String path, int level, TreeNode parent){
            this.path = path;
            this.level = level;
            this.parent = parent;
        }
    }
}