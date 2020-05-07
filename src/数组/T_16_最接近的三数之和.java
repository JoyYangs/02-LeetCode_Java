package 数组;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-05-02 15:04
 *
 * https://leetcode-cn.com/problems/3sum-closest/
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class T_16_最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        // 先排序 再遍历
        Arrays.sort(nums);
        // 假设前三个元素的和就是符合条件的
        int res = nums[0] + nums[1] + nums[2];
        // 开始遍历
        for (int i = 0; i < nums.length - 2; i++) {
            // 判断重复元素
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // 定义双指针
            int l = i+1, r = nums.length - 1;
            // l < r 的时候进行遍历
            while (l < r) {
                // 求和
                int sum = nums[i] + nums[l] + nums[r];
                // 比较
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    // 更新假定的res的值
                    res = sum;
                }
                if (sum == target) return res;
                else if (sum > target) r--;
                else l++;
            }

        }
        return res;
    }
}
