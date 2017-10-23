package design.mock;

import common.Utils;

import java.util.LinkedList;
import java.util.List;

public class PrintNInAlphabeticalOrder {

    //               1        2  3  4  5  6  7  8  9
    //    10     11 12 .. 19
    // 100 101

    public List<Integer> alphabetOrder(int N) {
        List<Integer> res = new LinkedList<>();
        if(N < 1) return res;

        dfs(N, 0, 0, new int[]{0}, res);
        return res;
    }

    public void dfs(int N, int level, int num, int[] count, List<Integer> res) {
        if(count[0] > N) return;
        count[0]++;
        if(num > 0) res.add(num);

        for(int i = level == 0 ? 1 : 0; i < 10; i++) {
            int newNum = num * 10 + i;
            if(newNum > N) continue;
            dfs(N, level + 1, newNum, count, res);
        }
    }

    public static void main(String[] args) {
        PrintNInAlphabeticalOrder app = new PrintNInAlphabeticalOrder();
        Utils.printList(app.alphabetOrder(1000));
    }
}
