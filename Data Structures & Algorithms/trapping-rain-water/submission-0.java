class Solution {
    public int trap(int[] height) {
        int l = 1, r = height.length - 2, leftmax = height[0], rightmax = height[height.length - 1];
        int res = 0;
        while (l <= r) {
            if (leftmax <= rightmax) {
                res += Math.max(0, leftmax - height[l]);
                leftmax = Math.max(leftmax, height[l++]);
            } else {
                res += Math.max(0, rightmax - height[r]);
                rightmax = Math.max(rightmax, height[r--]);
            }
        }
        return res;
    }
}
