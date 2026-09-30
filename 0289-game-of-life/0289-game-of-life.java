class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && (board[ni][nj] & 1) == 1) {
                        liveNeighbors++;
                    }
                }
                
                // Rule 1 & Rule 3: Live cell dies (remains 1 in bitwise or we store 3)
                if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[i][j] = 3; // Live to Live
                }
                // Rule 4: Dead cell becomes live
                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Dead to Live
                }
            }
        }
        
        // Second pass to get the final state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1; // Shift right by 1 to get the next state (0 or 1)
            }
        }
    }
}