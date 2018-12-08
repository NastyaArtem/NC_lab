package sorters;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * Class extends {@link AbstractSorter}. That means that it needed to override method sort.<br>
 * Merge is abstract class. <br>
 * Array divide into 2 parts. Every part sorts by methods which realize at extend classes.<br>
 * After processing parts merge into one sorted array
 *
 * @author Artemenko Nastya
 * @see MergeBubbleFromBegin;
 * @see MergeBubbleFromEnd;
 * @see MergeQuickSort;
 * @see MergeJavaSort;
 */
public abstract class Merge extends AbstractSorter {

    private int amountOfSubarrays;
    private int lengthOfSubarrays;

    private List<Integer[]> arrayParts;

    @Override
    public Integer[] sort(Integer[] array) {

        arrayParts = new ArrayList<>();

        amountOfSubarrays = Runtime.getRuntime().availableProcessors();
        if(amountOfSubarrays < 2){
            amountOfSubarrays = 2;
        }
        lengthOfSubarrays = array.length / amountOfSubarrays;
        createParts(array);
        sortAllParts();

        partsMerge();
        return array;
    }

    private void createParts(Integer[] array) {

        int currentAmontOfSubarrays = amountOfSubarrays;
        int iterForMainArray = 0;
        while (currentAmontOfSubarrays > 1) {
            Integer[] currentSubArray = new Integer[lengthOfSubarrays];
            for (int i = 0; i < lengthOfSubarrays; i++) {
                currentSubArray[i] = array[iterForMainArray++];
            }
            arrayParts.add(currentSubArray);
            currentAmontOfSubarrays--;
        }
        Integer[] lastSubarray = new Integer[array.length - iterForMainArray];
        for (int i = 0; i < lastSubarray.length; i++) {
            lastSubarray[i] = array[iterForMainArray++];
        }
        arrayParts.add(lastSubarray);
    }

    private synchronized void sortAllParts() {
        List<Thread> sortThreads = new ArrayList<>();
        for (Integer[] subarray : arrayParts) {
            Thread currentThread = new Thread(new SorterThread(subarray));
            currentThread.start();
            sortThreads.add(currentThread);

        }
        try {
            for (Thread currentThread : sortThreads) {
                currentThread.join();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private synchronized Integer[] partsMerge() {

        while(arrayParts.size() > 1){
            Integer[] resultArray = mergeProcess(arrayParts.get(0), arrayParts.get(1));
            arrayParts.remove(0);
            arrayParts.remove(0);
            arrayParts.add(resultArray);
        }
        return arrayParts.get(0);
    }

    private Integer[] mergeProcess(Integer[] leftArray, Integer[] rightArray) {
        Integer[] array = new Integer[leftArray.length + rightArray.length];
        // iterator for array length
        int i = 0;
        // iterator for left sub array length
        int l = 0;
        // iterator for right sub array length
        int r = 0;
        while ((i < array.length) && (l < leftArray.length) && (r < rightArray.length)) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                l++;
            } else {
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }

        // if right sub array elements are in main array, left array will be added to the end of array

        while (l < leftArray.length) {
            array[i] = leftArray[l];
            i++;
            l++;
        }

        //if left sub array elements sre in main array, right array will be added to the end of array

        while (r < rightArray.length) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
        return array;
    }

    protected abstract void halfsFill(Integer[] array);

    private class SorterThread implements Runnable{
        private Integer[] array;
        SorterThread(Integer[] array){
            this.array = array;
        }
        @Override
        public void run() {

            halfsFill(array);
        }

        public Integer[] getArray() {
            return array;
        }
    }

}
