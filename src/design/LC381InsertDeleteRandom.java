package design;

import java.util.*;

public class LC381InsertDeleteRandom {

    List<Integer> numArray;
    Map<Integer, Set<Integer>> indexMap;
    Random rand = new Random();

    public LC381InsertDeleteRandom() {
        numArray = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public boolean insert(int key) {
        boolean contain = indexMap.containsKey(key);
        if (!contain) indexMap.put(key, new HashSet<>());
        indexMap.get(key).add(numArray.size());
        numArray.add(key);
        return !contain;
    }

    public boolean remove(int key) {
        Set<Integer> posList = indexMap.get(key);
        if (posList == null) return false;
        Integer next = posList.iterator().next();
        posList.remove(next);

        int lastIndex = numArray.size() - 1;
        Set<Integer> update = indexMap.get(numArray.get(lastIndex));
        update.add(next);
        update.remove(lastIndex);

        numArray.set(next, numArray.get(lastIndex));
        numArray.remove(lastIndex);
        if(posList.isEmpty()) indexMap.remove(key);
        return true;
    }

    public int getRandom() {
        if(numArray.size() == 0) return -1;
        return numArray.get(rand.nextInt(numArray.size()));
    }

}
