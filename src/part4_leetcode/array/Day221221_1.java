package part4_leetcode.array;

public class Day221221_1 {
    public boolean checkWon(int[][] board) {
        // write code here
        int len = board.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum += board[i][j];
                if (sum == len) return true;
            }
        }
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum += board[j][i];
                if (sum == len) return true;
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += board[i][i];
            if (sum == len) return true;
        }
        sum = 0;
        for (int i = 0; i < len; i++) {
            sum += board[i][len - i - 1];
            if (sum == len) return true;
        }
        return false;
    }
}
