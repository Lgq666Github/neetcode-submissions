class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[] usedCol, usedDiag45, usedDiag135;

    public List<List<String>> solveNQueens(int n) {
        usedCol = new boolean[n];
        usedDiag45 = new boolean[2 * n - 1];
        usedDiag135 = new boolean[2 * n - 1];
        int[] board = new int[n];
        back(board, n, 0);
        return res;
    }

    private void back(int[] board, int n, int row) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (int i : board) {
                char[] str = new char[n];
                Arrays.fill(str, '.');
                str[i] = 'Q';
                tmp.add(new String(str));
            }
            res.add(tmp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (usedCol[col] | usedDiag45[row + col] | usedDiag135[row - col + n - 1]) {
                continue;
            }
            board[row] = col;
            // 标记该列出现过
            usedCol[col] = true;
            // 同一45°斜线上元素的row + col为定值, 且各不相同
            usedDiag45[row + col] = true;
            // 同一135°斜线上元素row - col为定值, 且各不相同
			// row - col 值有正有负, 加 n - 1 是为了对齐零点
            usedDiag135[row - col + n - 1] = true;
            back(board, n, row + 1);
            usedCol[col] = false;
            usedDiag45[row + col] = false;
            usedDiag135[row - col + n - 1] = false;
        }
    }
}
