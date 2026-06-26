class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            // 遍历当前三元组中的每个元素，并检查它是否与目标数组中对应位置的元素相等
            // 如果相等，将该索引i添加到good集合中，表示目标数组的这个位置已经被当前三元组匹配
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    good.add(i);
                }
            }
        }
        return good.size() == 3;
    }
}