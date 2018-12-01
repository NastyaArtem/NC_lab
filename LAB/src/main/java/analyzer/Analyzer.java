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
        int N = 4;
        Fillers fillers = new Fillers();
        Method[] methods = fillers.getClass().getMethods();
        int length = 10;
        for (int i = 0; i < N; i++) {
            length *= 10;
            for (Method x : methods) {
                Annotation[] annotations = x.getDeclaredAnnotations();
                for (Annotation an : annotations) {

                    try {
                        Integer[] resultArray = (Integer[]) x.invoke(fillers, length);

                        Reflections reflections = new Reflections("sorters");
                        Set<Class<? extends AbstractSorter>> allClasses = reflections.getSubTypesOf(AbstractSorter.class);


                        for (Class<? extends AbstractSorter> currentClass : allClasses) {
                            if (!Modifier.isAbstract(currentClass.getModifiers())) {
                                //process
                                try {
                                    Method sortMethod = currentClass.getMethod("sort", Integer[].class);
                                    System.out.println(currentClass.getName() + " " + x.getName() + " " + length);
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                }

                            }
                        }


                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

