class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while (l < r) {
            int width = r - l;
            int currentHeight = Math.min(heights[l], heights[r]);
            int area = width * currentHeight;
            maxArea = Math.max(area, maxArea);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
