package sorters;

public class MergeQuickSort extends Merge{
    public  MergeQuickSort(){
        nameOfSorter = "Merge sort with help of Quick Sort";
    }

    @Override
    protected void halfsFill(Integer []leftArray, Integer[] rightArray) {
        QuickSort quickSort = new QuickSort();
        leftArray = quickSort.sort(leftArray);
        rightArray = quickSort.sort(rightArray);
    }
}
