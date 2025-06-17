class Solution {
    boolean solved = false;

    public void solveSudoku(char[][] board) {
        int n = board.length;
        // below three are used as Set to store wheter num exists in them or not
        int[][] rows = new int[n][n];
        int[][] cols = new int[n][n];
        int[][] grid = new int[n][n];
        int filled = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num-1] = 1;
                    cols[j][num-1] = 1;
                    int gridIndex = getGridIndex(i, j);
                    grid[gridIndex][num-1] = 1;
                    filled++;
                }
            }
        }
        fillBoard(board, rows, cols, grid, filled, n);
    }

    private int getGridIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }

    private void fillBoard(char[][] b, int[][] r, int[][] c, int[][] g, int filled, int n) {
        if (filled == n * n){
            this.solved = true;   
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == '.') {
                    for (int k = 1; k <= n; k++) {
                        int gridIndex = getGridIndex(i, j);
                        if (r[i][k - 1] == 1 || c[j][k - 1] == 1 || g[gridIndex][k - 1] == 1)
                            continue;

                        r[i][k - 1] = 1;
                        c[j][k - 1] = 1;
                        g[gridIndex][k - 1] = 1;
                        b[i][j] = (char) (k + '0');
                        fillBoard(b, r, c, g, filled+1, n);
                        if (solved) return;
                        r[i][k - 1] = 0;
                        c[j][k - 1] = 0;
                        g[gridIndex][k - 1] = 0;
                        b[i][j] = '.';
                    }
                    // Important: if no number fits, backtrack immediately
                    return;     // GOAT this line is the GOAT and also frustrating to find it
                }
            }
        }
    }
}
