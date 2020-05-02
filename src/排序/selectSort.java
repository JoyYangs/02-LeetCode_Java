package 排序;

/**
 * @author joyeYang
 * @date 2020-05-02 12:18
 *
 * 选择排序：每一趟找出最小的值放到未排序的数据的最前面位置
 *
 * 先假设第一个值是最大(最小)值，然后和数组中的其他元素相比较
 * 最后判断找出来的最值和原本指定的值位置是否一样
 * 如果位置不一样就交换
 *
 */
public class selectSort {

    public static void select_sort(int[] nums) {

        for (int i=0; i<nums.length-1; i++) {
            int min = nums[i];
            int minIdx = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                nums[minIdx] = nums[i];
                nums[i] = min;
            }
        }
    }

}
