class Solution {
    private int size, res;
    public int totalNQueens(int n) {
        size = n;
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }
    void backtrack(int row, Set<Integer> cols, Set<Integer> dias, Set<Integer> antiDias){
        if(row == size) res++;
        for(int col=0; col<size; col++){
            int dia = row - col, antiDia = row + col;
            if(cols.contains(col) || dias.contains(dia) || antiDias.contains(antiDia)) continue;
            cols.add(col); dias.add(dia); antiDias.add(antiDia);
            backtrack(row + 1, cols, dias, antiDias);
            cols.remove(col); dias.remove(dia); antiDias.remove(antiDia);
        }
    }
}
