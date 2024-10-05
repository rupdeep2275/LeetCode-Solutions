class Solution {
    int n;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        var emptyBoard = new char[n][n];
        Arrays.stream(emptyBoard).forEach(row -> Arrays.fill(row, '.'));
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return res;
    }
    void backtrack(int row, Set<Integer> cols, Set<Integer> dias, Set<Integer> antiDias, char[][] state){
        if(row == n){
            res.add(Arrays.stream(state).map(String::new).toList());
            return;
        }
        for(var col=0; col<n; col++){
            var dia = row - col;
            var antiDia = row + col;
            if(cols.contains(col) || dias.contains(dia) || antiDias.contains(antiDia)) continue;

            cols.add(col); dias.add(dia); antiDias.add(antiDia);
            state[row][col] = 'Q';

            backtrack(row+1,cols, dias, antiDias, state);

            cols.remove(col); dias.remove(dia); antiDias.remove(antiDia);
            state[row][col] = '.';
        }
    }
}
