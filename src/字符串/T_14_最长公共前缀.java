package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-28 14:54
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * 需要两层循环
 */
public class T_14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        // 假设这个数组中的第一个字符串就是最长公共前缀
        // 当找到比这个假设值长度还小的元素，就让这个元素最为公共前缀
        // 依次比较这个元素和其他元素每一位的字符。找到公共的部分更新这个假设值
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }


    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) break;
            }
            prefix = prefix.substring(0, j);
            if (prefix.isEmpty()) return prefix;
        }
        return prefix;
    }
}
