package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author joyeYang
 * @date 2020-04-28 14:29
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class T_03_无重复字符的最长子串 {

    /**
     * 双指针法：两个指针从0开始，一个每次++，另一个在有重复的元素时候进行更新
     * 用一个变量来存储目前统计到的最长的长度，取值为当前值和end - start + 1的最大值
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            ans = Math.max(end - start + 1, ans);
            map.put(c, end + 1);
        }
        return ans;
    }

    /** 稍微优化版 */
    public int lengthOfLongestSubstring2(String s) {
        int ans = 0, n = s.length();
        int[] arr = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(arr[s.charAt(j)], i);
            ans = Math.max(j - i + 1, ans);
            arr[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    // 再写一遍，脑子记不住啊
    public int lengthOfLongestSubstring3(String s) {
        // ans, length, map start end
        int ans = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            ans = Math.max(end - start + 1, ans);
            map.put(c, end + 1);
        }
        return ans;
    }

}
