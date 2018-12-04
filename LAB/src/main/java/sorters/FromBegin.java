package sorters;

/**
 * Class extends {@link BubbleSorter}. That means that it needed to override method bubbleProc.<br>
 *     Processing from the begin of array. Array sorting from the first element till the last.
 * @author  Artemenko Nastya
 */
public class FromBegin extends BubbleSorter{
    public FromBegin(){
        nameOfSorter  = "Bubble sort, sorting start from begin";
    }

    /**
     *
     * @param isSwap used for identify if swaping done. When swap function not use array is sorted.
     * @param array for sorting
     * @return
     */
    @Override
    protected boolean bubbleProc(boolean isSwap, Integer[] array) {
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i + 1]){
                array[i + 1] = swap(array[i], array[i] = array[i + 1]);
                isSwap = true;
            }
        }
        return isSwap;
    }
}
