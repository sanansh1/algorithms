class Solution:
    def maxArea(self, height:list[int])->int:
        l, r =0, len(height)-1
        res = 0
        while l<r:
            res = max(res, min(height[l], height[r])*(r-l))
            if height[l]<height[r]:
                l+=1
            elif height[l]>=height[r]:
                r-=1

        return res

if __name__=="__main__":
    d =  Solution()
    du = d.maxArea([2,7,9,3,6,4,9])
    print("Max Area :{}".format(du))