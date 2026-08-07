class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 1. 先检查第一行、第一列本身是否原本就有0（单独记录，因为马上要复用它们做标记）
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) firstRowHasZero = true;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) firstColHasZero = true;
        }

        // 2. 遍历矩阵内部（从第1行第1列开始），用第一行/第一列做标记
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // 标记第i行要清零
                    matrix[0][j] = 0;  // 标记第j列要清零
                }
            }
        }

        // 3. 根据标记，把对应的行/列清零（同样跳过第一行第一列，最后单独处理）
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 4. 最后处理第一行、第一列本身（用之前单独记录的两个变量）
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}