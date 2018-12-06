package sorters;

public class MergeBubbleFromEnd extends Merge{
    public MergeBubbleFromEnd(){
        nameOfSorter = "Merge sort with help of bubble sort(process from end)";
    }

    @Override
    protected void halfsFill(Integer []leftArray, Integer[] rightArray) {
        FromEnd fromEnd = new FromEnd();
        leftArray = fromEnd.sort(leftArray);
        rightArray = fromEnd.sort(rightArray);
    }
}
