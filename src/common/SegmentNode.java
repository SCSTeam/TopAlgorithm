package common;

/**
 * Created by mengzhou on 6/29/17.
 */
public class SegmentNode {

    public int val;
    public int start, end;
    public int max, sum;
    public SegmentNode left, right;

    public SegmentNode(int val) {
        this.val = val;
    }

    public SegmentNode(int val, int start, int end) {
        this.val = val;
        this.start = start;
        this.end = end;
    }

    public SegmentNode(int val, int max) {
        this.val = val;
        this.max = max;
    }
}
