package analyzer;

public class ResultsFillers {
    private String filler;//filler name
    private ResultsSorters[]  resultsSorters;//all result of sorters working
    ResultsFillers(int numberOfSorters){

        resultsSorters = new ResultsSorters[numberOfSorters];
    }

    void setFiller(String filler){
        this.filler = filler;
    }

    void setResultsSorters(ResultsSorters[] resultsSorters){
        this.resultsSorters = resultsSorters;
    }

    @Override
    public String toString() {
        String str;
        str = filler + ":\n\n";
        for(ResultsSorters temp: resultsSorters){
            str += temp.toString();
        }
        str += "------------";
        return str;
    }
}
