package part4_leetcode.array.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num54_spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        int count = matrix.length * matrix[0].length;

        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l  && t <= b; i--) {
                list.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >= t && l <= r; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }

        return list;
    }
}
