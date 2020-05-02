package 排序;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-05-02 12:18
 *
 * 快排：
     * 指定数组中的随机一个元素作为标准
     * 把数组中其他大于这个元素的元素放在右边
     * 将数组中其他小于这个元素的元素放在左边
     * 直到数组完全有序
 * 结束条件就是 比较L和R的大小，如果L>R直接return
 *
 */
public class quickSort {

    public static void quick_sort(int[] nums, int L, int R) {
        if (L > R) return;
        int l = L, r = R;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l < r) nums[l] = nums[r];

            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) nums[r] = nums[l];
            if (l >= r) nums[l] = pivot;
        }

        /** Attention: 之前把这里的参数填错了，导致了排序没有排对 **/
        quick_sort(nums, L, r-1);
        quick_sort(nums, r+1, R);
    }

    public static void main(String[] args) {
        int[] arr = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        quick_sort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
