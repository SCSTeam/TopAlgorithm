
package common;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int label;
    public int key;
    public List<GraphNode> neighbors;

    public GraphNode(int x) {
        label = x;
        this.key = x;
        neighbors = new ArrayList<GraphNode>();
    }
};
