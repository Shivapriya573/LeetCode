class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Total number of characters must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        Boolean[][][] dp = new Boolean[m][n][m + n];

        return solve(grid, 0, 0, 0, dp);
    }

    private boolean solve(char[][] grid, int r, int c,
                          int balance, Boolean[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        // Invalid balance
        if (balance < 0) {
            return false;
        }

        // Out of bounds
        if (r >= m || c >= n) {
            return false;
        }

        // Update balance
        if (grid[r][c] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid
        if (balance < 0) {
            return false;
        }

        // Reached destination
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Already calculated
        if (dp[r][c][balance] != null) {
            return dp[r][c][balance];
        }

        boolean right = solve(grid, r, c + 1, balance, dp);
        boolean down = solve(grid, r + 1, c, balance, dp);

        return dp[r][c][balance] = right || down;
    }
}