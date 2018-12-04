package sorters;

import java.util.Arrays;

/**
 * Class extends {@link AbstractSorter}. That means that it needed to override method sort.<br>
 *     It uses standard java sorter
 * @see Arrays
 * @author Artemenko Nastya
 */
public class JavaSort extends AbstractSorter {

    public JavaSort() {
        nameOfSorter = "Standard java sort";
    }

    /**
     * @param array that is sorting
     * @return sorted array
     */
    @Override
    public Integer[] sort(Integer[] array) {
        try {
            Arrays.sort(array);
        } catch (NullPointerException e) {
            System.out.println("Array for sorting is null");
        }
        return array;
    }
}
