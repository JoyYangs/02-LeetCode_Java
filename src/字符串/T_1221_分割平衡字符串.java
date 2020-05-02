package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-28 14:15
 *
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 *
 */
public class T_1221_分割平衡字符串 {

    public int balancedStringSplit(String s) {
        // 统计加减法
        int num = 0, count = 0;
        char[] chs = s.toCharArray();
        for (char c: chs) {
            if (c == 'L') num++;
            else num--;
            if (num == 0) count++;
        }
        return count;
    }
}
