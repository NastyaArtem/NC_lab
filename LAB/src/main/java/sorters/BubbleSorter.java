package sorters;

public abstract class BubbleSorter extends AbstractSorter {
    @Override
    public Integer[] sort(Integer[] array) {
        boolean isSwap = true; // flag for swap registration

        while(isSwap){//process while have not no one swap at the cycle
            isSwap = false;
            isSwap = bubbleProc(isSwap, array);
        }
        return array;
    }

    protected abstract boolean bubbleProc(boolean isSwap, Integer[] array);
}
