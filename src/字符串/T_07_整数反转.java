package 字符串;

/**
 * @author joyeYang
 * @date 2020-05-02 13:25
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 *
 * 123 > 321
 * -123 > -321
 * 120 > 21
 */
public class T_07_整数反转 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res * 10 / 10 != res) {
                res = 0;
                break;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public int reverse3(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            // 或者这样也可以：
//            if ((pop < 0 && res < (Integer.MIN_VALUE - pop) / 10) || (pop > 0 && res > (Integer.MAX_VALUE - pop) / 10)) {
//                return 0;
//            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            res = res * 10 + pop;
            x /= 10;
        }
        return res;
    }


    // 笨办法：不要考虑字符串，数字问题就用算术来处理
    public int reverse2(int x) {

        int sign = x < 0 ? -1 : 1;
        char[] s = String.valueOf(Math.abs(x)).toCharArray();
        int i = 0, j = s.length - 1;

        char temp;
        while (i < j) {
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
        int num = 0;
        try {
            num = Integer.valueOf(String.valueOf(s));
        }finally {
            return num * sign;
        }
    }
}
