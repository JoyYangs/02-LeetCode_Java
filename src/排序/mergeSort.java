package 排序;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-05-02 12:18
 *
 * 归并排序：
 * 针对已经排好序的数组，将其合并为一个新的有序数组
 * 定义三个指针分别表示三个数组的下标
 * 比较要排序的两个数组的元素对大数组进行insert
 *
 */
public class mergeSort {

    // 从后往前遍历也可以
    public static int[] merge_sort(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] nums = new int[len1 + len2];

        while (i < len1 || j < len2) {
            if (i < len1 && j < len2) {
                if (nums1[i] <= nums2[j]) {
                    nums[k++] = nums1[i++];
                } else {
                    nums[k++] = nums2[j++];
                }
//                k++;
            } else if (i < len1) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,11,15,17};
        int[] nums2 = {2,4,6,8,10,12,13,14,16};
        System.out.println(Arrays.toString(merge_sort(nums1, nums2)));
    }
}
