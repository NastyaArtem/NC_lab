package analyzer;

import fillers.Fillers;
import sorters.Sorters;

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
    void amountOfFillersSorters(){
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
    void fill(int lenghtArray){
        Fillers fillers = new Fillers();
        Integer[] array;
        int i = 0;
        if(sorted){
            array = fillers.sorted(lenghtArray);
            results[i].setFiller("Sorted Array");
            results[i].setResultsSorters(sort(array));
            i++;
        }
        if (sortedWithX){
            array = fillers.sortedWhithX(lenghtArray);
            results[i].setFiller("Sorted Array with random number at the end");
            results[i].setResultsSorters(sort(array));
            i++;
        }
        if (reverseSorted){
            array = fillers.reverseSorted(lenghtArray);
            results[i].setFiller("Reverse sorted Array");
            results[i].setResultsSorters(sort(array));
            i++;
        }
        if (randomNumbers){
            array = fillers.randomNumbers(lenghtArray);
            results[i].setFiller("Array with random generate numbers");
            results[i].setResultsSorters(sort(array));
            i++;
        }
    }

    ResultsSorters[] sort(Integer[] array){
        ResultsSorters[] resultsSorters = new ResultsSorters[numberOfSorters];
        for (int i = 0; i < numberOfSorters; i++){
            resultsSorters[i] = new ResultsSorters();
        }
        Sorters sorters = new Sorters();
        int i = 0;
        if(bubbleBegin){
            long startTime = System.currentTimeMillis();
            sorters.bubbleBegin(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start begin");
            //System.out.println(endTime  + " " +  startTime);
            i++;
        }
        if(bubbleEnd){
            long startTime = System.currentTimeMillis();
            sorters.bubbleEnd(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start end");
            i++;
        }
        if(quickSort){
            long startTime = System.currentTimeMillis();
            sorters.quickSort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Quick Sort");
            i++;
        }
        if(javaSort){
            long startTime = System.currentTimeMillis();
            sorters.javaSort(Arrays.copyOf(array, array.length));
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Standard java sort");
            i++;
        }
        if(mergeBubbleBegin){
            long startTime = System.currentTimeMillis();
            sorters.merge(Arrays.copyOf(array, array.length), "BubbleBegin");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start begin with merge");
            i++;
        }
        if(mergeBubbleEnd){
            long startTime = System.currentTimeMillis();
            sorters.merge(Arrays.copyOf(array, array.length), "BubbleEnd");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Bubble Sort start end with merge");
            i++;
        }
        if(mergeQuickSort){
            long startTime = System.currentTimeMillis();
            sorters.merge(Arrays.copyOf(array, array.length), "QuickSort");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Quick Sort with merge");
            i++;
        }
        if(mergeJavaSort){
            long startTime = System.currentTimeMillis();
            sorters.merge(Arrays.copyOf(array, array.length), "JavaSort");
            long endTime = System.currentTimeMillis();
            resultsSorters[i].setResult(endTime - startTime);
            resultsSorters[i].setSort("Standard java sort with merge");
            i++;
        }

        return resultsSorters;
    }


}
