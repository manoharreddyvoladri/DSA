class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        test = True
        for i in range(len(nums)):
            if target in nums :
                    return nums.index(target)
            else :
                if nums[i] > target :
                    test = False
                    return i
        if test :
            return len(nums)
                