package sorters;

/**
 * Class extends {@link Merge} class. <br>
 * Parts sorting by bubble sort with process from end.
 *
 * @author Artemenko Nastya
 * @see FromEnd
 */
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
