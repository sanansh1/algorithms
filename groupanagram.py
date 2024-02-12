import collections
class Solution:
    def groupanagram(self, input:list[str])->list[str]:
        mp={}
        ans=[]

        for s in input:
            sorted_str = ''.join(sorted(s))
            if sorted_str in mp:
                ans[mp[sorted_str]].append(s)
            else:
                mp[sorted_str] = len(ans)
                ans.append([s])

        return ans
    

if __name__=="__main__":
    d =  Solution()
    du = d.groupanagram(["eat","tea","tan","ate","nat","bat"])
    print("group anagram :{}".format(du))