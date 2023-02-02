class Solution(object):
    def maxArea(self,height):
        index1=0
        size=len(height)
        size-=1
        p1=height[index1]
        p2=height[size]
        index2=size
        max=0
        j=0
        for i in (height):
            if(index1==index2):
                break
            if(max<min(p1,p2)*(size-j)):
                max=min(p1,p2)*(size-j)
            if(p2<p1):
                    p2=height[index2-1]
                    index2-=1
            else:
                index1+=1
                p1=height[index1]
            j+=1
        return max
        