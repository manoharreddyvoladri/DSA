class Solution(object):
    def myPow(self, x, n):
        #1 way with built-in -> ~15ms, 84%
        return pow(x, n)

        #2 way without built-in -> ~13ms, 88%
        return x**n