package 数组;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author joyeYang
 * @date 2020-05-06 11:40
 *
 * https://leetcode-cn.com/problems/4sum/
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 */
public class T_18_四数之和 {

    // 在三数之和基础上进行改进
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 先判断长度
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) return list;

        // 还是先排序
        Arrays.sort(nums);
        // 开始遍历
        // 去除最后面三个元素的遍历，因为会在接下来的操作中包含这三个元素
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            // 判断是否重复元素
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int min1 = nums[i] + nums[i+1] + nums[i+2] + nums[i+3];
            // 先判断最值
            if (min1 > target) break;
            int max1 = nums[i] + nums[len-1] + nums[len-2] + nums[len-3];
            if (max1 < target) break;

            for (int j = i+1; j < len - 2; j++) {
                // 同样做一下判断
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                // 定义指针
                int l = j+1, r = len - 1;
                // 再次获取最值
                int min2 = nums[i] + nums[j] + nums[l] + nums[l+1];
                if (min2 > target) break;
                int max2 = nums[i] + nums[j] + nums[r] + nums[r-1];
                if (max2 < target) break;

                // 进入计算
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        while(l < r && nums[l]==nums[l-1]){
                            l++;
                        }
                        r--;
                        while(l < r && nums[r] == nums[r+1]){
                            r--;
                        }
                    }else if (sum < target) {
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        fourSum(new int[]{-1,0,1,2,-1,-4}, -1);
    }
}
