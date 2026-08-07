class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];  // 结果最多 m+n 位

        // 从右往左遍历（i, j 是从右数的下标更方便理解，这里用从左数配合 i+j 公式）
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int product = digit1 * digit2;

                // i,j 是从左数的下标位置对应关系：这里用的是从右数的循环变量，
                // 需要转换：从右数第i位 = 从左数第(m-1-i)位，同理j
                // 为了避免搞混，直接用当前i,j（从右往左遍历）对应的位置公式：
                int lowPos = i + j + 1;  // 个位存放位置
                int highPos = i + j;      // 进位存放位置

                int sum = product + result[lowPos];  // 加上原来已经累积的值
                result[lowPos] = sum % 10;            // 本位保留个位
                result[highPos] += sum / 10;          // 进位加到高位（注意是+=，因为高位可能已经有别的累积值）
            }
        }

        // 把数组转成字符串，跳过前导0
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {  // 跳过开头的0
                sb.append(num);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}