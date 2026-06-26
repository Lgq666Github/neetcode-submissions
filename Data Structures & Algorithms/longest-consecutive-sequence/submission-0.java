public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            //我们只从 可能的连续序列的起始点 开始查找。
            //换句话说，如果当前数字 num 的前一个数字（num - 1）在 numSet 中存在，
            //说明 num 不是一个新序列的起点，它应该是已经存在的一个序列的一部分。
            //因此，只有在 num - 1 不存在的情况下，我们才认为 num 是新序列的起始数字。
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}