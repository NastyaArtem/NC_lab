package src.test;

import analyzer.Analyzer;
import fillers.Fillers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sorters.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AbstractSorterTest {

    @Test
    public void checkLength(){

        new FromBegin().sort(null);
        new FromEnd().sort(null);
        new QuickSort().sort(null);
        new JavaSort().sort(null);
        new MergeBubbleFromBegin().sort(null);
        new MergeBubbleFromEnd().sort(null);
        new MergeQuickSort().sort(null);
        new MergeJavaSort().sort(null);
    }
    @Test
    public void timeOutForSorters(){

        assertTimeout(Duration.ofSeconds(2), () -> {
            new FromBegin().sort(Fillers.randomNumbers(10));});

        assertTimeout(Duration.ofSeconds(2), () -> {
            new FromEnd().sort(Fillers.randomNumbers(10));});

        assertTimeout(Duration.ofSeconds(2), () -> {
            new QuickSort().sort(Fillers.randomNumbers(10));});

        assertTimeout(Duration.ofSeconds(2), () -> {
            new JavaSort().sort(Fillers.randomNumbers(10));});
    }

}