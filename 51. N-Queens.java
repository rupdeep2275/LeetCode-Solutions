class Solution {
    int n;
    char[][] state;
    Set<Integer> cols = new HashSet<>(), dias = new HashSet<>(), antiDias = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        state = new char[n][n];
        Arrays.stream(state).forEach(row -> Arrays.fill(row, '.'));
        backtrack(0);
        return res;
    }
    void backtrack(int row){
        if(row == n){
            res.add(Arrays.stream(state).map(String::new).toList());
            return;
        }
        for(int col=0; col<n; col++){
            int dia = row - col, antiDia = row + col;
            if(cols.contains(col) || dias.contains(dia) || antiDias.contains(antiDia)) continue;
            state[row][col] = 'Q';
            cols.add(col); dias.add(dia); antiDias.add(antiDia);
            backtrack(row+1);
            state[row][col] = '.';
            cols.remove(col); dias.remove(dia); antiDias.remove(antiDia);
        }
    }
}
