package analyzer;

import fillers.Fillers;
import org.reflections.Reflections;
import sorters.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * Class Analyzer can search all annotated method for filling array and
 * all not abstract classes for sorting arrays.
 *
 * <p>
 * It check time for process arrays with different length: 100, 1000, 10000
 *</p>
 *
 * @author Artemenko Nastya
 *
 * @see Fillers
 * @see AbstractSorter
 */
public class Analyzer {

    //length of arrays for sorting
    private int length = 10;

    public void analize(int amount) throws StackOverflowError{

        // iterator for number of cycle with different length array
        int n = 0;

        while (n < amount) {
            length *= 10;
            if(length > 10000){
                throw new StackOverflowError("large array for processing");
            }
            Set<Class<? extends AbstractSorter>> allClasses = getClasses();

            //cycle for all classes which extends Abstract Sorter
            for (Class<? extends AbstractSorter> currentSortClass : allClasses) {

                //pass all abstract classes
                if (!Modifier.isAbstract(currentSortClass.getModifiers())) {
                    try {
                        sortMethod(currentSortClass);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            n++;
        }
    }


    /**
     * @return return Set with types of all classes that extends AbstractSorter
     * @see AbstractSorter
     */
    // seeking all sub classes of Abstract Sorter
    private Set<Class<? extends AbstractSorter>> getClasses() {
        Reflections reflections = new Reflections("sorters");
        return reflections.getSubTypesOf(AbstractSorter.class);

    }

    /**
     * sortMethod search method "sort" at all for current processed class
     * @param currentSortClass Sort class that is processed at that time
     * @throws NoSuchMethodException
     */
    private void sortMethod(Class<? extends AbstractSorter> currentSortClass)
            throws NoSuchMethodException {

        //exactly method sort
        Method methodSort = currentSortClass.getMethod("sort", Integer[].class);

        //seeking fillers
        Method[] methods = (new Fillers()).getClass().getMethods();
        for (Method currentFiller : methods) {

            Annotation[] annotations = currentFiller.getDeclaredAnnotations();
            for (Annotation fillerAnnotation : annotations) {
                arrayForSorting(methodSort, currentFiller, currentSortClass);
            }
        }
    }

    /**
     * call filler class that is needed
     * @param methodSort is kind of sorter that is current
     * @param currentFiller method from filler class that is current
     * @param currentSortClass sort class that is current
     */
    private  void arrayForSorting(Method methodSort,Method currentFiller, Class<? extends AbstractSorter> currentSortClass){
        try {

            //initialization current array
            Integer[] currentArray = (Integer[]) currentFiller.invoke(null, length);
            sorting(methodSort, currentSortClass, currentArray);

        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
                e.printStackTrace();
        }
    }

    /**
     *  exactly process of sorting
     * @param methodSort method that is in use at that time
     * @param currentSortClass class for sort type
     * @param currentArray array that is sorting at that time
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private void sorting(Method methodSort, Class<? extends AbstractSorter> currentSortClass, Integer[] currentArray)
            throws IllegalAccessException, InvocationTargetException{
        try{
            //sorting current array
            methodSort.invoke(currentSortClass.newInstance(), (Object) currentArray);
        }catch (InstantiationException e){
            e.printStackTrace();
        }
    }
}



