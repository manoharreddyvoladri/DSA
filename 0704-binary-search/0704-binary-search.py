class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        s=0
        e=len(nums)-1
        m=(s+e)//2
        while(s<=e):
            if nums[m]==target:
                return m
            elif nums[m]>target:
                e=m-1
            else:
                s=m+1
            m=(s+e)//2
        return -1