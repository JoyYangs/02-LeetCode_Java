package 数组.重复;

import java.util.*;

/**
 * @author joyeYang
 * @date 2020-04-12 23:52
 *
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 */
public class T_442_数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {

        /**
         * 考虑这个条件: 1 ≤ a[i] ≤ n
         * 可以对每次找到的数字x，进行这个操作，将数组的x-1位置的值变成负数
         * 这样再次找到这个数字x的时候，只要发现他对应的x-1位置的值已经是负数就说明出现第二次了
         */
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            // 先判断是不是已经为负数了
            if (nums[idx] < 0) {
                res.add(Math.abs(nums[i]));
            }
            nums[idx] = -nums[idx];
        }
        return res;

        // 可以但不够好
        /**
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int item : map.keySet()) {
            if (map.get(item) == 2) {
                list.add(item);
            }
        }
        return list;
        */
    }
}
