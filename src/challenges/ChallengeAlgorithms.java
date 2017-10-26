package stu.jzhang.algorithm;

/**
 * Created by jizhang on 10/15/17.
 */
public class ChallengeAlgorithms {
    public static void main(String[] args){
        ChallengeAlgorithms test = new ChallengeAlgorithms();
        System.out.println(test.maxCutsII(new int[]{1, 3,  4,3,  7  ,8,7  ,12}));
        System.out.println(test.maxCutsII(new int[]{1, 3, 4,7, 12}));
        System.out.println(test.maxCutsII(new int[]{12,7,4,3,1}));
        System.out.println(test.maxCutsII(new int[]{1,  2,  9,  4}));
        System.out.println(test.maxCutsII(new int[]{1,  1,  1,  1}));
        System.out.println(test.maxCutsII(new int[]{1, 0}));
    }

    /**
     * we split the whole array into multiple subarrays, and try to sort the subArrays, finally you will get a whole
     * sorted array.
     * @param arr un-sorted
     * @return the max cuts allowed to form this kind of subArrays
     *
     * For example, [1, 2, 9, 4] we can split it into [1] [2] [9,4] with the max two cuts.
     */
    public int maxCut(int[] arr){
        if(arr == null || arr.length < 2) return 0;
        int n = arr.length;

        // dp[i] represents the max cuts on top of subArray[0,i]
        int[] dp = new int[n];

        int[] max = new int[n];
        for(int k = 0; k < n; ++k) max[k] = k == 0 ? arr[k] : Math.max(max[k-1], arr[k]);

        int min;
        // try construct the dpMax on the subarray [i, j]
        for(int i = 1; i < n; ++i){
            min = arr[i];
            for(int j = i-1; j >= 0; --j){
                if(max[j] <= min){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                min = Math.max(min, arr[j]);
            }
        }

        return dp[n-1];
    }

    /**
     * Based on the solution above, we don't need to apply dp, we can directly to calculate the max cuts.
     * @param arr
     * @return
     */
    public int maxCutsII(int[] arr){
        if(arr == null || arr.length < 2) return 0;
        int n = arr.length;       

        int[] max = new int[n];
        for(int k = 0; k < n; ++k) max[k] = k == 0 ? arr[k] : Math.max(max[k-1], arr[k]);

        int total = 0, min = arr[n-1];
        for(int i = n-2; i >= 0; --i){
            if(max[i] <= min){
                total++;
            }

            min = Math.min(min, arr[i]);
        }

        return total;
    }
}
