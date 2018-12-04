package sorters;

/**
 * Class extends {@link Merge} class. <br>
 * Parts sorting by standard java sort.
 *
 * @author Artemenko Nastya
 * @see JavaSort
 */
public class MergeJavaSort extends Merge {
    public MergeJavaSort(){
        nameOfSorter = "Merge sort with help of Java standard sorter";
    }

    @Override
    protected void halfsFill(Integer []leftArray, Integer[] rightArray) {
        JavaSort javaSort = new JavaSort();
        leftArray = javaSort.sort(leftArray);
        rightArray = javaSort.sort(rightArray);
    }
}
