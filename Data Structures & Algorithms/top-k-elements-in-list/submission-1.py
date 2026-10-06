class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = Counter(nums)
        bucket = [[] for _ in range(len(nums) + 1)]
        for x, c in freq.items():
            bucket[c].append(x)
        res = []
        for f in range(len(bucket) - 1, 0, -1):
            for x in bucket[f]:
                res.append(x)
                if len(res) == k:
                    return res
        return res