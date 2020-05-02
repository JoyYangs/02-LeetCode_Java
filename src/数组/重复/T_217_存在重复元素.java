package 数组.重复;

import java.util.HashSet;
import java.util.Set;

/**
 * @author joyeYang
 * @date 2020-04-12 23:18
 *
 * https://leetcode-cn.com/problems/contains-duplicate/
 *
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 解法：利用Set没有重复元素的特点来实现, 遍历元素添加到set，
 *      添加之前先判断set中是否已经存在，存在则直接返回true，不存在就添加，最终返回false
 */
public class T_217_存在重复元素 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }
}
