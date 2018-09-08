class Solution {
    public int compareVersion(String version1, String version2) {
        char[] charArray1 = version1.toCharArray();
        char[] charArray2 = version2.toCharArray();
        int prev1 = 0;
        int prev2 = 0;
        int i = 0;
        int j = 0;
        while(i < charArray1.length) {
            if (charArray1[i] == '.' || i == charArray1.length - 1) {
                int v1 = 0;
                if (charArray1[i] == '.') {
                    v1 = Integer.parseInt(new String(Arrays.copyOfRange(charArray1, prev1, i)));
                } else if (i == charArray1.length - 1) {
                    v1 = Integer.parseInt(new String(Arrays.copyOfRange(charArray1, prev1, i + 1)));
                }
                if (prev2 >= charArray2.length) {
                    if (v1 > 0) return 1;
                } else {
                   while(j < charArray2.length) {
                        if (charArray2[j] == '.' || j == charArray2.length - 1) {
                            int v2 = 0;
                            if (charArray2[j] == '.') {
                                v2 = Integer.parseInt(new String(Arrays.copyOfRange(charArray2, prev2, j)));
                            } else if (j == charArray2.length - 1) {
                                v2 = Integer.parseInt(new String(Arrays.copyOfRange(charArray2, prev2, j + 1)));
                            }
                            if (v1 < v2) {
                                return -1;
                            } else if (v1 > v2) {
                                return 1;
                            }
                            j++;
                            prev2 = j;
                            break;
                        } else {
                            j++;
                        }
                    }
                }
                prev1 = i + 1;
            }
            i++;
        }
        while(j < charArray2.length) {
            if (charArray2[j] == '.' || j == charArray2.length - 1) {
                int v2 = 0;
                if (charArray2[j] == '.') {
                    v2 = Integer.parseInt(new String(Arrays.copyOfRange(charArray2, prev2, j)));
                } else if (j == charArray2.length - 1) {
                    v2 = Integer.parseInt(new String(Arrays.copyOfRange(charArray2, prev2, j + 1)));
                }
                if (v2 > 0) return -1;
                prev2 = j + 1;
            }
            j++;
        }

        return 0;
    }
}
