package 数组;

import java.util.Arrays;

/**
 * @author joyeYang
 * @date 2020-04-27 07:56
 */
public class Test_Sort {

    public static void bubbleSort(int[] nums) {
        boolean flag = false;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }else {
                flag = false;
            }
        }
    }


    public static void selectSort(int[] nums) {

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

    public static void quickSort(int[] nums, int L, int R) {
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
        quickSort(nums, L, r-1);
        quickSort(nums, r+1, R);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {45,6,73,47,99,20,1,3,-10,4,22};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[] {45,6,73,47,99,20,1,3,-10,4,22};
        selectSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
