class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        list3=nums1+nums2
        list3.sort()
        length=len(list3)
        if length%2==0:
            r=list3[(length/2)-1]+list3[(length/2)]
            return r*0.5
        else : return list3[(length-1)/2]
        