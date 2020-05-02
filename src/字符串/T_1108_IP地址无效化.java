package 字符串;

/**
 * @author joyeYang
 * @date 2020-04-28 14:10
 *
 * https://leetcode-cn.com/problems/defanging-an-ip-address/
 *
 * 用[.] 代替 .
 *
 */
public class T_1108_IP地址无效化 {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }

    public String defangIPaddr2(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chs = address.toCharArray();
        for(char c: chs) {
            if (c == '.') stringBuilder.append("[.]");
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
