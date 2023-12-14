#Python:

class Solution:
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        m, n = len(grid), len(grid[0])
        row_ones = [0] * m
        col_ones = [0] * n
        res = [[0] * n for i in range(m)]
        c = 0
        for i in range(m):
            row_ones[i] = sum(grid[i])
        for j in range(n):
            col_ones[j] = sum(grid[i][j] for i in range(m))
        for i in range(m):
            for j in range(n):
                res[i][j] = 2*row_ones[i] + 2*col_ones[j] - m - n
        return res


----------------------------------------------------------------------------------------

#Java:

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int c = 0;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        for(int i=0; i<m; i++){
            c = 0;
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) c++;
            }
            rowOnes[i] = c;
        }
        for(int j=0; j<n; j++){
            c = 0;
            for(int i=0; i<m; i++){
                if(grid[i][j] == 1) c++;
            }
            colOnes[j] = c;
        }
        int[][] res = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                res[i][j] = 2*rowOnes[i] + 2*colOnes[j] - m - n;
            }
        }
        return res;
    }
}
