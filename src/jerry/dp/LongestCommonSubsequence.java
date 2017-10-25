package jerry.dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence sol = new LongestCommonSubsequence();

        String s = "abbcdddeffg";
        String t = "bcbbcdf";

        int n = sol.longest(s, t);
        System.out.println(n);
    }

    public int longest(String s, String t) {
        // Write your solution here.
        if (s == null || t == null) {
            return 0;
        }

        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int x = s.length(), y = t.length();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int[][] M = new int[x][y];
        M[0][0] = sArray[0] == tArray[0] ? 1 : 0;

        for (int i = 1; i < x; i++) {
            if (M[i - 1][0] == 1) {
                M[i][0] = 1;
            } else if (sArray[i] == tArray[0]) {
                M[i][0] = 1;
            } else {
                M[i][0] = 0;
            }
        }

        for (int j = 1; j < y; j++) {
            if (M[0][j - 1] == 1) {
                M[0][j] = 1;
            } else if (sArray[0] == tArray[j]) {
                M[0][j] = 1;
            } else {
                M[0][j] = 0;
            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                int limit = Math.min(i + 1, j + 1);
                if (sArray[i] == tArray[j] && M[i][j] < limit) {
                    M[i][j] += 1;
                }
            }
        }

        return M[x - 1][y - 1];
    }
}
