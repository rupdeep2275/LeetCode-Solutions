class Solution {
    char[][] board;
    int m, n;
    String word;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        for(var i=0; i<m; i++){
            for(var j=0; j<n; j++){
                if(backtrack(i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(int r, int c, int index){
        if(index == word.length()) return true;
        if(r < 0 || c < 0 || r == m || c == n || board[r][c] != word.charAt(index)) return false;
        boolean res = false;
        board[r][c] = '*';
        for(int[] d : directions){
            res = backtrack(r + d[0], c + d[1], index + 1);
            if(res == true) break;
        }
        board[r][c] = word.charAt(index);
        return res;
    }
}
