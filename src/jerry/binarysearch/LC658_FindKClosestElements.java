package jerry.binarysearch;
import java.util.*;

/**
 * 1. Find the closest
 * 2. 向左向右两个指针，谁小移谁
 */

public class LC658_FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<Integer>();
        }

        Deque<Integer> dq = new LinkedList<>();
        int closestIdx = findClosest(arr, x);
        int closest = arr[closestIdx];
        dq.offerLast(closest);
        int l = closestIdx - 1, r = closestIdx + 1;
        int count = 1;
        while (count < k) {
            if (l < 0) {
                dq.offerLast(arr[r++]);
            } else if (r >= arr.length) {
                dq.offerFirst(arr[l--]);
            } else {
                int lDiff = Math.abs(arr[l] - x);
                int rDiff = Math.abs(arr[r] - x);

                if (lDiff <= rDiff) {
                    dq.offerFirst(arr[l--]);
                } else {
                    dq.offerLast(arr[r++]);
                }
            }
            count++;
        }

        return new ArrayList<Integer>(dq);
    }

    public int findClosest(int[] arr, int x) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0, high = arr.length - 1;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (Math.abs(arr[low] - x) <= Math.abs(arr[high] - x)) {
            return low;
        } else {
            return high;
        }
    }
}
