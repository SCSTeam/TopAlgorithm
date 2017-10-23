package design;

import common.NetNode;

import java.util.*;

public class PostOrderOfNaryTree {

    public List<Integer> postOrder(NetNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;

        Set<NetNode> addedListSet = new HashSet<>();
        Deque<NetNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            NetNode peek = stack.peek();
            if(!addedListSet.contains(peek)) {
                for(int i = peek.list.size() - 1; i >= 0; i--) {
                    stack.push(peek.list.get(i));
                }
                addedListSet.add(peek);
            }

            peek = stack.peek();
            if(addedListSet.contains(peek)) {
                res.add(stack.pop().val);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        NetNode root = new NetNode(3);

        NetNode node1 = new NetNode(2);
        NetNode node2 = new NetNode(4);
        NetNode node3 = new NetNode(1);
        NetNode node4 = new NetNode(5);


        NetNode node5 = new NetNode(6);
        NetNode node6 = new NetNode(2);
        NetNode node7 = new NetNode(7);
        NetNode node8 = new NetNode(8);

        root.list.add(node1);
        root.list.add(node2);
        root.list.add(node3);
        root.list.add(node4);

        node2.list.add(node5);
        node2.list.add(node6);
        node2.list.add(node7);

        node5.list.add(node8);

        PostOrderOfNaryTree app = new PostOrderOfNaryTree();
        for (Integer integer : app.postOrder(root)) {
            System.out.print(integer + " ");
        }
    }

}
