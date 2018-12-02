package analyzer;

import fillers.Fillers;
import org.reflections.Reflections;
import sorters.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Analyzer {

    public Analyzer() {

        // iterator for number of cycle with different length array
        int N = 1;

        //length of arrays for sorting
        int length = 10;
        while(N < 4){
            length *= 10;

            Set<Class<? extends AbstractSorter>> allClasses = getClasses();

            //cycle for all classes which extends Abstract Sorter
            for(Class<? extends AbstractSorter> currentSortClass: allClasses){

                //pass all abstract classes
                if(!Modifier.isAbstract(currentSortClass.getModifiers())){
                    try{

                        //exactly method sort
                        Method methodSort = currentSortClass.getMethod("sort", Integer[].class);

                        //seeking fillers
                        Method[] methods = (new Fillers()).getClass().getMethods();
                        for(Method currentFiller: methods){

                            Annotation[] annotations = currentFiller.getDeclaredAnnotations();
                            for(Annotation fillerAnnotation: annotations){
                                try {

                                    //initialization current array
                                    Integer[] currentArray = (Integer[]) currentFiller.invoke(null, length);
                                    try{
                                        //sorting current array
                                        methodSort.invoke(currentSortClass.newInstance(), (Object) currentArray);
                                    }catch (InstantiationException e){
                                        e.printStackTrace();
                                    }
                                }catch (IllegalAccessException e){
                                    e.printStackTrace();
                                }
                                catch (InvocationTargetException e){
                                    e.printStackTrace();
                                }
                            }
                        }

                    }catch(NoSuchMethodException e){
                        e.printStackTrace();
                    }
                }
            }
            N ++;
        }
    }


    // seeking all sub classes of Abstract Sorter
    private Set<Class <? extends AbstractSorter>>getClasses (){
        Reflections reflections = new Reflections("sorters");
        return reflections.getSubTypesOf(AbstractSorter.class);

    }

}

