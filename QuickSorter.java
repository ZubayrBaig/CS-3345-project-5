import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuickSorter {

    public enum PivotStrategy {FIRST_ELEMENT, RANDOM_ELEMENT, MEDIAN_OF_THREE_RANDOM_ELEMENTS, MEDIAN_OF_THREE_ELEMENTS }

    public static <E extends Comparable<E>> Duration timedQuickSort(ArrayList<E> list, PivotStrategy strategy) {
        if (list == null || strategy == null) {
            throw new NullPointerException("List or strategy cannot be null.");
        }

        long startTime = System.nanoTime();
        quickSort(list, 0, list.size() - 1, strategy);
        long endTime = System.nanoTime();
        return Duration.ofNanos(endTime - startTime);
    }

    private static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int low, int high, PivotStrategy strategy) {
        if (low < high) {
            if (high - low < 20) {
                insertionSort(list, low, high);
            } else {
                int pivotIndex = choosePivot(list, low, high, strategy);
                pivotIndex = partition(list, low, high, pivotIndex);
                quickSort(list, low, pivotIndex - 1, strategy);
                quickSort(list, pivotIndex + 1, high, strategy);
            }
        }
    }

    private static <E extends Comparable<E>> void insertionSort(ArrayList<E> list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            E key = list.get(i);
            int j = i - 1;
            while (j >= low && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    private static <E extends Comparable<E>> int choosePivot(ArrayList<E> list, int low, int high, PivotStrategy strategy) {
        switch (strategy) {
            case FIRST_ELEMENT:
                return low;
            case RANDOM_ELEMENT:
                return new Random().nextInt(high - low + 1) + low;
            case MEDIAN_OF_THREE_RANDOM_ELEMENTS:
                Random rand = new Random();
                int a = rand.nextInt(high - low + 1) + low;
                int b = rand.nextInt(high - low + 1) + low;
                int c = rand.nextInt(high - low + 1) + low;
                return median(list, a, b, c);
            case MEDIAN_OF_THREE_ELEMENTS:
                int mid = low + (high - low) / 2;
                return median(list, low, mid, high);
            default:
                throw new IllegalArgumentException("Invalid PivotStrategy");
        }
    }

    private static <E extends Comparable<E>> int median(ArrayList<E> list, int i, int j, int k) {
        E a = list.get(i), b = list.get(j), c = list.get(k);
        if (a.compareTo(b) < 0) {
            if (b.compareTo(c) < 0) return j;
            else if (a.compareTo(c) < 0) return k;
            else return i;
        } else {
            if (a.compareTo(c) < 0) return i;
            else if (b.compareTo(c) < 0) return k;
            else return j;
        }
    }

    private static <E extends Comparable<E>> int partition(ArrayList<E> list, int low, int high, int pivotIndex) {
        E pivot = list.get(pivotIndex);
        Collections.swap(list, pivotIndex, high);
        int storeIndex = low;
        for (int i = low; i < high; i++) {
            if (list.get(i).compareTo(pivot) < 0) {
                Collections.swap(list, i, storeIndex++);
            }
        }
        Collections.swap(list, storeIndex, high);
        return storeIndex;
    }

    public static ArrayList<Integer> generateRandomList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size has to be non-negative");
        }
        ArrayList<Integer> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        return list;
    }
}
