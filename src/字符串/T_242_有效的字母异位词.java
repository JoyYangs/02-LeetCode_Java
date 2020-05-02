package 字符串;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-04-13 17:14
 *
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 */
public class T_242_有效的字母异位词 {
    /**
     * 如果符合异位词的条件，那么两个字符串排序后肯定是一样的
     * 如果字符串长度不一样，那就肯定不是异位词
     *
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    /**
     * 哈希表1
     * s = "anagram", t = "nagaram"
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count: counter) {
            if (count != 0) return false;
        }
        return true;
    }

    /**
     * 哈希表2
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram3("apedls","sldepa"));
    }

    // 再写一遍
    public static boolean isAnagram4(String s, String t) {
        // 长度不相等直接返回false
        // 定一个数组26长度，遍历两次，一个++
        // 另一次 --，--的时候顺便判断是不是小于0.小于就直接返回false
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counter[t.charAt(i) - 'a']--;
            if (counter[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

}
