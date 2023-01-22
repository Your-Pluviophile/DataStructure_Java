package part4_leetcode.array.coding;

public class Num59_generateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int num = 1, target = n * n;

        while (num <= target) {
            // left to right
            for (int i = left; i <= right; i++) {
                arr[top][i] = num++;
            }
            top++;
            //top to bottom
            for (int j = top; j <= bottom; j++) {
                arr[j][right] = num++;
            }
            right--;
            //right to left
            for (int i = right; i >= left; i--) {
                arr[bottom][i] = num++;
            }
            bottom--;
            //bottom to top
            for (int j = bottom; j >= top; j--) {
                arr[j][left] = num++;
            }
            left++;
        }
        return arr;
    }
}
