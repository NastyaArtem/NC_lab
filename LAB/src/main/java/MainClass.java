import output.Output;
import sorters.*;

public class MainClass {
    public static void main(String[] args) {
       //Output output = new Output(10000);
        Integer[] array = {5, 6, 8, 2, 4, 0};
        QuickSort s = new QuickSort();
        s.sort(array);
        for(int x:array)
        System.out.println(x);

    }
}
