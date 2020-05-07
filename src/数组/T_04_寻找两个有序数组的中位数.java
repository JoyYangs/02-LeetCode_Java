package 数组;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-04-12 22:35
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * 理解：这个题的意思其实就是找这两个有序数组重新排序后的中间值，考虑新数组奇数偶数个
 *
 * 解法：
 * 1- 合并两个有序数组为新的有序数组，然后找中位数
 * 2- 递归+二分: 分割后中位数自然在中间的两块中
 *
 */
public class T_04_寻找两个有序数组的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1 == null) return nums2[nums2.length / 2];
        if (nums2 == null) return nums1[nums1.length / 2];

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            m = m + n;
            n = m - n;
            m = m - n;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    // 合并数组找中位数
    public static int[] mergeTwoSortedArray(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int k = nums1.length + nums2.length - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 &&  j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums[k--] = nums1[i--];
                }else {
                    nums[k--] = nums2[j--];
                }
            }else if (i >= 0) {
                nums[k--] = nums1[i--];
            }else {
                nums[k--] = nums2[j--];
            }
        }
        return nums;
    }

    public static double findMedian(int[] nums1, int[] nums2) {
        int[] mergedNums = mergeTwoSortedArray(nums1, nums2);
        int len = mergedNums.length;
        System.out.println(Arrays.toString(mergedNums));
        if (len % 2 != 0) return mergedNums[len/2];
        else {
            return (double)(mergedNums[len/2] + mergedNums[len/2-1])/2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,7,9,11,13,15,17};
        int[] nums2 = {2,4,6,8,10,20};
        System.out.println(findMedian(nums1,nums2));
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

}
