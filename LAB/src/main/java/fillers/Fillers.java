package fillers;

import java.util.Random;

/**
 * Class with 4 static methods of filling arrays by Integer variables.<br>
 *     Every method is annotating by {@link FillerAnnotation}. Annotation have a name of each methods.<br>
 *
 * @author Artemenko Nastya
 */
//class for filling arrays
public class Fillers {

    /**
     * Create sorted array
     *
     * @param lenght amount of element of array
     * @return returns an array of the specified length
     */
    @FillerAnnotation(name = "Sorted array")
    public static Integer [] sorted(int lenght) throws NullPointerException{
        if(lenght == 0){
            throw new NullPointerException("length is equals 0");
        }
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //first element is min, and another elements use it like base
        array[0] = random.nextInt(100);
        for(int i = 1; i < lenght; i++){
            array[i] = array[i-1] + random.nextInt(50);
        }
        return array;
    }


    /**
     * Create sorted with random element at the end array
     *
     * @param lenght amount of element of array
     * @return returns an array of the specified length
     */
    @FillerAnnotation(name = "Sorted array with random element at the end")
    public static Integer [] sortedWhithX(int lenght) throws NullPointerException{
        if(lenght == 0){
            throw new NullPointerException("length is equals 0");
        }
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

    /**
     * Create reverse sorted array
     *
     * @param lenght amount of element of array
     * @return returns an array of the specified length
     */
    @FillerAnnotation(name = "Reverse sorted array")
    public static Integer [] reverseSorted(int lenght) throws NullPointerException{
        if(lenght == 0){
            throw new NullPointerException("length is equals 0");
        }
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //last element is min, and another elements use it like base
        array[lenght - 1] = random.nextInt(100);
        for(int i = lenght - 2; i >= 0; i--){
            array[i] = array[i + 1] + random.nextInt(50);
        }
        return array;
    }

    /**
     * Create array that consist of random elements
     *
     * @param lenght amount of element of array
     * @return returns an array of the specified length
     */
    @FillerAnnotation(name = "Array which consist of random elements")
    public static Integer [] randomNumbers(int lenght) throws NullPointerException{
        if(lenght == 0){
            throw new NullPointerException("length is equals 0");
        }
        Random random = new Random();
        Integer[] array = new Integer[lenght];

        //all of numbers is random generated
        for(int i = 0; i < lenght; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

}
