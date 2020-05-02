package 字符串;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author joyeYang
 * @date 2020-04-22 13:42
 *
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * "4193 wi50th    wo2rds678"   ===> 4193
 * "423 34rte" ====> 423
 *
 */
public class T_08_字符串转换整数atoi {

    public static int myAtoi(String str) {

        /**
         * 先根据空格进行拆分，拆分后只需要操作第一段的内容
         * 考虑多个空格的问题，分割用正则
         *
         * 判断第一段内容的情况：
         * 1- 第一位如果是-，需要记录，接着看第二位
         *      如果是数字就是负数，继续看接下来的内容
         *          如果整体小于最小负数，就返回最小整数值
         *      如果是+，就继续看剩下的，如果是数字就整体是负数
         *      如果不是数字，就直接返回0
         * 2- 第一位如果是+，看下一位是什么，
         *      如果是数字，就是整数，继续判断接下来的每一位
         *          如果整体大于最大int值，就返回最大int值
         *      如果是其他，直接返回0
         */

        str = str.trim().split("\\ +")[0];
        int sign = str.charAt(0) == '-' ? -1 : 1;
        int idx = str.charAt(0) == '-' ? 1 : 0;
        int res = 0;
        for (; idx < str.length(); idx++) {
            if (Character.isDigit(str.charAt(idx))) {
                int x = str.charAt(idx) - '0';
                if (res > (Integer.MAX_VALUE - x) / 10) {
                    return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                res = res * 10 + x;
            }else if (idx == 1 && str.charAt(idx) == '+') {
                // 这里只是为了让idx++
            }else break;
        }
        return res * sign;
















//        str = str.trim();
//        String reg = "^[\\+\\-]?\\d+";
//        Pattern pattern = Pattern.compile(reg);
//        Matcher matcher = pattern.matcher(str);
//        int value = 0;
//        if (matcher.find()) {
//            try {
//                value = Integer.parseInt(str.substring(matcher.start(), matcher.end()));
//            }catch (Exception e) {
//                value = str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//            }
//        }
//        return value;


//        str = str.trim().split("\\ +")[0];
//        int sign = str.charAt(0) == '-' ? -1 : 1;
//        int res = 0;
//        int i = sign < 0 ? 1 : 0;
//        for(; i<str.length(); i++) {
//            if (Character.isDigit(str.charAt(i))) {
//                int x = str.charAt(i) - '0';
//                if (res > (Integer.MAX_VALUE - x) / 10) {
//                    return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//                }
//                res = res * 10 + x;
//            }else return 0;
//        }
//        return res * sign;

    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("4193 wi5th word6s78"));
//        System.out.println(myAtoi("     -42"));
    }
}
