package 数组.重复;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author joyeYang
 * @date 2020-04-28 20:06
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
 */
public class TM_56_1_数组中数字出现的次数 {

    // 异或，再写一遍
    public int[] singleNumbers1(int[] nums) {

        int ret = 0;
        for (int n: nums) {
            ret ^= n;
        }

        int f = 1;
        while ((ret & f) == 0) {
            f <<= 1;
        }

        int a = 0, b = 0;
        for (int num: nums) {
            if ((num & a) == 0) {
                a ^= num;
            }else {
                b ^= num;
            }
        }

        return new int[] {a, b};
    }

    // 笨办法
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n: map.keySet()) {
            if (map.get(n) == 1) res[i++] = n;
        }
        return res;
    }

    // 异或思想：出现一次的这种都可以用异或来处理
    public int[] singleNumbers2(int[] nums) {
        // 先全部异或
        int ret = 0;
        for (int n: nums) {
            ret ^= n;
        }
        // 分组异或
        int f = 1;
        while ((ret & f) == 0) {
            f <<= 1;
        }
        int a = 0, b = 0;
        for (int num: nums) {
            if ((num & f) == 0) {
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }

}
