package sorters;

import java.util.Arrays;

public class JavaSort extends AbstractSorter{

    public JavaSort(){
        nameOfSorter = "Standard java sort";
    }
    @Override
    public Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        return array;
    }
}
