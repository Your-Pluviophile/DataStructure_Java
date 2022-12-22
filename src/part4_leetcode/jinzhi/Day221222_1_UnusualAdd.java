package part4_leetcode.jinzhi;

public class Day221222_1_UnusualAdd {
    public int addAB(int A, int B) {
        // write code here
        int xor,and;
        while(B != 0){
            xor = B ^ A;
            and = B & A;
            A = xor;
            B = and << 1;
        }
        return A;

    }
}
