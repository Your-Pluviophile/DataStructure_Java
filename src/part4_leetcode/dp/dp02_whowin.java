package part4_leetcode.dp;

public class dp02_whowin {
    public static void main(String[] args) {
        System.out.println(whowin1(new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7}));
        System.out.println(whowin2(new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7}));
        System.out.println(whowin3(new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7}));

    }
    //返回获胜者的分数

    /**
     * 给定一个整形数组cards，代表**分数不同的纸牌（正数）**排成一排，
     * 玩家A和B依次拿走纸牌，规定玩家A先拿，玩家B后拿，
     * 每个玩家只能拿走**最左或最右**的纸牌，
     * 假设A，B玩家都绝顶聪明，
     *
     * @param cards
     * @return 返回获胜者的分数。
     */
    public static int whowin1(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        return Math.max(first(cards, 0, cards.length - 1),
                second(cards, 0, cards.length - 1));
    }

    public static int first(int[] cards, int L, int R) {
        if (L == R) return cards[L];
        return Math.max(cards[L] + second(cards, L + 1, R), cards[R] + second(cards, L, R - 1));
    }

    public static int second(int[] cards, int L, int R) {
        if (L == R) return 0;
        return Math.min(first(cards, L + 1, R), first(cards, L, R - 1));
    }


    public static int whowin2(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        int N = cards.length;
        int fmap[][] = new int[N][N];
        int smap[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                smap[i][j] = -1;
            }
        }
        return Math.max(first1(cards, 0, cards.length - 1, fmap, smap),
                second1(cards, 0, cards.length - 1, fmap, smap));
    }

    public static int first1(int[] cards, int L, int R, int fmap[][], int smap[][]) {
        if (fmap[L][R] != -1) return fmap[L][R];
        if (L == R) {
            fmap[L][R] = cards[L];
        } else {
            fmap[L][R] = Math.max(cards[L] + second1(cards, L + 1, R, fmap, smap), cards[R] + second1(cards, L, R - 1, fmap, smap));
        }
        return fmap[L][R];
    }

    public static int second1(int[] cards, int L, int R, int fmap[][], int smap[][]) {

        if (smap[L][R] != -1) return smap[L][R];
        if (L == R) {
            smap[L][R] = 0;
        } else {
            smap[L][R] = Math.min(first1(cards, L + 1, R, fmap, smap), first1(cards, L, R - 1, fmap, smap));
        }
        return smap[L][R];
    }

    public static int whowin3(int[] cards) {
        if (cards == null || cards.length == 0) {
            return 0;
        }
        int N = cards.length;
        int fmap[][] = new int[N][N];
        int smap[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            fmap[i][i] = cards[i];
        }
        for (int startCol = 1; startCol < N; startCol++) {
            int L = 0;
            int R = startCol;
            while (R < N) {
                fmap[L][R] = Math.max(cards[L] + smap[L + 1][R], cards[R] + smap[L][R - 1]);
                smap[L][R] = Math.min(fmap[L + 1][R], fmap[L][R - 1]);
                L++;
                R++;
            }
        }
        return Math.max(fmap[0][N - 1], smap[0][N - 1]);
    }
}
