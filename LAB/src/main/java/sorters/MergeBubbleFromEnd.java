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
    protected void halfsFill(Integer []array) {
        FromEnd fromEnd = new FromEnd();
        array = fromEnd.sort(array);
    }
}
