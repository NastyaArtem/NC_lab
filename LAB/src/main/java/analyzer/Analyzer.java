package analyzer;

import fillers.FillerAnnotation;
import fillers.Fillers;
import org.reflections.Reflections;
import sorters.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Class Analyzer can search all annotated method for filling array and
 * all not abstract classes for sorting arrays.
 *
 * <p>
 * It check time for process arrays with different length: 100, 1000, 10000
 * </p>
 *
 * @author Artemenko Nastya
 * @see Fillers
 * @see AbstractSorter
 */
public class Analyzer {

    final int MaxArrayLength = 10000;
    private int length;

    private int beginLength = 10;
    private int increaseValue = 2;

    private Map<String, Map<String, List<Long>>> result = new TreeMap<>();

    public Map<String, Map<String, List<Long>>> analize() {

        length = beginLength;

        Method[] fillersMethods = getFillerMethods();
        Set<Class<? extends AbstractSorter>> allSortClasses = getSorterClasses();

        //cycle for all classes which extends Abstract Sorter
        for (Method currentFillerMethod : fillersMethods) {

            Annotation[] annotations = currentFillerMethod.getDeclaredAnnotations();
            for (Annotation fillerAnnotation : annotations) {

                Map<String, List<Long>> allSortersResult = new TreeMap();
                for (Class<? extends AbstractSorter> currentSortClass : allSortClasses) {

                    //pass all abstract classes
                    if (!Modifier.isAbstract(currentSortClass.getModifiers())) {
                        List<Long> everyLengthResult = new ArrayList<>();
                        while (length < MaxArrayLength) {
                            length *= increaseValue;
                            sortingProcess(currentSortClass, currentFillerMethod, everyLengthResult);

                        }
                        try {
                            allSortersResult.put(currentSortClass.newInstance().toString(), everyLengthResult);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        length = beginLength;
                    }
                }

                result.put(currentFillerMethod.getAnnotation(FillerAnnotation.class).name(), allSortersResult);
            }
        }
        return result;

    }


    /**
     * @return return Set with types of all classes that extends AbstractSorter
     * @see AbstractSorter
     */
    // seeking all sub classes of Abstract Sorter
    private Set<Class<? extends AbstractSorter>> getSorterClasses() {
        Reflections reflections = new Reflections("sorters");
        return reflections.getSubTypesOf(AbstractSorter.class);
    }

    private Method[] getFillerMethods() {
        Method[] methods = (new Fillers()).getClass().getMethods();
        return methods;
    }

    private void sortingProcess(Class currentSortClass, Method currentFillerMethod, List<Long> everyLengthResult) {

        try {
            //exactly method sort
            Method methodSort = currentSortClass.getMethod("sort", Integer[].class);
            try {
                //initialization current array
                Integer[] currentArray = (Integer[]) currentFillerMethod.invoke(null, length);
                try {
                    //sorting current array

                    long startTime = System.nanoTime();
                    methodSort.invoke(currentSortClass.newInstance(), (Object) currentArray);
                    long resultTime = System.nanoTime() - startTime;

                    everyLengthResult.add(resultTime);

                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


    public int getBeginLength() {
        return beginLength;
    }

    public int getIncreaseValue() {
        return increaseValue;
    }

    public int getMaxArrayLength(){
        return MaxArrayLength;
    }
}