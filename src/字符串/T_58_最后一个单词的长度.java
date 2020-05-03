package 字符串;

/**
 * @author joyeYang
 * @date 2020-05-03 15:19
 *
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 */
public class T_58_最后一个单词的长度 {

    // 从后遍历
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }
}
