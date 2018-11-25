package sorters;


public abstract class AbstractSorter{

    public String nameOfSorter;

    protected Integer swap(Integer a, Integer b){
        return a;
    }
    public abstract Integer[] sort(Integer[] array);
}
/*public class Sorters {

    //bubble sort, process from the begin of array
    public Integer [] bubbleBegin(Integer [] array){
        boolean swap = true; // flag for swap registration

        while(swap){//process while have not no one swap at the cycle
            swap = false;
            for(int i = 0; i < array.length - 1; i++){
                if(array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        }
        return array;
    }

    //bubble sort, process from the end of array
    public Integer [] bubbleEnd(Integer [] array){
        boolean swap = true; // flag for swap registration

        while(swap){//process while have not no one swap at the cycle
            swap = false;
            for(int i = array.length - 1; i > 0; i--){
                if(array[i] < array[i - 1]){
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swap = true;
                }
            }
        }
        return array;
    }

    //Quick Sort methods
    Integer quickSortProc(int left, int right, Integer[] array){
        int current = left;
        int pivot = array[right - 1];
        int wall = left;
        for(int i = left; i < right; i++){
            if(array[current] >= pivot){
                current++;
            }else{
                int temp = array[current];
                array[current] = array[wall];
                array[wall] = temp;
                current++;
                wall++;
            }
        }
        int temp = array[wall];
        array[wall] = array[right - 1];
        array[right - 1] = temp;
        return wall;
    }

    void quickSortRec(int left, int right, Integer[] array){

        int pivotIndex = quickSortProc(left, right, array);

        if((pivotIndex - left) > 1){
            quickSortRec(left, pivotIndex, array);
        }
        if((right - pivotIndex) > 1){
            quickSortRec(pivotIndex + 1, right, array);
        }
    }

    //sort with help of standard java sorter
    public Integer[] javaSort(Integer[] array){
        Arrays.sort(array);
        return array;
    }

    //sort with merge
    public Integer[] merge(Integer [] array, String sortType){

        //separation into 2 sub arrays
        int middle = array.length/2;
        Integer[] leftArray = new Integer[middle];
        Integer[] rightArray = new Integer[array.length - middle];

        //coping array to sub arrays
        for(int i = 0; i < middle; i++){
            leftArray[i] = array[i];
        }
        for(int i = middle; i < array.length; i++){
            rightArray[i - middle] = array[i];
        }

        //sorting sub arrays by chosen sorter

            if(sortType.equals("BubbleBegin")){
                leftArray = this.bubbleBegin(leftArray);
                rightArray = this.bubbleBegin(rightArray);
            }else if(sortType.equals("BubbleEnd")){
                leftArray = this.bubbleEnd(leftArray);
                rightArray = this.bubbleEnd(rightArray);
            }else if(sortType.equals("QuickSort")){
                leftArray = this.quickSort(leftArray);
                rightArray = this.quickSort(rightArray);
            }else if(sortType.equals("JavaSort")){
                leftArray = this.javaSort(leftArray);
                rightArray = this.javaSort(rightArray);
            }


        mergeProcess(array, leftArray,rightArray);


        return array;
    }

    void mergeProcess(Integer[] array, Integer []leftArray, Integer[] rightArray){
        int middle = array.length/2;
        // iterator for array length
        int i = 0;
        // iterator for left sub array length
        int l = 0;
        // iterator for right sub array length
        int r = 0;
        while((i < array.length) && (l < middle) && (r < array.length - middle)){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                l++;
            }
            else{
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }

        //if right sub array elements are in main array, left array will be added to the end of array
        while(l < middle){
            array[i] = leftArray[l];
            i++;
            l++;
        }

        //if left sub array elements sre in main array, right array will be added to the end of array
        while(r < array.length - middle){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public Integer[] quickSort(Integer [] array){
        quickSortRec(0, array.length, array);
        return array;
    }

}*/
