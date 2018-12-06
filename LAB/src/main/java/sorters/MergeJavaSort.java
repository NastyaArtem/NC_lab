package sorters;

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
