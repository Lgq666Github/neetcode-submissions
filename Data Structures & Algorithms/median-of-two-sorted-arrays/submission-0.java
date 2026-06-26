public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 让 A 指向较短的数组，B 指向较长的数组
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;  // 总元素个数
        int half = (total + 1) / 2;  // 左半部分的元素个数（如果是奇数，多出来的一个元素会归到左半部分）

        // 确保 A 是较短的数组，以减少二分查找的搜索范围
        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0, r = A.length;  // 在较短数组 A 上进行二分查找

        while (l <= r) {
            int i = (l + r) / 2;  // A 的分割点
            int j = half - i;     // B 的分割点，保证左半部分元素总数等于 half

            // 处理边界情况，防止数组越界
            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;  // A 左侧最大值
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;  // A 右侧最小值
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;  // B 左侧最大值
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;  // B 右侧最小值

            // 检查是否找到了正确的分割点
            if (Aleft <= Bright && Bleft <= Aright) {
                // 如果总数是奇数，中位数是左侧部分的最大值
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                // 如果总数是偶数，中位数是左右部分最大最小值的平均值
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }
            // 如果 Aleft > Bright，说明 i 选大了，缩小搜索范围
            else if (Aleft > Bright) {
                r = i - 1;
            }
            // 如果 Bleft > Aright，说明 i 选小了，扩大搜索范围
            else {
                l = i + 1;
            }
        }

        // 正常情况下不会执行到这里，除非输入数组不符合条件
        return -1;
    }
}
