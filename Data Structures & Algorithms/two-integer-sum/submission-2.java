class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // {元素值 → 索引}
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];           // 需要找的另一半
            if (map.containsKey(complement)) {           // 另一半之前见过
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);                         // 没找到，先把自己存进去
        }
        return new int[] {};
    }
}