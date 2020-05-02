package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-28 19:20
 *
 * https://leetcode-cn.com/problems/add-digits/
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数
 *
 */
public class T_258_各位相加 {
    // 0到9 直接返回
    // 10以上 进行计算
    public int addDigits(int num) {
        while(num >= 10) {
            int sum = 0;
            String s = String.valueOf(sum);
            for(int i=0; i<s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            num = sum;
        }
        return num;
    }

    // 再写一遍
    public static int addDigits2(int num) {
        while (num >= 10) {
            int sum = 0;
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(addDigits2(123));
        System.out.println(addDigits2(1));
        System.out.println(addDigits2(10));
        System.out.println(addDigits2(12348));
    }
}
