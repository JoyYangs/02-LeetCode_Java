package 栈;

/**
 * @author joyeYang
 * @date 2020-04-13 16:21
 *
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 *
 */
public class T_1021_删除最外层的括号 {

    public String removeOuterParentheses(String S) {
        int num = 0, index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') num++;
            else num--;
            if (num == 0) {
                stringBuilder.append(S.substring(index, i));
                index = i + 2;
            }
        }


        return stringBuilder.toString();
    }

    /** 优化版本 */
    public String removeOuterParentheses2(String S) {
        int num = 0, index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (c == ')') num--;
            if (num >= 1) stringBuilder.append(c);
            if (c == '(') num++;
        }
        return stringBuilder.toString();
    }
}
