package 数组;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-04-14 10:04
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * 两个数组A和B，把b的值合并到a，但是还要保证顺序
 */
public class T_88_合并两个有序数组 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1, p1 = m - 1, p2 = n - 1;
        while(p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

//    public static void main(String[] args) {
//
//        merge(new int[]{1,2,3,0,0,0,0,0,0}, 3, new int[]{2,5}, 2);
//    }
}
