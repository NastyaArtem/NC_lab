package sorters;

public abstract class Merge extends AbstractSorter{
    @Override
    public Integer[] sort(Integer[] array) {
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

        halfsFill(leftArray, rightArray);


        mergeProcess(array, leftArray,rightArray);


        return array;
    }

    private void mergeProcess(Integer[] array, Integer []leftArray, Integer[] rightArray){
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

    protected abstract void halfsFill(Integer []leftArray, Integer[] rightArray);

}
