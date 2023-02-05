class Solution(object):
    def threeSum(self, nums):
        output = []

        nums.sort()

        for i in range(len(nums) - 2):

            left = i + 1
            right = len(nums) - 1

            while left < right:

                if nums[left] + nums[right] + nums[i] == 0:
                    output.append(tuple(sorted([nums[i], nums[left], nums[right]])))
                    curr_left = nums[left]

                    while left < len(nums) and left > i and curr_left == nums[left]:
                        left += 1

                elif nums[left] + nums[right] + nums[i] < 0:
                    curr_left = nums[left]

                    while left < len(nums) and left > i and curr_left == nums[left]:
                        left += 1


                elif nums[left] + nums[right] + nums[i] > 0:
                    curr_right = nums[right]

                    while right > 0 and right > i and curr_right == nums[right]:
                        right -= 1

        return list(set(output))