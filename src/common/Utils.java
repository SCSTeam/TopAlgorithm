package common;

import java.util.*;

public class Utils {

	private Utils(){}

	public static void clearConsole() {
//		System.out.print("\033[H\033[2J");
//		for (int i = 0; i < 30; i++) {
//			System.out.println();
//		}
	}

	public static void main(String[] args) {
		printTree(buildTree("1, 2, 3, #, #, 4, #, #, 5"));
	}

	/**
	 * @param input [1,2,3,#,#,4,#,#,5]
	 * @return
	 * 		   1
	 * 		  / \
	 *  	 2   3
	 *  	    /
	 * 	       4
	 * 	        \
	 * 	         5
	 */
	public static TreeNode buildTree(String input) {
		return new TreeBuilder().buildTree(input);
	}

	/**
	 * @param root
	 * 		   1
	 * 		  / \
	 *  	 2   3
	 *  	    /
	 * 	       4
	 * 	        \
	 * 	         5
	 * @return [1,2,3,#,#,4,#,#,5]
	 */
	public static String printTree(TreeNode root) {
		return new TreeBuilder().printTree(root);
	}

	public static ListNode buildListNode(int[] arr) {
	    if(arr == null || arr.length == 0) return null;

	    ListNode root = new ListNode(0);
	    ListNode head = root;

	    for(int i = 0; i < arr.length; i++) {
	        head.next = new ListNode(arr[i]);
	        head = head.next;
	    }

	    return root.next;
	}

	public static void printListNode(ListNode node) {
		if(node == null) return;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static <T> void printList(List<T> list) {
	    if(list == null || list.size() == 0) return;
	    for (T t : list) {
            System.out.print(t.toString() + ", ");
        }
		System.out.println();
	}

	public static <T> void printArray(T[] ts) {
		if(ts == null) return;
		for (T t: ts) {
			System.out.print(t.toString() + " ");
		}
		System.out.println();
	}

	public static void printArray(int[] ts) {
		if(ts == null) return;
//		for (int t: ts) {
//			System.out.print(t + " ");
//		}
		System.out.println(Arrays.toString(ts));
	}

	public static void printMatrix(int[][] arr) {
		if(arr == null || arr.length == 0 || arr[0].length == 0) return;

		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void printMatrix(boolean[][] arr) {
		if(arr == null || arr.length == 0 || arr[0].length == 0) return;

		for(int i = 0; i <= arr.length; i++) {

			for(int j = 0; j <= arr[0].length; j++) {
				if(i == 0 && j == 0) System.out.print("\t");
				else if(i == 0) System.out.print(j - 1 + "\t");
				else if(j == 0) System.out.print( i - 1 + "\t");
				else System.out.print(arr[i - 1][j - 1] ? "T\t" : "-\t");
			}
			System.out.println();
		}
	}

	public static Object[] listToArray1(List<Object> list) {
		Object[] res = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static int[] listToArray(List<Integer> list) {
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static String reverse(StringBuilder builder, int start, int end) {
		for(int i = start; i < (start + end) / 2; i++) {
			char c = builder.charAt(i);
			builder.setCharAt(i, builder.charAt(end + start - i - 1));
			builder.setCharAt(end + start - i - 1, c);
		}

		return builder.toString();
	}

	public static List<String> arrayToList(String[] arr) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < arr.length; i++) {
			res.add(arr[i]);
		}

		return res;
	}

	public static Set<String> arrayToSet(String[] arr) {
		Set<String> res = new HashSet<String>();
		for (int i = 0; i < arr.length; i++) {
			res.add(arr[i]);
		}
		return res;
	}

	public static <T> void swap(T t1, T t2) {
		T t = null;
		t = t1;
		t1 = t2;
		t2 = t;
	}

	public static <T> void swap(T[] ts, int i, int j) {
		T t = ts[i];
		ts[i] = ts[j];
		ts[j] = t;
	}

	public static void swap(int[] ts, int i, int j) {
		int t = ts[i];
		ts[i] = ts[j];
		ts[j] = t;
	}
}