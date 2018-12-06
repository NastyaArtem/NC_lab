package sorters;

public class FromEnd extends BubbleSorter {
    public FromEnd(){
        nameOfSorter  = "Bubble sort, sorting start from begin";
    }
    @Override
    protected boolean bubbleProc(boolean isSwap, Integer[] array) {
        for(int i = array.length - 1; i > 0; i--){
            if(array[i] < array[i - 1]){
                array[i - 1] = swap(array[i], array[i] = array[i - 1]);
                isSwap = true;
            }
        }
        return isSwap;
    }
}
