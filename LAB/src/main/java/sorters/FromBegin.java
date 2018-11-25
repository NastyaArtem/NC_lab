package sorters;

public class FromBegin extends BubbleSorter{
    public FromBegin(){
        nameOfSorter  = "Bubble sort, sorting start from begin";
    }
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
