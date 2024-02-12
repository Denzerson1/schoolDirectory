package MergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {
    private List<T> list;
    public MergeSort(List<T> list) {
        this.list = list;
    }

    private void sort(List<T> a) {
        if (a.size() < 2){
            return;
        }

        int mid = a.size() / 2;
        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        for (int i = 0; i < mid; i++)
            left.add(a.get(i));

        for (int i = mid; i < a.size(); i++)
            right.add(a.get(i));

        sort(left);
        sort(right);
        merge(left, right, a);
    }

    private void merge(List<T> left, List<T> right, List<T> a) {
        int i = 0;
        int j = 0;
        int k = 0;


        while (i < left.size() && j < right.size()) {
            int compare = left.get(i).compareTo(right.get(j));
            if (compare <= 0) {
                a.set(k, left.get(i));
                i++;
            } else {
                a.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < left.size()) {
            a.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < right.size()) {
            a.set(k, right.get(j));
            j++;
            k++;
        }
    }

    public List<T> start() {
        sort(this.list);
        return this.list;
    }
}
