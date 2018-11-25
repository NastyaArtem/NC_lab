package sorters;

public class QuickSort extends AbstractSorter {

    public QuickSort(){
        nameOfSorter = "Quick Sort";
    }
    @Override
    public Integer[] sort(Integer[] array) {
        quickSortRec(0, array.length, array);
        return array;
    }

    private Integer quickSortProc(int left, int right, Integer[] array){
        int current = left;
        int pivot = array[right - 1];
        int wall = left;
        for(int i = left; i < right; i++){
            if(array[current] >= pivot){
                current++;
            }else{
                array[current] = swap(array[wall], array[wall] = array[current]);
                current++;
                wall++;
            }
        }
        array[wall] = swap(array[right - 1], array[right - 1] = array[wall]);
        return wall;
    }

    private void quickSortRec(int left, int right, Integer[] array){

        int pivotIndex = quickSortProc(left, right, array);

        if((pivotIndex - left) > 1){
            quickSortRec(left, pivotIndex, array);
        }
        if((right - pivotIndex) > 1){
            quickSortRec(pivotIndex + 1, right, array);
        }
    }
}
