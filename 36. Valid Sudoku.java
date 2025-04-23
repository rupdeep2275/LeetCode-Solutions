class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(!set.add("row"+i+c) || !set.add("col"+j+c) || !set.add("box"+i/3+j/3+c)) return false;
                }
            }
        }
        return true;
    }
}
