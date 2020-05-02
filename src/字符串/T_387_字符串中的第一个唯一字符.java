package 字符串;

import java.util.HashMap;

/**
 * @author joyeYang
 * @date 2020-04-26 18:58
 *
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * 返回第一个唯一字符的下标
 */
public class T_387_字符串中的第一个唯一字符 {

    public int firstUniqChar(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String string = "yshd123DFFg,, br,,tb";
        System.out.println(string.toLowerCase().replaceAll("\\W+", ""));
    }
}
