package analyzer;

public class ResultsFillers {
    private String filler;//filler name
    private ResultsSorters[]  resultsSorters;//all result of sorters working
    ResultsFillers(int numberOfSorters){

        filler = new String();
        resultsSorters = new ResultsSorters[numberOfSorters];
    }

    void setFiller(String filler){
        this.filler = filler;
    }

    void setResultsSorters(ResultsSorters[] resultsSorters){
        this.resultsSorters = resultsSorters;
    }

    String getFiller(){
        return filler;
    }

    ResultsSorters[] getResultsSorters(){
        return resultsSorters;
    }

    @Override
    public String toString() {
        String str = new String();
        str = this.getFiller() + ":\n\n";
        for(ResultsSorters temp: this.resultsSorters){
            str += temp.toString();
        }
        str += "------------";
        return str;
    }
}
