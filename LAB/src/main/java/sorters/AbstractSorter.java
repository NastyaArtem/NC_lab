package sorters;


public abstract class AbstractSorter{

    public String nameOfSorter;

    protected Integer swap(Integer a, Integer b){
        return a;
    }
    public abstract Integer[] sort(Integer[] array);
}
