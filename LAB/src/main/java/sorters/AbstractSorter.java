package sorters;

/**
 * It is abstract class. AbstractSorter is a base for all of sorter class.<br>
 *
 * @author Artemenko Nastya
 */
public abstract class AbstractSorter{

    protected String nameOfSorter;

    /**
     * function for replace 2 variables.<br>
     *    for using: y = swap(a, a = y)
     * @param a - first element
     * @param b - second element
     * @return
     */
    protected Integer swap(Integer a, Integer b){
        return a;
    }

    /**
     * Abstract method that realize at child slasses.
     * @param array that is sorting
     * @return sorted array
     */
    public abstract Integer[] sort(Integer[] array);

    @Override
    public String toString() {
        return nameOfSorter;
    }
}
