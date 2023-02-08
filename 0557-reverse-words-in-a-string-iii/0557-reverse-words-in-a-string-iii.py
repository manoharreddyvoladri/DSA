class Solution(object):
    def reverseWords(self, s):
        l = s.split()
        res = []
        for i in l:
            res.append(i[::-1])
        return " ".join(res)    