class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        double currentProduct = x;

        while (N > 0) {
            if ((N & 1) == 1) {  // 当前二进制位是1，把当前的x幂次乘进结果
                result *= currentProduct;
            }
            currentProduct *= currentProduct;  // x的幂次翻倍：x, x^2, x^4, x^8...
            N >>= 1;  // 处理下一个二进制位
        }

        return result;
    }
}