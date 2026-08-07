class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // 从最后一位往前遍历
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;      // 不产生进位，直接加1后返回
                return digits;
            }
            digits[i] = 0;        // 当前位是9，加1后变成0，向前进位
            // 不return，继续循环处理前一位
        }

        // 如果循环正常结束（没有中途return），
        // 说明所有位都是9（比如999），此时所有位都被置0了，
        // 需要在最前面多加一位1，比如 999 -> 1000
        int[] result = new int[n + 1];
        result[0] = 1;
        // result[1..n] 默认就是0，不需要手动赋值
        return result;
    }
}