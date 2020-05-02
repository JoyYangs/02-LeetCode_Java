package 数组.重复;

/**
 * @author joyeYang
 * @date 2020-04-12 22:53
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * 要求: 返回移除后数组的新长度
 *
 */
public class T_26_删除排序数组中的重复项 {

    /**
     * 相当于是如果i和j位置的值相等就让i前进一位，
     * 让j一直增加直到找到的j位置的值不等于i位置的值，用这个值替换i+1的位置，同时把i更新
     * 最后返回前i个元素就是没有重复项的数组
     */
    public int removeDuplicates(int[] nums) {
        /**
         * 先用一个变量来记录移除的个数
         */
        int i = 0;
        /**
         * 从1开始遍历数组，将每一个值和nums[count]比较
         */
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                /**
                 * 先把i的值+1
                 * 然后将nums[j]的值赋值给nums[i],此时i已经在新的值了
                 */
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

}
