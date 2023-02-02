package part1_ds;

class Solution {
    public int minCharacters(String a, String b) {
        int[] arr = new int[26];
        int[] brr = new int[26];
        int aLen = a.length(), bLen = b.length(), minOps = Integer.MAX_VALUE;

        for (int i = 0; i < aLen; i++) {
            arr[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < bLen; i++) {
            brr[b.charAt(i) - 'a']++;
        }

        int aTimes = 0, bTimes = 0;
        for (int i = 0; i < 26; i++) {
            aTimes += arr[i];
            bTimes += brr[i];
            minOps = Math.min(Math.min(aLen - bTimes + aTimes, bLen - aTimes + bTimes),
                    Math.min(minOps, aLen - arr[i] + bLen - brr[i]));
        }
        return minOps;
    }
}
