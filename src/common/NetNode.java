package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengzhou on 6/29/17.
 */
public class NetNode {
    public int val;
    public List<NetNode> list;

    public NetNode(int val) {
        this.val = val;
        list = new ArrayList<>();
    }
}
