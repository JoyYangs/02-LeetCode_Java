package 数组.重复;

/**
 * @author joyeYang
 * @date 2020-04-12 23:23
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。(即差的绝对值不超过K)
 *
 */
public class T_219_存在重复元素2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int n = Math.max(i-k, 0);
            for (int j = n; j < i; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;

//        for (int i = 0; i < nums.length; i++) {
//            int n = Math.max(i-k, 0);
//            for (int j = n; j < i; j++) {
//                if (nums[i] == nums[j]) return true;
//            }
//        }
//        return false;
    }
    /**
     * 如果直接两层for循环的话遍历的次数太多了
     * 这里先求出j参与循环的初始值的可能值 int n = Math.max(i-k, 0);
     */
}
