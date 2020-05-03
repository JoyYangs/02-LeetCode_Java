package 数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author joyeYang
 * @date 2020-05-03 15:52
 *
 * https://leetcode-cn.com/problems/pascals-triangle/
 *
 */
public class T_118_杨辉三角 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        list.add(firstRow);
        // 错位相加
        int size = list.size();
        while (size < numRows) {
            LinkedList<Integer> first = new LinkedList<>();
            first.addFirst(0);
            LinkedList<Integer> second = new LinkedList<>();
            second.addLast(0);
            for (int x: list.get(size-1)) {
                first.addFirst(x);
                second.addLast(x);
            }
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < first.size(); i++) {
                newRow.add(first.get(i) + second.get(i));
            }
            list.add(newRow);
            size++;
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        generate(10);
    }
}
