package 排序;

/**
 * @author joyeYang
 * @date 2020-05-02 12:17
 *
 * 相邻元素比大小，按照规定，如果和规定比较是逆序就交换
 *
 */
public class bubbleSort {

    public static void bubble_sort(int[] nums) {

        boolean flag = true;
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

//    test nums
//    int[] arr1 = new int[] {45,6,73,47,99,20,1,3,-10,4,22};

}
