package design;

import common.NetNode;

import java.util.LinkedList;
import java.util.Queue;

public class NaryTreeSerializable {

    //             0
    //       1      2     3
    //     4  5     6   7 8 9
    //
    //  0 1 4 # 5 # # 2 6 # # 3 7 # 8 # 9 # # #
    public static String serializeTree(NetNode root) {
        if (root == null) return "#";

        StringBuilder result = new StringBuilder(root.val + " ");
        for (NetNode child : root.list) {
            result.append(serializeTree(child));
        }

        return result.append("# ").toString();
    }

    public static void main(String[] args) {
        NetNode root  = new NetNode(0);
        NetNode node1 = new NetNode(1);
        NetNode node2 = new NetNode(2);
        NetNode node3 = new NetNode(3);
        NetNode node4 = new NetNode(4);
        NetNode node5 = new NetNode(5);
        NetNode node6 = new NetNode(6);
        NetNode node7 = new NetNode(7);
        NetNode node8 = new NetNode(8);
        NetNode node9 = new NetNode(9);

        root.list.add(node1);
        root.list.add(node2);
        root.list.add(node3);

        node1.list.add(node4);
        node1.list.add(node5);

        node2.list.add(node6);
        node3.list.add(node7);
        node3.list.add(node8);
        node3.list.add(node9);

        System.out.println(serializeTree(root));

//        NetNode node = deserialize("0 1 4 # 5 # # 2 6 # # 3 7 # 8 # 9 # # #");
//        System.out.println(serializeTree(node));
    }

    // 0 1 4 # 5 # # 2 6 # # 3 7 # 8 # 9 # # #
    public static NetNode deserialize(String input) {
        if (input.length() == 0 || "#".equals(input)) return null;
        String[] split = input.split(" ");
        return dfs(split, new int[]{ -1 });
    }

    public static NetNode dfs(String[] split, int[] index) {
        if (index[0] >= split.length - 1) return null;
        index[0]++;

        if (!"#".equals(split[index[0]])) {
            NetNode root = new NetNode(Integer.parseInt(split[index[0]]));
            while (true) {
                NetNode node = dfs(split, index);
                if(node == null) break;
                root.list.add(node);
            }
            return root;
        }

        return null;
    }

}
