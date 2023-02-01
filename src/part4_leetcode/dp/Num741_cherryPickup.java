package part4_leetcode.dp;

public class Num741_cherryPickup {
    public static void main(String[] args) {
        int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
        System.out.println(cherryPickup(grid));
    }
    public static int cherryPickup(int[][] grid) {
        return process1(grid, 0, 0, 0, 0);
    }

    private static int process1(int[][] grid, int x1, int y1, int x2, int y2) {
        //递归终止条件，当两个人都走到了目标位置
        if (x1 == grid.length - 1 && y1 == grid[0].length - 1) {
            //如果此位置是-1
            if (grid[x1][y1] == -1) {
                return -1;
            }
            if (grid[x1][y1] == 0) {
                return 0;
            }
            return 1;
        }
        //当前位置 两个人加起来能获得多少樱桃
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return -1;
        }
        int cur = 0;

        if (x1 == x2 && y1 == y2) {
            if (grid[x1][y1] == 1) {
                cur = 1;
            }
        } else {
            int cur_a = grid[x1][y1] == 1 ? 1 : 0;
            int cur_b = grid[x2][y2] == 1 ? 1 : 0;
            cur = cur_a + cur_b;

        }

        //两个人同时走一步的情况，取最好的下一个位置
        // 下 下
        int p1 = -1;
        if (x1 + 1 < grid.length && x2 + 1 < grid.length) {
            p1 = process1(grid, x1 + 1, y1, x2 + 1, y2);
        }
        // 下 右
        int p2 = -1;
        if (x1 + 1 < grid.length && y2 + 1 < grid[0].length) {
            p2 = process1(grid, x1 + 1, y1, x2, y2 + 1);
        }
        // 右 下
        int p3 = -1;
        if (y1 + 1 < grid[0].length && x2 + 1 < grid.length) {
            p3 = process1(grid, x1, y1 + 1, x2 + 1, y2);
        }
        // 右 右
        int p4 = -1;
        if (y1 + 1 < grid[0].length && y2 + 1 < grid[0].length) {
            p4 = process1(grid, x1, y1 + 1, x2, y2 + 1);
        }
        int next = Math.max(Math.max(p1, p2), Math.max(p3, p4));

        if (next == -1) return -1;

        return cur + next;
    }
}
