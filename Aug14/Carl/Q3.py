class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ""
        shortestStr = min(strs, key=len)
        for i in range(0, len(shortestStr)):
            for other in strs:
                if other[i] != shortestStr[i]:
                    return shortestStr[0:i]
        return shortestStr

S = Solution()
print(S.longestCommonPrefix(['13','']))