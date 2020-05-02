package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-22 16:37
 *
 * https://leetcode-cn.com/problems/compare-version-numbers/
 *
 */
public class T_165_版本号比较 {
    public static int compareVersion(String version1, String version2) {
        // 先分割
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");

        // 从头到尾遍历
        int i = 0, j = 0;
        int len1 = versions1.length;
        int len2 = versions2.length;
        while(i < len1 || j < len2) {
            String sv1 = i < len1 ? versions1[i] : "0";
            String sv2 = j < len2 ? versions2[j] : "0";
            int v1 = Integer.valueOf(sv1);
            int v2 = Integer.valueOf(sv2);
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            else {
                i++;
                j++;
            }
        }
        return 0;
    }

    // 不用加号的加法
    public static int add(int a, int b) {
        while( b != 0) {
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
//        add(12,34);

        System.out.println(compareVersion2("2.3.42","2.3.44"));
        System.out.println(compareVersion2("2.3.42","2.3.24"));
        System.out.println(compareVersion2("1.3.42","2.3.44"));
        System.out.println(compareVersion2("3.3.42","2.3.44"));
        System.out.println(compareVersion2("2.3.42","2.3.42"));
    }

    // 再写一遍
    public static int compareVersion2(String version1, String version2) {
        // 分割，正序遍历，不够补零，相等指针移动
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");

        int i = 0, j = 0;
        int len1 = vers1.length;
        int len2 = vers2.length;
        while (i < len1 || j < len2) {
            int v1 = i < len1 ? Integer.parseInt(vers1[i]) : 0;
            int v2 = j < len2 ? Integer.parseInt(vers2[j]) : 0;
            if (v1 < v2) return -1;
            else if (v1 > v2) return 1;
            else {
                i++;
                j++;
            }
        }
        return 0;
    }
}
