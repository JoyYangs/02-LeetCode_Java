package 排序;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-05-02 12:18
 *
 * 插入排序:
 * 原有数组分为两组，一组一个元素(即已经是有序的)，另一组为剩下的其他元素
 * 将其他元素分别插入到这个有序数组中，最终得到一个完整的有序数组
 *
 */
public class insertSort {

    public static int[] insert_sort(int[] nums) {
        if (nums.length <= 1) return nums;

        // 循环从1开始
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            while (nums[i-1] > key) {
                nums[i] = nums[i-1];
                i--;
                if (i == 0) break;
            }
            nums[i] = key;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {45,6,73,47,99,20,1,3,-10,4,22};
        System.out.println(Arrays.toString(insert_sort(arr1)));
    }


}
