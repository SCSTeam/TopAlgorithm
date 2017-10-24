package challenges;

/**
 * Created by jizhang on 10/15/17.
 */
public class ChallengeAlgorithms {
    public static void main(String[] args){
        ChallengeAlgorithms test = new ChallengeAlgorithms();
        System.out.println(test.maxCut(new int[]{1,3,4,3,7,8,7,12}));
        System.out.println(test.maxCut(new int[]{1,3,4,7,12}));
        System.out.println(test.maxCut(new int[]{12,7,4,3,1}));
    }

    /**
     * we split the whole array into multiple subArrays, and try to sort the subArrays, finally you will get a whole
     * sorted array.
     * @param arr un-sorted
     * @return the max cuts allowed to form this kind of subArrays
     *
     * For example, [1, 2, 9, 4] we can split it into [1] [2] [9,4] with the max two cuts.
     */
    private int maxCut(int[] arr){
        if(arr == null || arr.length < 2) return 0;
        int n = arr.length;

        // dp[i][j] represents the max cuts on top of subArray[i,j]
        int[][] dp = new int[n][n];
        for(int len = 1; len < n; ++len){
            for(int i = 0; i +len < n; ++i){
                int j = len + i;

                // TODO we can have one global dpMin and dpMax to have O(1) to get max or min on the subarray
                // try construct the dpMax on the subarray [i, j]
                int[] max = new int[len+1];
                for(int k = i; k<= j; ++k) max[k-i] = k == i ? arr[k] : Math.max(max[k-i-1], arr[k]);

                // try construct the dpMax on the subarray [i, j]
                int[] min = new int[len+1];
                for(int k = j; k >= i; --k) min[k-i] = k == j ? arr[k] : Math.min(min[k-i+1], arr[k]);

                // manage to put cut inside the subarray
                for(int k = i+1; k<= j; ++k){
                    if(max[k-i-1] <= min[k-i]){
                        dp[i][j] = Math.max(dp[i][j],
                                dp[i][k-1] + dp[k][j] + 1);
                    }
                }
            }
        }

        return dp[0][n-1];
    }
}
