package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private IntegerList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        list = new SortedIntList();
        totalAdded = 0;
    }

    public boolean add(int num) {
        totalAdded++;
        return list.add(num);
    }

    public boolean addAll(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
        return list.size() > 0;
    }


    public int get(int index) {
        return list.get(index);
    }

    public boolean remove(int num) {
        return list.remove(num);
    }

    public boolean removeAll(IntegerList list) {
        return list.removeAll(list);
    }

    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return this.totalAdded;
    }

}