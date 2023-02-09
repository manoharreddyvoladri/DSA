class Solution(object):
    def distinctNames(self, ideas):
        """
        :type ideas: List[str]
        :rtype: int
        """

        ans = 0
        d = defaultdict(set)

        for idea in ideas:
            d[idea[0]].add(idea[1:])
        
        for (x,y) in combinations(d, 2):
            temp = len(d[x] & d[y])
            ans += (len(d[x])-temp)*(len(d[y])-temp)


        return ans*2