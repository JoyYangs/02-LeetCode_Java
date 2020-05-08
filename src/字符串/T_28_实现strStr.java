package 字符串;

/**
 * @author joyeYang
 * @date 2020-05-07 15:22
 *
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 *
 */
public class T_28_实现strStr {

    public int strStr(String haystack, String needle) {
        int L = needle.length();
        int n = haystack.length();
        for (int start = 0; start < n - L + 1; start++) {
            if (haystack.substring(start, start + L).equals(needle)) return start;
        }
        return -1;
    }

    // 上面实现的稍微优化版
    public int strStr2(String haystack, String needle) {

        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;
        int pn = 0;
        while (pn < n - L + 1) {
            if (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            int pL = 0, curlen = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++curlen;
            }

            if (curlen == L) return pn - L;

            pn = pn - curlen + 1;
        }
        return -1;
    }
}
