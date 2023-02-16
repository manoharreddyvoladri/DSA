class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        l = len(triangle)
        ans = [None] * l
        ans[0] = triangle[0]
        for i in range(1,l):
            level = triangle[i]
            level_l = len(level)
            ans[i]= ([None] * level_l)
            level_ans = ans[i]
            prev_ans = ans[i-1]
            for j in range(level_l):
                if j == 0:
                    level_ans[j] = prev_ans[j] + level[j]
                elif j == level_l-1:
                    level_ans[j] = prev_ans[j-1] + level[j]
                else:
                    level_ans[j] = min([level[j] + prev_ans[j-1],level[j] + prev_ans[j]])
        return min(ans[-1])