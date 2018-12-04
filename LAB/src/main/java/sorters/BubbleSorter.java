package sorters;

/**
 * Class extends {@link AbstractSorter}. That means that it needed to override method sort.<br>
 * BubbleSorter is abstract class. It is sorting with help of standard bubble sort.<br>
 *
 * @author Artemenko Nastya
 * @see FromBegin;
 * @see FromEnd;
 */
public abstract class BubbleSorter extends AbstractSorter {
    @Override
    public Integer[] sort(Integer[] array) {
        boolean isSwap = true; // flag for swap registration
        try {
            while (isSwap) {//process while have not no one swap at the cycle
                isSwap = false;
                isSwap = bubbleProc(isSwap, array);
            }
        } catch (NullPointerException e) {
            System.out.println("Array for sorting is null");
        }
        return array;
    }

    /**
     * Override by child classes: {@link FromBegin}{@link FromEnd}
     *
     * @param isSwap
     * @param array
     * @return
     */
    protected abstract boolean bubbleProc(boolean isSwap, Integer[] array);
}
