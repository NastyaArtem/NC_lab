package sorters;

/**
 * Class extends {@link AbstractSorter}. That means that it needed to override method sort.<br>
 *     It uses recurse algorithm of quick sort
 * @author Artemenko Nastya
 */
public class QuickSort extends AbstractSorter {

    public QuickSort() {
        nameOfSorter = "Quick Sort";
    }

    /**
     * @param array that is sorting
     * @return sorted array
     */
    @Override
    public Integer[] sort(Integer[] array) {
        try {
            quickSortRec(0, array.length, array);

        } catch (NullPointerException e) {
            System.out.println("Array for sorting is null");
        }
        return array;
    }

    private Integer quickSortProc(int left, int right, Integer[] array) {
        int current = left;
        int pivot = array[right - 1];
        int wall = left;
        for (int i = left; i < right; i++) {
            if (array[current] >= pivot) {
                current++;
            } else {
                array[current] = swap(array[wall], array[wall] = array[current]);
                current++;
                wall++;
            }
        }
        array[wall] = swap(array[right - 1], array[right - 1] = array[wall]);
        return wall;
    }

    private void quickSortRec(int left, int right, Integer[] array) {

        int pivotIndex = quickSortProc(left, right, array);

        if ((pivotIndex - left) > 1) {
            quickSortRec(left, pivotIndex, array);
        }
        if ((right - pivotIndex) > 1) {
            quickSortRec(pivotIndex + 1, right, array);
        }
    }
}
