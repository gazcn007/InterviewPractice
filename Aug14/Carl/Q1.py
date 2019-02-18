class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        if len(a) > len(b):
            longStr = a
            shortStr = b
        else:
            longStr = b
            shortStr = a

        rStr = ""
        carry = 0
        # carry = 1 , 1 , 1
        for i in range(0, len(longStr)):
            longStrChar = longStr[len(longStr)-1-i]
            shortStrChar = shortStr[len(shortStr)-1-i] if (i < len(shortStr)) else '0'
            if longStrChar == shortStrChar == '1':
                if carry == 1:
                    rStr = '1' + rStr
                else:
                    rStr = '0' + rStr
                carry = 1
            elif longStrChar == shortStrChar == '0':
                if carry == 1:
                    rStr = '1' + rStr
                else:
                    rStr = '0' + rStr
                carry = 0
            else:
                if carry == 1:
                    rStr = '0' + rStr
                else:
                    rStr = '1' + rStr
        if carry == 1:
            rStr = '1'+rStr
        return rStr

S = Solution()
print(S.addBinary('101','11'))
