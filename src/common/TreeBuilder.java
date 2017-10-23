package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengzhou on 7/1/17.
 */
public class TreeBuilder {

    private TreeNode root;

    public TreeBuilder() {
    }

    public TreeBuilder(int[] values) {
        for (int i : values)
            addNode(i);
    }

    public void addNode(int item) {
        if (root == null) {
            root = new TreeNode(item);
            return;
        }

        TreeNode node = root;
        while (true) {
            if (item < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(item);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(item);
                    break;
                }
                node = node.right;
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode buildTree(int[] values) {
        if (values == null || values.length == 0) return null;
        for (int i : values)
            addNode(i);
        return root;
    }

    public TreeNode buildTree(String input) {
        System.out.println(" input: " + input);
        if (input == null || input.length() == 0) return null;
        if ("#".equals(input.charAt(0))) return null;

        String[] split = input.trim().split("[, ]+");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);

        for (int i = 1; i < split.length; i++) {
            TreeNode node = queue.poll();
            String value = split[i];
            if (!"#".equals(value)) {
                node.left = new TreeNode(Integer.parseInt(value));
                queue.add(node.left);
            }
            if (++i >= split.length) continue;
            value = split[i];
            if (!"#".equals(value)) {
                node.right = new TreeNode(Integer.parseInt(value));
                queue.add(node.right);
            }
        }

        return root;
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
    public String printTree(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ", ");
                queue.add(node.left);
                queue.add(node.right);
            } else res.append("#, ");
        }
        char c = ' ';
        while (!Character.isDigit(c)) {
            res.deleteCharAt(res.length() - 1);
            c = res.charAt(res.length() - 1);
        }
        System.out.println("output: " + res.toString());
        return res.toString();
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null)
                return root.left == null ? root.right : root.left;

            TreeNode minNode = findSmallest(root.right);
            root.val = minNode.val;
            root.right = delete(root.right, root.val);
        }

        return root;
    }

    private TreeNode findSmallest(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
}
