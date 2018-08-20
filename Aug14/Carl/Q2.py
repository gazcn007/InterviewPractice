class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(needle) > len(haystack):
            return -1
        elif len(needle) == 0:
            return 0
        for i in range(0, len(haystack)):
            if len(haystack) - i < len(needle):
                return -1
            indexToRet = i
            for j in range(0, len(needle)):
                if haystack[i + j] != needle[j]:
                    indexToRet = -1
                    break
            if indexToRet != -1:
                return indexToRet
        return -1
