package 数组.重复;

import java.util.HashSet;
import java.util.Set;

/**
 * @author joyeYang
 * @date 2020-04-13 00:29
 *
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 */
public class T_287_寻找重复数 {

    public int findDuplicate(int[] nums) {
        // 其数字都在 1 到 n 之间
        int first = nums[0];
        int second = nums[0];
        do {
            first = nums[first];
            second = nums[nums[second]];
        } while (first != second);

        int p1 = nums[0];
        int p2 = first;
        while(p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;


//        int first = nums[0];
//        int second = nums[0];
//        do {
//            first = nums[first];
//            second = nums[nums[second]];
//        } while (first != second);
//
//        int ptr1 = nums[0];
//        int ptr2 = first;
//
//        while (ptr1 != ptr2) {
//            ptr1 = nums[ptr1];
//            ptr2 = nums[ptr2];
//        }
//        return ptr1;
    }

    /**
     * 可以实现功能，但是空间复杂度不符合要求
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }
}
