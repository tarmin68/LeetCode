class Excel {
    HashMap<String, Integer> cellMap;
    HashMap<String, String[]> cellFormula;

    public Excel(int height, char width) {
        cellMap = new HashMap();
        cellFormula = new HashMap();
    }
    
    public void set(int row, char column, int val) {
        String colRow = "" + column + "" + row;
        cellMap.put(colRow, val);
        
        if(cellFormula.containsKey(colRow))
            cellFormula.remove(colRow);
    }
    
    public int get(int row, char column) {
        String colRow = "" + column + "" + row;
        if(cellFormula.containsKey(colRow)){
            return evaluate(cellFormula.get(colRow));
        }
        else if(cellMap.containsKey(colRow)){
            return cellMap.get(colRow);
        }
        else
            return 0;
    }
    
    public int sum(int row, char column, String[] numbers) {
        String colRow = "" + column + "" + row;
        cellFormula.put(colRow, numbers);
        
        return get(row, column);
    }
    
    public int evaluate(String[] numbers){
        int sum = 0;
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i].contains(":")){
                String colRow1 = numbers[i].split(":")[0];
                String colRow2 = numbers[i].split(":")[1];
                
                char col1 = colRow1.charAt(0);
                int row1 = Integer.valueOf(colRow1.substring(1));
                char col2 = colRow2.charAt(0);
                int row2 = Integer.valueOf(colRow2.substring(1));
                
                for(int j = row1; j <= row2; j++){
                    for(int k = col1 - 'A'; k <= col2 - 'A'; k++){
                        sum += get(j, (char)('A' + k));
                    }
                }
            }
            else{
                char col = numbers[i].charAt(0);
                int row = Integer.valueOf(numbers[i].substring(1));
                sum += get(row, col);
            }
        }
        
        return sum;
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(height, width);
 * obj.set(row,column,val);
 * int param_2 = obj.get(row,column);
 * int param_3 = obj.sum(row,column,numbers);
 */