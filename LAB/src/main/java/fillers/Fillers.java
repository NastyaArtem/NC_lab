package fillers;

import java.util.Random;

//class for filling arrays
public class Fillers {
    public static Integer [] sorted(int lenght){
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //first element is min, and another elements use it like base
        array[0] = random.nextInt(100);
        for(int i = 1; i < lenght; i++){
            array[i] = array[i-1] + random.nextInt(50);
        }
        return array;
    }

    public static Integer [] sortedWhithX(int lenght){
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //first element is min, and another elements use it like base
        array[0] = random.nextInt(100);
        for(int i = 1; i < lenght - 1; i++){
            array[i] = array[i-1] + random.nextInt(50);
        }

        //last number is random, it is lab task
        array[lenght - 1] = random.nextInt(100);
        return array;
    }

    public static Integer [] reverseSorted(int lenght){
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //last element is min, and another elements use it like base
        array[lenght - 1] = random.nextInt(100);
        for(int i = lenght - 2; i >= 0; i--){
            array[i] = array[i + 1] + random.nextInt(50);
        }
        return array;
    }

    public static Integer [] randomNumbers(int lenght){
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //all of numbers is random generated
        for(int i = 0; i < lenght; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

}
