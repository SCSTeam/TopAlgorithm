package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeBuilder {

	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return null;
        
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else res.append("#,");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        
        String[] splits = data.split(",");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        queue.add(root);
        
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) continue;
            
            node.left = !"#".equals(splits[i]) ? new TreeNode(Integer.parseInt(splits[i])) : null;
            i++;
            queue.offer(node.left);
            
            node.right = !"#".equals(splits[i]) ? new TreeNode(Integer.parseInt(splits[i])) : null;
            i++;
            queue.offer(node.right);
        }
        
        return root;
    }

    public static void main(String[] args) {
        TreeNode app = deserialize("1,2,3,#,#,4,#,#,5,#,#");
        System.out.println(serialize(app));
    }
}
