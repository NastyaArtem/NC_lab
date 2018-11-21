package analyzer;

//class as a type for saving result of sorters working
 class ResultsSorters {
    private String sort;//sorter name
    private long result;//time of working

    ResultsSorters(){
        sort = new String();
    }

    void setSort(String sort){
        this.sort = sort;
    }
    void setResult(long result){
        this.result = result;
    }

    String getSort(){
        return sort;
    }
    long getResult(){
        return result;
    }

    @Override
    public String toString() {
        return (this.getSort() + ": " + this.getResult() + " milliseconds\n");
    }
}


