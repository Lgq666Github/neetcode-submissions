class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // 如果当前的数独格子是空格（即 .），则跳过该格子，继续检查下一个格子。
                if (board[r][c] == '.') continue;
                //将当前格子的字符数字（'1' 到 '9'）转换为相应的索引值（0 到 8），便于在数组中记录其出现情况。
                int val = board[r][c] - '1';
                if ((rows[r] & (1 << val)) > 0 || (cols[c] & (1 << val)) > 0 ||
                (squares[(r / 3) * 3 + (c / 3)] & (1 << val)) > 0) {
                    return false;
                }
                rows[r] |= (1 << val);
                cols[c] |= (1 << val);
                squares[(r / 3) * 3 + (c / 3)] |= (1 << val);
            }
        }
        return true;
    }
}
