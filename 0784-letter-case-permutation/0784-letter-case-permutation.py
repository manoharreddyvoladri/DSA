class Solution:
    def permutationtinator(self,s,ans,count):
        for i in range(count,len(s)):
            if(s[i].isalpha()):
                ch = s[:i]+s[i].swapcase()+s[i+1:]
                ans.append(ch)
                self.permutationtinator(ch,ans,i+1)
        return ans



    def letterCasePermutation(self, s: str) -> List[str]:

        ans = [s]
        count = 0
        return self.permutationtinator(s,ans,count)