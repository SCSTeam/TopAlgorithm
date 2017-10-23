package common;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by mengzhou on 7/1/17.
 */
public class TestUtils {

    private TestUtils(){}
    private static Random mRd = new Random();
    private static final int MIN_SIZE = 10;
    private static final int MID_SIZE = 25;
    private static final int LARGE_SIZE = 100;
    private static final int EXTREM_SIZE = 10000;

    public static int[] shuffle(int[] array) {
        if(array.length < 2) return array;

        Random rd = new Random();
        for(int i = array.length - 1; i >= 0; i--) {
            int pos = rd.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[pos];
            array[pos] = temp;
        }
        return array;
    }

    public static int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    /**
     * unsorted random length array without duplicates
     * @return
     */
    public static int[] getArray() {
        return getArray(mRd.nextInt(MID_SIZE));
    }

    public static int[] getLargeArray() {
        return getArray(mRd.nextInt(EXTREM_SIZE) + LARGE_SIZE);
    }

    public static int[] getArray(int len) {
        int[] array = new int[len * 2];
        for(int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        shuffle(array);
        int[] input = Arrays.copyOf(array, len);
        return input;
    }

    public static int[] getArray(int len, boolean duplicate) {
        if(duplicate) {
            int[] array = new int[len];
            for(int i = 0; i < array.length; i++) {
                array[i] = mRd.nextInt(len);
            }
            return array;
        }
        return getArray(len);
    }

    public static int[] getSortedArray() {
        return sort(getArray());
    }

    public static int[] getSortedArray(int len) {
        int[] sort = sort(getArray(len));
        System.out.println("input: " + Arrays.toString(sort));
        return sort;
    }

    public static int[] getSortedArray(int len, boolean duplicate) {
        return sort(getArray(len, duplicate));
    }

    public static int[] getFixedArray(int start, int end) {
        if(start > end) return new int[]{};
        int[] array = new int[end - start + 1];
        for (int i = 0; i < array.length; i++) {
            array[i] = start + i;
        }
        return array;
    }

    public static ListNode getList() {
        return Utils.buildListNode(getArray());
    }

    public static ListNode getList(int[] values) {
        return Utils.buildListNode(values);
    }

    public static ListNode getList(int len) {
        return Utils.buildListNode(getArray(len));
    }

    public static ListNode getSortedList(int len) {
        return Utils.buildListNode(getSortedArray(len));
    }

    public static TreeNode getTree(int size) {
        int[] array = getArray(size);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            str.append(array[i] + ", ");
        }
        str.append(array[size - 1]);
        return Utils.buildTree(str.toString());
    }

    public static TreeNode getRandomTree(int size) {
        int[] array = getArray(size);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            str.append(array[i] + ", ");
            if(i % (mRd.nextInt(4) + 1) == 0) str.append("#, ");
        }
        str.append(array[size - 1]);
        return Utils.buildTree(str.toString());
    }

    public static TreeNode getBSTTree(int size) {
        return new TreeBuilder(getSortedArray(size)).getRoot();
    }

    public static TreeNode getBSTTree(int[] input) {
        return new TreeBuilder().buildTree(input);
    }

    public static char[] getBase() {
        char[] chars = new char[26];
        for(int i = 0; i < 26; i++) {
            chars[i] = (char) ('a' + i);
        }
        return chars;
    }

    public static String getString(int len) {
        char[] base = getBase();
        StringBuilder str = new StringBuilder();
        int[] array = shuffle(getFixedArray(0, 25));
        for(int i = 0; i < len; i++) {
            str.append(base[array[i]]);
        }
        return str.toString();
    }

    public static String getString(int len, boolean duplicate) {
        int[] array = getArray(len, true);
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < len; i++) {
            str.append((char)(array[i] % 26 + 'a'));
        }
        return str.toString();
    }

    public static int[][] getMatrix(int m, int n) {
        if(m * n <= 0) return new int[][]{};
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = getArray(n);
        }
        return matrix;
    }

    public static int[][] getSortedMatrix(int m, int n) {
        if(m * n <= 0) return new int[][]{};
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = getSortedArray(n);
        }
        return matrix;
    }

    public static void main(String[] args) {
        Utils.printArray(getArray(20));
        Utils.printArray(getSortedArray(20));
        Utils.printArray(getSortedArray(20, true));
    }
}
