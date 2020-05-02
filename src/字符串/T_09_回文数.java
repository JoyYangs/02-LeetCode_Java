package 字符串;

/**
 * @author joyeYang
 * @date 2020-05-02 13:52
 *
 * https://leetcode-cn.com/problems/palindrome-number
 */
public class T_09_回文数 {


    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev = 0;
        // 反转一半数字
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev/10;
    }

}
