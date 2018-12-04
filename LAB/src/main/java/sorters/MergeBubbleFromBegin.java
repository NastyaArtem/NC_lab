package sorters;

/**
 * Class extends {@link Merge} class. <br>
 * Parts sorting by bubble sort with process from begin.
 *
 * @author Artemenko Nastya
 * @see FromBegin
 */
public class MergeBubbleFromBegin extends Merge{
    public MergeBubbleFromBegin(){
        nameOfSorter = "Merge sort with help of bubble sort(process from begin)";
    }

    @Override
    protected void halfsFill(Integer []leftArray, Integer[] rightArray) {
        FromBegin fromBegin = new FromBegin();
        leftArray = fromBegin.sort(leftArray);
        rightArray = fromBegin.sort(rightArray);
    }
}
