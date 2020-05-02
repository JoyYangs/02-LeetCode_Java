package 数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @author joyeYang
 * @date 2020-04-16 16:38
 */
public class Test_有序数组变无序 {

    public static void main(String[] args) {

        int[] nums = {1,3,5,6,7,8,9,22,44,55,66};
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(unsortArray(nums)));
        }
    }

    public static int[] unsortArray(int[] nums) {

        int len = nums.length;
        int[] arr = Arrays.copyOf(nums, len);
        HashSet<Integer> set = new HashSet<>();

        int i = 0, random = (new Random()).nextInt(len);
        while (i < len) {
            while (!set.add(random)) {
                random = (new Random()).nextInt(len);
            }
            arr[random] = nums[i++];
        }
        return arr;
    }
}
