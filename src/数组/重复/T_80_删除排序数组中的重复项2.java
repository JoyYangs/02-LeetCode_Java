package 数组.重复;

/**
 * @author joyeYang
 * @date 2020-04-12 23:29
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 参考26题，将初始值和比较区间更改：i = 1; j = 2; if (nums[i-1] != nums[j]) {...}
 */
public class T_80_删除排序数组中的重复项2 {
    public static int removeDuplicates(int[] nums) {

        int i = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[i-1] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;

//        int i = 1;
//        for (int j = 2; j < nums.length; j++) {
//            if (nums[i-1] != nums[j]) {
//                nums[++i] = nums[j];
//            }
//        }
//        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,2,3,3,4};
        removeDuplicates(arr);
        System.out.println(arr);
    }
}
