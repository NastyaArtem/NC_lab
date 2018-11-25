package analyzer;

import fillers.Fillers;
import sorters.*;

import java.util.Arrays;

public class Analyzer {
    //variables for analyze choose fillers and sorters
    public boolean sorted;
    public boolean sortedWithX;
    public boolean reverseSorted;
    public boolean randomNumbers;
    public boolean bubbleBegin;
    public boolean bubbleEnd;
    public boolean quickSort;
    public boolean javaSort;
    public boolean mergeBubbleBegin;
    public boolean mergeBubbleEnd;
    public boolean mergeQuickSort;
    public boolean mergeJavaSort;

    private int numberOfFillers = 0;
    private int numberOfSorters = 0;

    //counting fillers and sorters amount
    private void amountOfFillersSorters(){
        if(sorted)
            numberOfFillers++;
        if(sortedWithX)
            numberOfFillers++;
        if(reverseSorted)
            numberOfFillers++;
        if(randomNumbers)
            numberOfFillers++;

        if(bubbleBegin)
            numberOfSorters++;
        if(bubbleEnd)
            numberOfSorters++;
        if(quickSort)
            numberOfSorters++;
        if(javaSort)
            numberOfSorters++;
        if(mergeBubbleBegin)
            numberOfSorters++;
        if(mergeBubbleEnd)
            numberOfSorters++;
        if(mergeQuickSort)
            numberOfSorters++;
        if(mergeJavaSort)
            numberOfSorters++;
    }

    //array for saving results of sorters work
    public ResultsFillers[] results;


    public void proc(int lenght){
        amountOfFillersSorters();

        //array initialization
        results = new ResultsFillers[numberOfFillers];
        for(int i = 0; i < numberOfFillers; i++){
            results[i] = new ResultsFillers(numberOfSorters);
        }

        this.fill(lenght);
    }
    private void fill(int lenghtArray){
        Integer[] array;
        int i = 0;
        if(sorted){
            array = Fillers.sorted(lenghtArray);
            results[i].setFiller("Sorted Array");
            results[i].setResultsSorters(sort(array));
            i++;
        }
        if (sortedWithX){
            array = Fillers.sortedWhithX(lenghtArray);
            results[i].setFiller("Sorted Array with random number at the end");
            results[i].setResultsSorters(sort(array));
            i++;
        }
        if (reverseSorted){
            array = Fillers.reverseSorted(lenghtArray);
            results[i].setFiller("Reverse sorted Array");
            results[i].setResultsSorters(sort(array));
            i++;
        }
        if (randomNumbers){
            array = Fillers.randomNumbers(lenghtArray);
            results[i].setFiller("Array with random generate numbers");
            results[i].setResultsSorters(sort(array));
        }
    }

    private ResultsSorters[] sort(Integer[] array){
        ResultsSorters[] resultsSorters = new ResultsSorters[numberOfSorters];

        AbstractSorter sorter = new AbstractSorter() {
            @Override
            public Integer[] sort(Integer[] array) {
                return array;
            }
        };
        if(bubbleBegin){
            sorter = new FromBegin();
        }
        if(bubbleEnd){
            sorter = new FromEnd();
        }
        if(quickSort){
            sorter = new QuickSort();
        }
        if(javaSort){
            sorter = new JavaSort();
        }
        if(mergeBubbleBegin){
            sorter = new MergeBubbleFromBegin();
        }
        if(mergeBubbleEnd){
            sorter = new MergeBubbleFromEnd();
        }
        if(mergeQuickSort){
            sorter = new MergeQuickSort();
        }
        if(mergeJavaSort) {
            sorter = new MergeJavaSort();
        }

        for (int i = 0; i < numberOfSorters; i++){
            resultsSorters[i] = new ResultsSorters();
            long startTime = System.currentTimeMillis();
            sorter.sort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort(sorter.nameOfSorter);
        }



        /*
        int i = 0;
        if(bubbleBegin){
            FromBegin sorter = new FromBegin();
            long startTime = System.currentTimeMillis();
            sorter.sort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort(sorter.nameOfSorter);
            i++;
        }
        if(bubbleEnd){
            FromEnd sorter = new FromEnd();
            long startTime = System.currentTimeMillis();
            sorter.sort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start end");
            i++;
        }
        if(quickSort){
            long startTime = System.currentTimeMillis();
            sorter.quickSort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Quick Sort");
            i++;
        }
        if(javaSort){
            long startTime = System.currentTimeMillis();
            sorter.javaSort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Standard java sort");
            i++;
        }
        if(mergeBubbleBegin){
            long startTime = System.currentTimeMillis();
            sorter.merge(Arrays.copyOf(array, array.length), "BubbleBegin");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start begin with merge");
            i++;
        }
        if(mergeBubbleEnd){
            long startTime = System.currentTimeMillis();
            sorter.merge(Arrays.copyOf(array, array.length), "BubbleEnd");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start end with merge");
            i++;
        }
        if(mergeQuickSort){
            long startTime = System.currentTimeMillis();
            sorter.merge(Arrays.copyOf(array, array.length), "QuickSort");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Quick Sort with merge");
            i++;
        }
        if(mergeJavaSort){
            long startTime = System.currentTimeMillis();
            sorter.merge(Arrays.copyOf(array, array.length), "JavaSort");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Standard java sort with merge");
            i++;
        }*/

        return resultsSorters;
    }


}
