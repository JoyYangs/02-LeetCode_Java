package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-28 19:27
 *
 * https://leetcode-cn.com/problems/add-strings/
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和
 *
 */
public class T_415_字符串相加 {

    public static String addStrings(String num1, String num2) {
        // 倒序遍历，相加，进位，反转
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int temp = a + b + carry;
            carry = temp / 10;
            stringBuilder.append(temp % 10);
        }
        if (carry > 0) stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("123","56"));
    }

}
