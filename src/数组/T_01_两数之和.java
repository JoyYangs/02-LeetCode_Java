package 数组;

/**
 * @author joyeYang
 * @date 2020-04-12 22:32
 *
 * https://leetcode-cn.com/problems/two-sum/
 *
 *
 */
public class T_01_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            /** j = i+1 */
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new RuntimeException("did't find");
    }
}
