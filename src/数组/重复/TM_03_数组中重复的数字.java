package 数组.重复;

import java.util.HashSet;
import java.util.Set;

/**
 * @author joyeYang
 * @date 2020-04-13 00:23
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 *
 * 找到任意一个重复的元素就返回
 * 数组长度为n，元素值在0～n-1之间
 *
 * 直接用Set: set.add(x) 方法返回值为boolean类型，true表示添加成功，false表示已经存在该值，添加失败
 */
public class TM_03_数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (!set.add(num)) return num;
        }
        return -1;
    }
}
