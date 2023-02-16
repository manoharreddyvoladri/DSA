class Solution:
    def singleNumber(self, nums: List[int]) -> int:

        num={}

        for x in nums:
            num[x] = 1 + num.get(x,0)
        for i in num:
            if num[i]==1:
                return i