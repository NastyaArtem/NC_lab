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

        return resultsSorters;
    }


}
