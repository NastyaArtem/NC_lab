package sorters;

/**
 * Class extends {@link Merge} class. <br>
 * Parts sorting by recurse algorithm of quick sort.
 *
 * @author Artemenko Nastya
 * @see QuickSort
 */
public class MergeQuickSort extends Merge{
    public  MergeQuickSort(){
        nameOfSorter = "Merge sort with help of Quick Sort";
    }

    @Override
    protected void halfsFill(Integer []array) {
        QuickSort quickSort = new QuickSort();
        array = quickSort.sort(array);
    }
}
