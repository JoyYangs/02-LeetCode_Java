package 数组;

import java.util.HashSet;

/**
 * @author joyeYang
 * @date 2020-04-13 16:45
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 */
public class T_349_两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n1: nums1) set1.add(n1);
        for (int n2: nums2) set2.add(n2);

        if (set1.size() <= set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);

        /** 内置函数API: retainAll()   set1.retainAll(set2); 直接将set1中不包含set2的元素的元素剔除 */

    }

    public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int[] res = new int[set1.size()];
        int idx = 0;
        for (int x: set1) {
            if (set2.contains(x)) res[idx++] = x;
        }

        return res;
    }

}
