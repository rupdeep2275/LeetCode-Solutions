class Solution {
    int m, n;
    char[][] board;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        //Mark all 'O's connected to the border with 'T'
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) dfs(i, j);
            }
        }
        //Replace remaining 'O's with 'X' and 'T's with 'O'
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }
    void dfs(int i, int j){
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] != 'O') return;
        board[i][j] = 'T';
        for(int[] d : dirs) dfs(i + d[0], j + d[1]);
    }
}
