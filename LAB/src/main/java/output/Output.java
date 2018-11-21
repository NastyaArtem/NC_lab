package output;

import analyzer.Analyzer;
import analyzer.ResultsFillers;

public class Output {
    Analyzer analyzer;
    public Output(int lenght){

        analyzer = new Analyzer();

        //set which fillers and sorters needed to analyze
        analyzer.sorted = true;
        analyzer.sortedWithX  = true;
        analyzer.reverseSorted = true;
        analyzer.randomNumbers = true;

        analyzer.bubbleBegin = true;
        analyzer.bubbleEnd = true;
        analyzer.quickSort = true;
        analyzer.javaSort = true;

        analyzer.mergeBubbleBegin = true;
        analyzer.mergeBubbleEnd = true;
        analyzer.mergeQuickSort = true;
        analyzer.mergeJavaSort = true;

        //counting results
        analyzer.proc(lenght);

        //output all results
        for(ResultsFillers temp: analyzer.results)
            System.out.println(temp.toString());
    }
}
