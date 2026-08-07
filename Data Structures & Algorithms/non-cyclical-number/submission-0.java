class Solution {
    public boolean isHappy(int n) {
        // 不断计算"平方和"，如果算出的数字之前出现过，说明进入了循环（不会到1），返回false
        // 如果算出1，返回true
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) { 
            seen.add(n);
            n = sumOf(n);
        }
        return n == 1;
    }

    private int sumOf(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // n = 19 取余 digit = 9
            sum += digit * digit; // sum = 9 * 9 = 81
            n /= 10; // 去掉n的最后一位，准备处理下一位 n = 1
        }
        return sum;
    }
}
