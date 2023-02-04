class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        idx = len(nums) - k % len(nums)
        left = nums[:idx]
        right = nums[idx:]
        res = right + left
        nums[:] = [i for i in res] 