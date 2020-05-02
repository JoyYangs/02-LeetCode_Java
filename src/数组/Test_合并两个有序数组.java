package 数组;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-04-26 13:25
 *
 * LeetCode上的和这个不太一样，这个是用一个新的数组来接收两个原有数组的数据
 *
 * 原来这个题这么简单~！！！
 */
public class Test_合并两个有序数组 {

    public static int[] mergeTwoSortedArray(int[] nums1, int[] nums2) {
        // 已知nums1 和 nums2 有序
        int[] nums = new int[nums1.length + nums2.length];
        // 循环遍历，考虑下标
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a < nums1.length && b < nums2.length) {
                if (nums1[a] < nums2[b]) {
                    nums[i] = nums1[a++];
                }else {
                    nums[i] = nums2[b++];
                }
            }else if (a < nums1.length) {
                // 说明nums2已经遍历完毕
                nums[i] = nums1[a++];
            }else if (b < nums2.length) {
                nums[i] = nums2[b++];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,11,12,13,16};
        int[] nums2 = {2,4,6,8,10,14};
        System.out.println(Arrays.toString(mergeTwoSortedArray(nums1, nums2)));
    }
}
