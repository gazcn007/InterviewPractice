class Solution:
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        toRet = ""
        for i in range(0, len(s)):
            toRet = s[i]+toRet
        return toRet

S = Solution()
print(S.reverseString('1'))