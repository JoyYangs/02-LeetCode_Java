package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-28 14:18
 *
 * https://leetcode-cn.com/problems/to-lower-case/
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
 * 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 */
public class T_709_转换成小写字母 {

    public String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chs = str.toCharArray();
        for (char c: chs) {
            if ('A' <= c && c <= 'Z') {
                c += 'a' - 'A';
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String toLowerCase2(String str) {

        char[] chs = str.toCharArray();
        for (char c: chs) {
            if ('A' <= c && c <= 'Z') {
                c += 'a' - 'A';
            }
        }
        return String.valueOf(chs);
    }
}
