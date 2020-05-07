package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author joyeYang
 * @date 2020-05-02 14:01
 *
 * https://leetcode-cn.com/problems/3sum/
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 */
public class T_15_三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if (len < 3) return list;

        // 排序
        System.out.println(Arrays.toString(nums));
        quick_sort(nums, 0, len - 1);
        System.out.println("---------");
        System.out.println(Arrays.toString(nums));

        // 遍历
        for (int i = 0; i < len; i++) {
            // 这里用nums[i]是为了避免后面的重复计算
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l ++;
                    while (l < r && nums[r] == nums[r-1]) r --;
                    l ++;
                    r --;
                }else if (sum > 0) {
                    r --;
                }else {
                    l ++;
                }
            }
        }

        System.out.println(list);
        return list;
    }

    public static void quick_sort(int[] nums, int L, int R) {
        if (L > R) return;
        int left = L, right = R, pivot = nums[L];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) nums[right] = nums[left];
            if (left >= right) nums[left] = pivot;
        }
        quick_sort(nums, L, right-1);
        quick_sort(nums, right+1, R);
    }

    public static void main(String[] args) {
        int[] arr = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        threeSum(arr);
        threeSum2(arr);
    }


    public static List<List<Integer>> threeSum2(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) return res;

        int[] arr = Arrays.copyOf(nums, len);
        Arrays.sort(arr);

        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) break;
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == 0) {
                    res.add(Arrays.asList(arr[i], arr[l], arr[r]));
                    while (l < r && arr[l] == arr[l + 1]) l++;
                    while (l < r && arr[r] == arr[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        System.out.println(res);
        return res;
    }
}
