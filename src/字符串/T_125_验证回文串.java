package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-26 19:43
 *
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * 字符串中数字字母为有效字符
 *
 */
public class T_125_验证回文串 {

    public static boolean isPalindrome(String s) {
        // 两端比较
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        if (s.length() < 2) return true;
        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome2(s.substring(1,s.length() - 1));
    }

    public static void main(String[] args) {

//        char[] chars = new char[]{'s', 'y', 'u', 'e'};
//        System.out.println(String.valueOf(chars));

//        String string = "as,df.r.f,dsta";
        String string = "abdcercdba";
        System.out.println(isPalindrome2(string));
    }
}
